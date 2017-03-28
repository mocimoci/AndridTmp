package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
/*
*
* リストが最後までスクロールされたかどうかを取得
*
*/
public class Custom_Adapter_ScrollEnd extends Activity
        implements
        AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener,
        AbsListView.OnScrollListener{

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
        listView.setOnScrollListener(this);
        layout.addView(listView);
    }

    //タップイベント--------------------------------------------------------------------------------
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String item = adapterView.getItemAtPosition(position).toString();
        Log.d("ListViewActivity8","onItemClick item:"+item);
    }

    //ロングタップイベント--------------------------------------------------------------------------
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long
            id) {
        String item = adapterView.getItemAtPosition(position).toString();
        Log.d("ListViewActivity8","onItemLongClick item:"+item);
        return true;
    }

    //----------------------------------------------------------------------------------------------
    public void onScrollChange(View view, int i, int i1, int i2, int i3) {
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    //----------------------------------------------------------------------------------------------
    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        Log.d("ListView9",String.valueOf("absListView:"+absListView));//スクロールされている ListView が格納されている
        Log.d("ListView9",String.valueOf("firstVisibleItem:"+firstVisibleItem));//スクロール中の ListView に表示されている先頭のリストアイテムのインデックスが格納されている
        Log.d("ListView9",String.valueOf("visibleItemCount:"+visibleItemCount));//スクロール中の ListView に現在表示されているリストアイテムの個数が格納されている
        Log.d("ListView9",String.valueOf("totalItemCount:"+totalItemCount));//リストアイテムの総アイテム数が格納されている

        if ((totalItemCount - visibleItemCount) == firstVisibleItem){
            Log.d("ListView9",String.valueOf("最後まで来ました。"));
        }
    }
}
