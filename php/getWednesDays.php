<?php 

// Belirtilen yıl ve ayın çarşamba günlerini al
function getWednesDays($y, $m){
    $wednesday = [];
    $results =  new DatePeriod(
        new DateTime("first wednesday of $y-$m"),
        DateInterval::createFromDateString('next wednesday'),
        new DateTime("last day of $y-$m")
    );
    foreach ($results as $value) {
        $monday = strtotime($value->format("d-m-Y")."-2days");
        $sunday = strtotime($value->format("d-m-Y")."+4days");
        $wednesday[$value->format("d-m-Y")]["monday"] = date("d-m-Y",$monday);
        $wednesday[$value->format("d-m-Y")]["sunday"] = date("d-m-Y",$sunday);
    }
    $wednesday['last']['monday'] = date('d-m-Y',strtotime("this week"));
    $wednesday['last']['sunday'] = date('d-m-Y',strtotime("this week +6 days"));
    
    return $wednesday;
}
