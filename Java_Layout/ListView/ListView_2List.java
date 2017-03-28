package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
*
* リストビュー
* 2行リスト
* Android に予め用意されている各項目 2行分レイアウトを使用して表示
*
*/
public class ListView_2List extends Activity {
    private List<Map<String,String>> items;

    //アクティビティ起動時に呼ばれる
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //要素の情報群の生成
        items = new ArrayList<Map<String,String>>();
        for (int i = 0; i < 30;i++){
            Map<String, String> map = new HashMap<String, String>();
            map.put("main", "項目"+i);
            map.put("sub", "サブテキスト"+i);
            items.add(map);
        }

        //リストの生成(1 行)
        SimpleAdapter adapter = new SimpleAdapter(
                this,items,android.R.layout.simple_list_item_2,new String[] {"main", "sub"},
                new int[] {android.R.id.text1, android.R.id.text2});

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //リストビューの生成
        ListView listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setAdapter(adapter);
        layout.addView(listView);
    }
}
