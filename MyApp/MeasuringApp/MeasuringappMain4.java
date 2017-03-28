package com.mgt.android2016.measuringapp;

//run-as bb_brain.net.measuringapp

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
 *
 *
 *
 */
public class MeasuringappMain4 extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;

    private final static String TAG_WRITE = "write";
    private final static String TAG_READ = "read";
    private final static String DB_NAME = "test.db";//DB名
    private final static String DB_TABLE = "recipe";   //レシピタイトルテーブル名
    private final static String DB_TABLE2 = "recipe_material";   //レシピ材料内訳テーブル名
    private final static int DB_VERSION = 1;        //バージョン

    private SQLiteDatabase db;  //データベースオブジェクト


    private final static String BR = System.getProperty("line.separator");
    private android.widget.Spinner spinner;//スピナー
    private Button button, button2;//ボタン
    LinearLayout layout, layout2, layout3, layout4;
    TextView textView, textView2;
    EditText edittext, edittext2, edittext3;
    String[] strs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの設定

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MP, WC);
        params.setMargins(0,0,0,10);
        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(MP, WC);
        params1.weight = 3.0f;
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(MP, WC);
        params2.weight = 1.0f;

        //土台レイアウトの生成
        layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10,10,10,10);
        setContentView(layout);

        //名前記入指示エリア
        layout2 = new LinearLayout(this);
        layout2.setBackgroundColor(Color.WHITE);
        layout2.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(layout2, params);

        //料理の名前は？
        textView = new TextView(this);
        textView.setText("料理の名前は？");
        textView.setTextSize(28.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        textView.setTextSize(15);
        textView.setGravity(Gravity.CENTER);
        layout2.addView(textView, params1);

        //料理名入力
        edittext = new EditText(this);
        edittext.setText("");
        edittext.setTextSize(28.0f);
        edittext.setTextColor(Color.rgb(0, 0, 0));
        edittext.setTextSize(15);
        edittext.setBackgroundColor(Color.rgb(200, 200, 200));
        edittext.setGravity(Gravity.CENTER);
        edittext.setPadding(10,10,10,10);
        edittext.setHint("レシピ名");
        layout2.addView(edittext, params1);


        //人数選択指示エリア
        layout3 = new LinearLayout(this);
        layout3.setBackgroundColor(Color.WHITE);
        layout3.setOrientation(LinearLayout.HORIZONTAL);
        layout.addView(layout3, params);

        //何人分？
        textView2 = new TextView(this);
        textView2.setText("何人分？");
        textView2.setTextSize(28.0f);
        textView2.setTextColor(Color.rgb(0, 0, 0));
        textView2.setTextSize(15);
        textView2.setGravity(Gravity.CENTER);
        layout3.addView(textView2, params1);

        //スピナーの生成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //スピナーのレイアウト変更
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //項目
        strs = new String[10];

        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(i + 1);
        }

        for (String value : strs) {
            adapter.add(value);
        }

        spinner = new android.widget.Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setPrompt("test一覧");
        spinner.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        spinner.setBackgroundColor(Color.rgb(200, 200, 200));
        layout3.addView(spinner, params1);

        //ボタンの生成
        button = new Button(this);
        button.setText("選択");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);

        //分量入力エリア
        materialData();

        //データベースオブジェクトの取得
        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();
        Log.d("onClick", String.valueOf("データベースオブジェクトの取得"));
    }

    //分量入力エリア内容生成
    private void materialData()  {}


    @Override
    public void onClick(View v) {
        //スピナーの状態取得
        String selectedSpinner = (String) spinner.getSelectedItem();
        Log.d("onClick", String.valueOf("人数は:" + selectedSpinner));

        for (int j = 0; j < strs.length; j++) {
            if (selectedSpinner.equals(String.valueOf(j + 1))) {
                Log.d("onClick", String.valueOf("人数は:" + (j + 1)));

                //DBに登録処理
                try {
                    String str = edittext.getText().toString();
                    Log.d("onClick", String.valueOf("今日のメニューは:" + str));
                    int num = j + 1;
                    writeDB(str, num);
                    Log.d("onClick", String.valueOf("書き込み成功しました"));
                } catch (Exception e) {
                    Log.d("onClick", String.valueOf("書き込み失敗しました"));
                }
                break;
            }
        }
    }

    //データベースへの書き込み
    private void writeDB(String rn, int ppl) throws Exception {
        ContentValues values = new ContentValues();

        values.put("people", ppl);//人数
        values.put("recipe_name", rn);//レシピ名
        db.insert(DB_TABLE, "", values);

        //db.insert(DB_TABLE2, "", values);

        Log.d("onClick", String.valueOf("データベースへの書き込み"));
    }


    //データベースヘルパーの定義
    private static class DBHelper extends SQLiteOpenHelper {
        //データベースヘルパーのコンストラクタ
        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
            Log.d("onClick", String.valueOf("データベースヘルパーの定義"));
        }

        //データベースの生成(最初に一度しか呼ばれない)
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table if not exists " + DB_TABLE  + "(id integer primary key autoincrement,people integer,recipe_name text)");
            //db.execSQL("create table if not exists " + DB_TABLE2 + "(id integer,check integer,material text,tool integer,volume integer,FOREIGN KEY(id) REFERENCES recipe(id))");
            Log.d("onClick", String.valueOf("データベースの生成"));
        }

        //データベースのアップグレード
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop talbe if exists " + DB_TABLE);
            //db.execSQL("drop talbe if exists " + DB_TABLE2);
            Log.d("onClick", String.valueOf("データベースのアップグレード"));
            onCreate(db);
        }
    }
}
