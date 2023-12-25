<?php

$content = htmlentities(file_get_contents('https://mes.kobisi.com'));
file_put_contents("deneme.txt",$content);
$link = '@^&lt;link.+href=&quot;([^\s]+)&quot;@i';
$script = '@^&lt;script.+src=&quot;([^\s]+)&quot;@i';
$links = getContent('https://mes.kobisi.com', $link);
$scripts = getContent('https://mes.kobisi.com', $script);

function getContent($url, $regex){
    $list = [];
    $content = htmlentities(file_get_contents($url));
    file_put_contents("content.txt",$content);
    $fh = fopen('content.txt','r');
    while ($line = fgets($fh)) {
        preg_match($regex, $line, $result);
        if($result){
            if(strpos($result[1], 'ttps')){
                $list[] = $result[1];
            }
        }   
    }
    fclose($fh);
    return $list;
}

echo'<pre>';
print_r($links);
print_r($scripts);
