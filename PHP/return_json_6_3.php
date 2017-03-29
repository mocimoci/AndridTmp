<?php

//php_db_Server.javaに連動

        $json = array(
        'work'=>array (array('name'=>'Google', 'url'=>'abc'),
        array('name'=>'Yahoo!', 'url'=>'xyz'))
        );

        //動的に生成した配列
        $data["work"][0]["name"] = "0";
        $data["work"][0]["url"] = "yamada";
        $data["work"][1]["name"] = "1";
        $data["work"][1]["url"] = "yamamoto";

        header("Content-Type: application/json; charset=utf-8");
        //echo json_encode($json); // 配列を JSON 形式に変換してくれる
        echo json_encode($data); // 配列を JSON 形式に変換してくれる
        exit();
?>
