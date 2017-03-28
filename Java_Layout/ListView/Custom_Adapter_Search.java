package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import java.util.ArrayList;
/*
*
* 検索機能付きビュー
*
* R.id.searchでエラー
*
*/
public class Custom_Adapter_Search extends Activity implements SearchView.OnQueryTextListener{

    private ArrayList<String> items;
    ListView listView;

    //アクティビティ起動時に呼ばれる
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //要素の情報群の生成
        items = new ArrayList<String>();
        items.add("beatles");
        items.add("abcmart");
        items.add("japan");
        items.add("america");
        items.add("china");

        //リストの生成(1 行)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(items);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //サーチビュー
        SearchView searchView = new SearchView(this);
        searchView.setQueryHint("検索文字列を入力");
        searchView.setIconifiedByDefault(false);
        searchView.setId(R.id.search);
        searchView.setOnQueryTextListener(this);
        layout.addView(searchView);

        //リストビューの生成
        listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);//フィルター機能を有効化

        layout.addView(listView);
    }

    //サブミットボタンをクリックした時
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    //検索ボックスの内容が変化した時
    @Override
    public boolean onQueryTextChange(String s) {
        if(s == null || s.equals("")){
            listView.clearTextFilter();
        }else {
            listView.setFilterText(s);
        }
        return false;
    }
}
