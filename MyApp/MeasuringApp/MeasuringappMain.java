package bb_brain.net.measuringapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
*
*スピナーを使って「赤」、「青」、「黄」、「緑」、「ピンク」、「オレンジ」の色を表示して、
* 選択された色で背景色を描画
*
*/
public class MeasuringappMain extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");
    private android.widget.Spinner spinner;//スピナー
    private Button button;//ボタン
    LinearLayout layout;
    TextView textView;
    TextView textView2;
    EditText edittext;
    String[] strs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //料理の名前は？
        textView = new TextView(this);
        textView.setText("料理の名前は？");
        textView.setTextSize(28.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);


        //料理名入力
        edittext = new EditText(this);
        edittext.setText("---");
        edittext.setTextSize(28.0f);
        edittext.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(edittext);

        //テキスト
        textView2 = new TextView(this);
        textView2.setText("何人分？");
        textView2.setTextSize(28.0f);
        textView2.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView2);

        //スピナーの生成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        //スピナーのレイアウト変更
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setSelection(0);//初期値
        //spinner.setPrompt("test一覧");


        //項目
        strs = new String[10];

        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(i + 1);
        }

        for (int i = 0; i < strs.length; i++) {
            adapter.add(strs[i]);
        }

        spinner = new android.widget.Spinner(this);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(spinner);

        //ボタンの生成
        button = new Button(this);
        button.setText("選択");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);
    }


    @Override
    public void onClick(View v) {

        //スピナーの状態取得
        String selectedSpinner = (String) spinner.getSelectedItem();
        Log.d("onClick", String.valueOf("selectedSpinner:" + selectedSpinner));


        for (int j = 0; j < strs.length; j++) {
            if (selectedSpinner.equals(String.valueOf(j + 1))) {
                Log.d("onClick", String.valueOf("selectedSpinner:" + (j + 1)));

                //DBに登録処理

                break;
            }
        }
    }
}