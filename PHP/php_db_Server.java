package com.mgt.android2016.measuringapp;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONObject;
/*
 *
 * 自分で作った PHP から JSON を返してもらい受け取る
 * 動的に作った JSON を受け取る
 *
 * HttpUtilsでエラーあり
 */
//HTTP 通信
public class php_db_Server extends AppCompatActivity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private final static String TAG_READ = "read";
    private static final String TAG = "php_db_Server";
    private TextView textView;
    private Handler handler = new Handler();
    private String phpStr = "";

    //テキストファイルの URL の指定(1)
    private final static String URL = "http://169.254.160.195/return_json_6_3.php";
    //アクティビティ起動時に呼ばれる


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //ボタンの生成
        layout.addView(makeButton("PHP と通信", TAG_READ));
        //テキストビューの生成
        textView = new TextView(this);
        textView.setText("");
        textView.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
        layout.addView(textView);
    }//onCreate end

    //ボタンの生成
    private Button makeButton(String text, String tag) {
        Button button = new Button(this);
        button.setText(text);
        button.setTag(tag);
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        return button;
    }

    //ボタンクリック時に呼ばれる
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (TAG_READ.equals(tag)) {
            //スレッドの生成(4)
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    //HTTP 通信
                    try {
                        Log.d(TAG, "PHP から取得");

                        // WebService の URL から JSONObject を取得
                        HttpUtils mHttpUtils = new HttpUtils();
                        JSONObject json = mHttpUtils.getJSON(URL);

                        Log.d(TAG, String.valueOf("json:" + json));

                        // 取得された JSON のルート要素である results を取得
                        JSONArray results = json.getJSONArray("work");

                        Log.d(TAG,"results.length():"+results.length());

                        for (int i = 0; i < results.length(); i++){

                            // 一つ目の JSONObject の住所名を取得
                            JSONObject items = results.getJSONObject(i);
                            Log.d(TAG, String.valueOf("name:" + items.getString("name")));
                            Log.d(TAG, String.valueOf("url:" + items.getString("url")));
                            phpStr += "データ("+i+")\n";
                            phpStr += "name:" + items.getString("name")+"\n";
                            phpStr += "url:" + items.getString("url")+"\n";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //ハンドラの生成(5)
                    handler.post(new Runnable() {
                        public void run() {
                            if (phpStr != null) {
                                textView.setText(phpStr);
                            } else {
                                textView.setText("読み込み失敗しました。");
                            }
                        }
                    });
                }
            });
            thread.start();
        }
    }
}
