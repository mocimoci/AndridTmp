package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
/*
*
* リスト上のクリックイベント、ロングクリックイベントを取得
*
*/
public class Custom_Adapter_ClickEvent extends Activity
        implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ArrayList<String> items;

    //アクティビティ起動時に呼ばれる
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //要素の情報群の生成
        items = new ArrayList<String>();
        for (int i = 0; i < 30;i++){
            items.add("項目"+i);
        }

        //リストの生成(1 行)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(items);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //リストビューの生成
        ListView listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        layout.addView(listView);
    }
    
    //タップイベント -------------------------------------------------------------------------------
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
        
        Log.d("Custom_Adapter_ClickEvent","onItemClick item:"+item);
    }
    //ロングタップイベント --------------------------------------------------------------------------
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
        
        Log.d("Custom_Adapter_ClickEvent","onItemLongClick item:"+item);
        return true;
    }
}
