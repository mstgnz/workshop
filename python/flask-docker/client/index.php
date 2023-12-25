<html>
    <head>
        <title>Test</title>
    </head>
    <body>
        <ul>
            <?php
                $json = file_get_contents('http://server/');
                $obj = json_decode($json);
                
                //echo '<pre>';print_r($obj);exit;

                foreach ($obj->lists as $list) {
                    echo "<li>$list</li>";
                }
            ?>
        </ul>
    </body>
</html>
