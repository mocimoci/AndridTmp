package bb_brain.net.measuringapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/*
*
* チェックボックスを使って行きたい国を表示して、
* チェックされた分だけメッセージダイアログにカンマ区切りで表示
*
*/
public class CheckBox extends Activity implements View.OnClickListener {
    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");
    private android.widget.CheckBox checkBox1;//チェックボックス
    private android.widget.CheckBox checkBox2;//チェックボックス
    private android.widget.CheckBox checkBox3;//チェックボックス
    private android.widget.CheckBox checkBox4;//チェックボックス
    private android.widget.CheckBox checkBox5;//チェックボックス

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //問題タイトル
        TextView textView = new TextView(this);
        textView.setText("行きたい国を選んでください");
        textView.setTextSize(32.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);

        //チェックボックスの生成
        checkBox1 = new android.widget.CheckBox(this);
        checkBox1.setText("イタリア");
        checkBox1.setTextColor(Color.rgb(0, 0, 0));
        checkBox1.setChecked(false);
        checkBox1.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox1);
        checkBox2 = new android.widget.CheckBox(this);
        checkBox2.setText("アメリカ");
        checkBox2.setTextColor(Color.rgb(0, 0, 0));
        checkBox2.setChecked(false);
        checkBox2.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox2);
        checkBox3 = new android.widget.CheckBox(this);
        checkBox3.setText("スペイン");
        checkBox3.setTextColor(Color.rgb(0, 0, 0));
        checkBox3.setChecked(false);
        checkBox3.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox3);
        checkBox4 = new android.widget.CheckBox(this);
        checkBox4.setText("カナダ");
        checkBox4.setTextColor(Color.rgb(0, 0, 0));
        checkBox4.setChecked(false);
        checkBox4.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox4);
        checkBox5 = new android.widget.CheckBox(this);
        checkBox5.setText("中国");
        checkBox5.setTextColor(Color.rgb(0, 0, 0));
        checkBox5.setChecked(false);
        checkBox5.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(checkBox5);

        //ボタンの生成
        Button button = new Button(this);
        button.setText("結果表示");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);
    }


    @Override
    public void onClick(View v) {
        //チェックボックス状態取得
        boolean chk1 = checkBox1.isChecked();
        boolean chk2 = checkBox2.isChecked();
        boolean chk3 = checkBox3.isChecked();
        boolean chk4 = checkBox4.isChecked();
        boolean chk5 = checkBox5.isChecked();

        //チェック結果メッセージ
        String msg = "";

        //チェック判定
        if (chk1 == true) {
            msg = "イタリア";
        }
        if (chk2 == true) {
            if (msg.equals("")) {
                msg = "アメリカ";
            } else {
                msg += ",アメリカ";
            }
        }
        if (chk3 == true) {
            if (msg.equals("")) {
                msg = "スペイン";
            } else {
                msg += ",スペイン";
            }
        }
        if (chk4 == true) {
            if (msg.equals("")) {
                msg = "カナダ";
            } else {
                msg += ",カナダ";
            }
        }
        if (chk5 == true) {
            if (msg.equals("")) {
                msg = "中国";
            } else {
                msg += ",中国";
            }
        }
        MessageDialog.show(this, "行きたい国", msg);
    }


    //メッセージダイアログの定義
    public static class MessageDialog extends DialogFragment {
        //ダイアログの表示
        public static void show(
                Activity activity, String title, String text) {
            MessageDialog f = new MessageDialog();
            Bundle args = new Bundle();
            args.putString("title", title);
            args.putString("text", text);
            f.setArguments(args);
            f.show(activity.getFragmentManager(), "messageDialog");
        }

        //ダイアログの生成
        @Override
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder ad = new AlertDialog.Builder(getActivity());
            ad.setTitle(getArguments().getString("title"));
            ad.setMessage(getArguments().getString("text"));
            ad.setPositiveButton("OK", null);
            return ad.create();
        }
    }
}