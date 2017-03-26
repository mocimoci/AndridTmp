package bb_brain.net.measuringapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
public class Spinner extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");
    private android.widget.Spinner spinner;//スピナー
    private Button button;//ボタン
    LinearLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        TextView textView = new TextView(this);
        textView.setText("好みの色を選んでください");
        textView.setTextSize(28.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);

        //スピナーの生成
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        String[] strs = {"赤", "青", "黄", "緑", "ピンク", "オレンジ"};
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
        if (selectedSpinner.equals("赤")) {
            layout.setBackgroundColor(Color.RED);
        } else if (selectedSpinner.equals("青")) {
            layout.setBackgroundColor(Color.BLUE);
        } else if (selectedSpinner.equals("黄")) {
            layout.setBackgroundColor(Color.YELLOW);
        } else if (selectedSpinner.equals("緑")) {
            layout.setBackgroundColor(Color.GREEN);
        } else if (selectedSpinner.equals("ピンク")) {
            layout.setBackgroundColor(Color.rgb(255, 51, 255));
        } else if (selectedSpinner.equals("オレンジ")) {
            layout.setBackgroundColor(Color.rgb(255, 102, 0));
        }
    }
}