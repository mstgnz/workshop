<?php

function getMonthWeeksDay($m=1,$y=2020){
    $zaman = mktime(0,0,0,$m,1,$y);
    $maxgun = date("t",$zaman);
    $buay = getdate ($zaman);
    $ilkgun  = $buay['wday'];
    $weeksdays = [];
    $say=0;
    for ($i=0; $i<($maxgun+$ilkgun); $i++) {
        if(!($i < $ilkgun)){
            if(!array_key_exists($say.".hafta",$weeksdays)) $weeksdays[$say.".hafta"] = [];
            array_push($weeksdays[$say.".hafta"],($i - $ilkgun + 1));
        }
        if(($i % 7) == 0 ){
            $say++;
        }
    }
    return $weeksdays;
}
