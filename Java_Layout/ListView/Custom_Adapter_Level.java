package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
*
* 階層型のリスト
*
* R.id.searchでエラー
*
*/
public class Custom_Adapter_Level extends Activity implements SearchView.OnQueryTextListener{

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private ArrayList<String> items;
    ListView listView;

    //アクティビティ起動時に呼ばれる
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //拡張型リストビュー
        ExpandableListView expandableListView = new ExpandableListView(this);
        expandableListView.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));
        layout.addView(expandableListView);

        //親項目、子項目を準備
        String[] g_titles = {"金管","木管","弦"};
        String[][][] c_titles = {{{"トランペット","高音域の出る金管楽器"},{"トロンボーン ","長い U 字型の管を繋ぎ合わせた形の金管楽器"}
                ,{"チューバ","大型で低音域の出る金管楽器"}},
                {{"クラリネット","音域の広い木管楽器"},{"ファゴット","低音域の木管楽器"}
                        ,{"オーボエ","2 枚リードで高音域の木管楽器"}},
                {{"バイオリン","高音域の弦楽器"},{"ビオラ","中音域の弦楽器"}
                        ,{"チェロ","大型の低音域の弦楽器"}}};



        //アダプタ
        ArrayList<Map<String,String>> g_list = new ArrayList<Map<String,String>>();
        ArrayList<List<Map<String,String>>> c_list = new ArrayList<List<Map<String,String>>>();

        //配列 g_titles を HashMap に詰め替え（Key は group_title）
        for (int i = 0; i < g_titles.length;i++){
            HashMap<String,String> group = new HashMap<String, String>();
            group.put("group_title",g_titles[i]);

            //リスト g_list に追加
            g_list.add(group);
            ArrayList<Map<String,String>> childs = new ArrayList<Map<String,String>>();

            //配列 c_titles の内容を HashMap(child)に詰め替え＆リスト childs に追加
            for (int j = 0; j < c_titles.length; j++){
                HashMap<String,String> child = new HashMap<String, String>();
                child.put("child_title",c_titles[i][j][0]);
                child.put("child_text",c_titles[i][j][1]);
                childs.add(child);
            }
            //リスト c_list に追加
            c_list.add(childs);
        }



        //アダプターを準備＆設定
        SimpleExpandableListAdapter adapter1 = new SimpleExpandableListAdapter(
                this,
                g_list,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{"group_title"},
                new int[]{android.R.id.text1},
                c_list,
                android.R.layout.simple_expandable_list_item_2,
                new String[]{"child_title","child_text"},
                new int[]{android.R.id.text1,android.R.id.text2}
        );
        expandableListView.setAdapter(adapter1);



        //子項目をクリックした時のイベントリスナーを定義
        expandableListView.setOnChildClickListener(
                new ExpandableListView.OnChildClickListener(){
                    public boolean onChildClick(ExpandableListView parent,View v,
                                                int groupPosition, int childPosition, long
                                                        id){
                        //クリックされた子項目を取得
                        TextView textView =
                                (TextView)((TwoLineListItem)v).findViewById(android.R.id.text1);
                        Log.d("Custom_Adapter_Level",String.valueOf("クリックされた子項目:"+textView));
                        return false;
                    }
                }
        );
    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }



    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
