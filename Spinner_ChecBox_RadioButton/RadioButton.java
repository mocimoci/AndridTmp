package bb_brain.net.measuringapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/*
*
* ラジオボタンを使って「日本食」、「中華」、「イタリアン」、「フレンチ」を表示して、
* それぞれ選択して「結果表示」ボタンをクリックすると
* 下の方で選択された数を＊マークで表示する
*
* 関連:RadioButton_StringView.java
*
*/
public class RadioButton extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");
    private CheckBox checkBox;//チェックボックス
    private RadioGroup radioGroup;//ラジオグループ
    private Spinner spinner;//スピナー
    private Button button;//ボタン
    private String[] foodNames = {"日本食 ", "中華 ", "イタリアン", "フレンチ ",};
    private int[] enqResults = new int[]{0, 0, 0, 0};
    LinearLayout layout;
    RadioButton_StringView sv7;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //View クラス
        sv7 = new RadioButton_StringView(this);

        //レイアウトの生成
        layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        TextView textView = new TextView(this);
        textView.setText("フードアンケート");
        textView.setTextSize(32.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);

        //ラジオボタン０の生成
        android.widget.RadioButton radio0 = new android.widget.RadioButton(this);
        radio0.setId(1);
        radio0.setText("日本食");
        radio0.setOnClickListener(this);
        radio0.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン１の生成
        android.widget.RadioButton radio1 = new android.widget.RadioButton(this);
        radio1.setId(2);
        radio1.setText("中華");
        radio1.setOnClickListener(this);
        radio1.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン１の生成
        android.widget.RadioButton radio2 = new android.widget.RadioButton(this);
        radio2.setId(3);
        radio2.setText("イタリアン");
        radio2.setOnClickListener(this);
        radio2.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン１の生成
        android.widget.RadioButton radio3 = new android.widget.RadioButton(this);
        radio3.setId(4);
        radio3.setText("フレンチ");
        radio3.setOnClickListener(this);
        radio3.setTextColor(Color.rgb(0, 0, 0));

        //ラジオグループの生成
        radioGroup = new RadioGroup(this);
        radioGroup.addView(radio0);
        radioGroup.addView(radio1);
        radioGroup.addView(radio2);
        radioGroup.addView(radio3);
        radioGroup.clearCheck();
        radioGroup.check(1);
        radioGroup.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(radioGroup);

        //ボタンの生成
        button = new Button(this);
        button.setText("結果表示");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);
        sv7 = new RadioButton_StringView(this);
        sv7.setText1(foodNames, enqResults);
        layout.addView(sv7);
    }



    @Override
    public void onClick(View v) {
        switch (radioGroup.getCheckedRadioButtonId()) {
            case 1:
                //日本食
                enqResults[0]++;
                Log.d("onClick", String.valueOf("日本食" + enqResults[0]));
                break;
            case 2:
                //中華
                enqResults[1]++;
                Log.d("onClick", String.valueOf("中華" + enqResults[1]));
                break;
            case 3:
                //イタリアン
                enqResults[2]++;
                Log.d("onClick", String.valueOf("イタリアン" + enqResults[2]));
                break;
            case 4:
                //フレンチ
                enqResults[3]++;
                Log.d("onClick", String.valueOf("フレンチ" + enqResults[3]));
                break;
            default:
                //ミスオペレーション
                System.out.println("日本食，中華，イタリアン，フレンチのいずれかを入力して ください。");
                break;
        }
        //アンケート結果描画
        layout.removeView(sv7);
        sv7 = new RadioButton_StringView(this);
        sv7.setText1(foodNames, enqResults);
        layout.addView(sv7);
    }
}
