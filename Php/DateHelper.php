<?php

require_once ROOT . DS . APP_DIR . DS . 'Vendor' . DS . 'XLSWriter'. DS .'xlsxwriter.class.php';

class DateHelperComponent extends Component
{

	public $months = array(
		'January'       =>    'Ocak',
		'February'      =>    'Şubat',
		'March'         =>    'Mart',
		'April'         =>    'Nisan',
		'May'           =>    'Mayıs',
		'June'          =>    'Haziran',
		'July'          =>    'Temmuz',
		'August'        =>    'Ağustos',
		'September'     =>    'Eylül',
		'October'       =>    'Ekim',
		'November'      =>    'Kasım',
		'December'      =>    'Aralık'
	);
	public $weeks = array(
		'Monday'        =>    'Pazartesi',
		'Tuesday'       =>    'Salı',
		'Wednesday'     =>    'Çarşamba',
		'Thursday'      =>    'Perşembe',
		'Friday'        =>    'Cuma',
		'Saturday'      =>    'Cumartesi',
		'Sunday'        =>    'Pazar'
	);

    public function initialize(Controller $controller)
    {
        $this->controller = $controller;
		$this->request = $this->controller->request;
	}
	
    // recursive fonksiyon. array içinden istenen key'in değerini alıyoruz.
	public function findArray($array, $findKey){
		foreach ($array as $key => $val) {
			if($key==$findKey){
				if(is_array($val)){
					return $this->findArray($val, $findKey);
				}
				return $val;
			}
			if(is_array($val)){
				return $this->findArray($val, $findKey);
			}
		}
    }
    
    // Belirtilen yıl ve ayın çarşamba günlerini key olarak, haftabaşı ve haftasonu tarihlerinide değer olarak geriye dizi döner.
	public function getWednesdays($y, $m){
		$wednesday = [];
		$begin = new DateTime("first wednesday of $y-$m");
		$end = new DateTime("last day of $y-$m");
		$end->setTime(0,0,1);
		$interval = DateInterval::createFromDateString('next wednesday');
		$results = new DatePeriod($begin, $interval, $end);
		foreach ($results as $value) {
			$monday = strtotime($value->format("d-m-Y")."-10days");
			$sunday = strtotime($value->format("d-m-Y")."-4days");
			$wednesday[$value->format("d-m-Y")]["monday"] = date("d-m-Y",$monday);
			$wednesday[$value->format("d-m-Y")]["sunday"] = date("d-m-Y",$sunday);
		}
		$wednesday['last']['monday'] = date('d-m-Y',strtotime("this week"));
		$wednesday['last']['sunday'] = date('d-m-Y',strtotime("this week +6 days"));
		$wednesday['last']['first'] = date("Y-m-d", strtotime("wednesday ".$y."-".$m." -9 days"));
		$wednesday['last']['last'] = date("Y-m-d", strtotime("last wednesday ".$y."-".($m+1)." +5 days"));
		if($m==12){
			$wednesday['last']['last'] = date("Y-m-d", strtotime("last wednesday ".($y+1)."-".(1)." +5 days"));
		}else{
			$wednesday['last']['last'] = date("Y-m-d", strtotime("last wednesday ".$y."-".($m+1)." +5 days"));
		}
		return $wednesday;
    }
	
	// Belirtilen yılın tüm ayları için çarşamba günlerini key olarak, haftabaşı ve haftasonu tarihlerinide değer olarak geriye dizi döner.
	public function getYearWeek($y){
		$years = [];
		$i = 1;
		foreach ($this->months as $key => $value) {
			$years[$value] = $this->getWednesdays($y, $i);
			$i++;
		}
		$years['last']['first'] = date("Y-m-d", strtotime("last wednesday ".($y)."-01 -3 days"));
		$years['last']['last'] = date("Y-m-d", strtotime("last wednesday ".($y+1)."-01 +5 days"));
		return $years;
	}

	// verilen ay ve yıl değerlerine göre ayı haftalara bölerek geriye array olarak dönüyor.
	public function getMonthWeeksDay($m,$y){
		$zaman = mktime(0,0,0,$m,1,$y);
		$maxgun = date("t",$zaman);
		$buay = getdate ($zaman);
		$ilkgun  = $buay['wday'];
		$weeks = [];
		$say=0;
		for ($i=0; $i<($maxgun+$ilkgun); $i++) {
			if(!($i < $ilkgun)){
				if(!array_key_exists($say.".hafta",$weeks)) $weeks[$say.".hafta"]["days"] = [];
				array_push($weeks[$say.".hafta"]["days"],($i - $ilkgun + 1));
			}
			if(($i % 7) == 0 ) $say++;
		}
		return $weeks;
    }
	
	// Ay ve Günlerin ingilizce key'in türkçe value'si
    public function getDateLang($key){
        if(array_key_exists($key,$this->months)){
            $key = $this->months[$key];
        }
        if(array_key_exists($key,$this->weeks)){
            $key = $this->weeks[$key];
        }
        return $key; 
	}

	public function export($weeks){
		$columns=array(
			'SALE ID',
			'PAYMENT ID',
			'TARIH',
			'TUTAR'
		);
		$payments = [];
		$refunds = [];
		for ($i=0; $i<count($weeks['payments']['saleid']); $i++) { 
			array_push($payments,[
				$weeks['payments']['saleid'][$i],
				$weeks['payments']['paymentid'][$i],
				$weeks['payments']['date'][$i],
				str_replace('.',',',$weeks['payments']['price'][$i])
			]);
		}
		for ($i=0; $i<count($weeks['refunds']['saleid']); $i++) { 
			array_push($refunds,[
				$weeks['refunds']['saleid'][$i],
				$weeks['refunds']['paymentid'][$i],
				$weeks['refunds']['date'][$i],
				str_replace('.',',',$weeks['refunds']['price'][$i])
			]);
		}
		$exportFileName = $weeks['title'].'.xlsx';
		header('Content-Encoding: UTF-8');
		header('Content-disposition: attachment; filename="'.XLSXWriter::sanitize_filename($exportFileName).'"');
		header("Content-Type: application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		header('Content-Transfer-Encoding: binary');
		header('Cache-Control: must-revalidate');
		header('Pragma: public');
		$writer = new XLSXWriter();
		$writer->writeSheetRow('Odemeler', $columns);
		$writer->writeSheetRow('Iadeler', $columns);
		foreach($payments as $row) {
			$writer->writeSheetRow('Odemeler', $row);
		}
		foreach($refunds as $row) {
			$writer->writeSheetRow('Iadeler', $row);
		}
		$writer->writeToStdOut();
		exit(0);
	}

	public function nextMonth(){
		$year = date('Y');
		$month = date('m');
		if($month==12){
			$year = date('Y', strtotime('+1 year'));
			$month = date('01');
		}else{
			$month = date('m', strtotime('+1 month'));
		}
		return date("$year-$month-01 00:00:00");
	}
	
	
}
