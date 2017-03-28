package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
/*
*
* 次の５件を読み込む
* フッターをクリックするとリストアイテムを 5 個追加して表示します。
* 
* R.id.footerで不具合あり
*
*/
public class Custom_Adapter_more extends Activity implements AdapterView.OnItemClickListener{

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;

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
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(items);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //リストビューの生成
        listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        //フッターをレイアウトから生成
        //View footer = getLayoutInflater().inflate(R.layout.footer,null);

        //フッターをコードから生成
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setId(R.id.footer);
        layout2.setBackgroundColor(Color.WHITE);
        layout2.setPadding(10,10,10,10);
        layout2.setGravity(Gravity.CENTER);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout2.setOrientation(LinearLayout.VERTICAL);

        //テキストの指定
        TextView textView = new TextView(this);
        textView.setText(getString(R.string.footer_text));
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(Color.YELLOW);
        textView.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        textView.setPadding(10,20,10,20);
        layout2.addView(textView);
        View footer = layout2;

        //フッターを追加
        listView.addFooterView(footer, null, true);
        layout.addView(listView);
    }

    // アイテムをクリック---------------------------------------------------------------------------
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Log.d("onItemClick",String.valueOf("view.getId():"+view.getId()+"R.id.footer:"+R.id.footer));

        //クリックされた View がフッターか判定
        if (view.getId() == R.id.footer){

            //表示する数字を計算
            int count = adapter.getCount();
            int max = count + 5;
            for(count = count;count<max;count++){
                //リストアイテムを追加
                adapter.add("item_"+count);
            }
        }
        //指定された位置へ移動
        //listView.setSelection(0);
    }
}
