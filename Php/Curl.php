<?php

use Firebase\JWT\JWT;

class Curl
{

	private $ch, $apikey, $url, $data, $cache, $debug;
	public $domain;

	function __construct($apikey, $url, $cache = false)
	{
		$this->apikey 	= $apikey;
		$this->url 		= $url;
		$this->cache 	= $this->setCache($cache);
		$this->debug 	= isset($_SESSION['test_mode']) && is_bool($_SESSION['test_mode']) && $_SESSION['test_mode'] ? true : false;
		$this->domain   = $this->getDomain();
		$this->ch 		= curl_init();
		curl_setopt($this->ch, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($this->ch, CURLOPT_SSL_VERIFYPEER, false);
		curl_setopt($this->ch, CURLOPT_TIMEOUT_MS, 120000);
		curl_setopt($this->ch, CURLOPT_FOLLOWLOCATION, true);
		curl_setopt($this->ch, CURLOPT_HTTPHEADER, array(
			'Content-Type: application/json',
			'ApiKey: ' . $this->apikey,
			'Domain: ' . $this->apikey
		));
		$this->data["device"] = isset($_SERVER['HTTP_USER_AGENT']) ? $_SERVER['HTTP_USER_AGENT'] : "bilgi yok";
		$this->data['ip_address'] = $this->getIpAddressPoint();
	}

	// Url değiştir
	public function url($url)
	{
		$this->url = $url;
	}

	// Cache durumunu değiştir
	public function cache($cache)
	{
		$this->cache = $this->setCache($cache);
	}

	// Cache durumuna göre get istekleri 
	// $cache parametresi bağzı isteklerde cache delmek içindir. $this->cache ile eşitlenmemelidir.
	public function get($action, $cache = false)
	{
		$result = $this->getCache($action);
		if ((!empty($result['status']) && $result['status'] == 'empty') || isset($_GET['refresh'])) {
			$cache = true;
		}
		if (!$result || $cache) {
			curl_setopt($this->ch, CURLOPT_URL, $this->url . $action);
			curl_setopt($this->ch, CURLOPT_CUSTOMREQUEST, "GET");
			$result = curl_exec($this->ch);
			$result = json_decode($result, true);
			$result = empty($result) ? ['status' => 'empty'] : $result;
			if ($this->cache) {
				Cache::write($this->cacheKey($action), $result);
				$this->cacheList($this->cacheKey($action), $action);
			}
		}
		if (isset($result['status']) && $result['status'] === 'empty') {
			$result = NULL;
		}
		$this->debug($action); // test_mode aktif ise
		return $result;
	}

	// post
	public function post($action, $data = [])
	{
		if (!empty($data)) {
			$data = array_merge($this->data, $data);
			curl_setopt($this->ch, CURLOPT_URL, $this->url . $action);
			curl_setopt($this->ch, CURLOPT_CUSTOMREQUEST, "POST");
			curl_setopt($this->ch, CURLOPT_POSTFIELDS, json_encode($data));
			$result = curl_exec($this->ch);
			$result = json_decode($result, true);
			return $result;
		}
	}

	// put
	public function put($action)
	{
		curl_setopt($this->ch, CURLOPT_URL, $this->url . $action);
		curl_setopt($this->ch, CURLOPT_CUSTOMREQUEST, "PUT");
		$result = curl_exec($this->ch);
		$result = json_decode($result, true);
		return $result;
	}

	// delete
	public function delete($action)
	{
		curl_setopt($this->ch, CURLOPT_URL, $this->url . $action);
		curl_setopt($this->ch, CURLOPT_CUSTOMREQUEST, "DELETE");
		$result = curl_exec($this->ch);
		$result = json_decode($result, true);
		return $result;
	}

	// curl kapat
	public function close()
	{
		curl_close($this->ch);
	}

	// cache oku
	private function getCache($action)
	{
		$result = false;
		if ($this->cache) {
			$result = Cache::read($this->cacheKey($action));
		}
		return $result;
	}

	// cache key oluştur
	private function cacheKey($action)
	{
		if ($action == "ip_ban_list") {
			return $action;
		}
		$cacheKey = str_replace(['?', '&', '=', '/', ',', '.'], ['-', '-', '-', '-', '-', '-'], $action);
		if ($action == "company/domain") {
			return $this->getDomain() . $cacheKey;
		}
		return $this->apikey . $cacheKey;
	}

	// cache durumunu set et
	private function setCache($cache)
	{
		if ($cache) {
			if (!empty($_GET['key'])) {
				$cache = false;
			}
		}
		return $cache;
	}

	// test mode aktif ise
	private function debug($action)
	{
		if ($this->debug) {
			$debug = $this->cacheKey($action);
			$debug = str_replace($this->apikey, '', $debug);
			echo "<pre>" . $debug . "</pre>";
		}
	}
	// cache listesli oluşturuluyor //
	private function cacheList($key, $action)
	{
		if ($action == 'company/domain') {
			$cacheListKey = $this->getDomain() . 'cache_list';
		} else {
			$cacheListKey = $this->apikey . 'cache_list';
		}
		$result = Cache::read($cacheListKey);
		$keyList = [];
		if (!empty($result)) {
			$result = json_decode($result, true);
			$keyList = $result;
			if (in_array($key, $result)) {
				unset($keyList[array_search($key, $result)]);
			}
		}
		$keyList[] = $key;
		Cache::write($cacheListKey, json_encode($keyList));
	}
	// user ip adresini al
	private function getIpAddressPoint()
	{ // noktalı
		if (!empty($_SERVER['HTTP_CLIENT_IP'])) {
			$ip = $_SERVER['HTTP_CLIENT_IP'];
		} elseif (!empty($_SERVER['HTTP_X_FORWARDED_FOR'])) {
			$ip = $_SERVER['HTTP_X_FORWARDED_FOR'];
		} else {
			$ip = $_SERVER['REMOTE_ADDR'];
		}
		return $ip;
	}

	// domain
	private function getDomain()
	{
		try {
			$decoded = JWT::decode($this->apikey, 'Hak.Geldi.Batil.Zail.Oldu.', array("HS256"));
			return str_replace(['?', '&', '=', '/', ',', '.'], ['-', '-', '-', '-', '-', '-'], $decoded->domain);
		} catch (\Throwable $th) {
			return false; //$th->getMessage();
		}
	}

	// log yaz
	private function writeLog($action)
	{
		$iplog = fopen("getlog.txt", "a");
		fwrite($iplog, $this->apikey . ' : ' . $action . "\r\n");
		fclose($iplog);
	}
}
