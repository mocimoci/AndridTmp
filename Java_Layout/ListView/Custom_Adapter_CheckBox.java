package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;

/*
*
* チェックボックスで複数項目選択
*
*/
public class Custom_Adapter_CheckBox extends Activity implements AdapterView.OnItemClickListener
{
    private ArrayList<String> items;
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,items);
        //adapter.addAll(items);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //リストビューの生成
        listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(this);
        layout.addView(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d("onItemClick",String.valueOf("position:"+position+"id:"+id));
        String msg = "選択したのは";
        for(int i = 0; i < listView.getChildCount();i++){
            CheckedTextView check = ((CheckedTextView)listView.getChildAt(i));
            if(check.isChecked()){
                msg += check.getText() + ",";
            }
        }

        msg = msg.substring(0, msg.length()-1);
        Log.d("onItemClick:","msg:"+msg);
    }
}
