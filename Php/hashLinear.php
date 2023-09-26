<?php

$arr = new SplFixedArray(23);

$list = [34,57,12,35,69,84,3,114];
$len = count($arr);


foreach($list as $v){
	$mod = $v%$len;
	bak($arr, $mod, $v);
}


function bak($arr, $mod, $value){
	if(empty($arr[$mod])){
		$arr[$mod] = $value;
	}else{
		$mod +=1;
		return bak($arr, $mod, $value);
	}
}

echo'<pre>';
print_r($arr);
