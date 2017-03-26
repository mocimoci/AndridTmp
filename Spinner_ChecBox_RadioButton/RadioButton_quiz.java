package bb_brain.net.measuringapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/*
*
* アメリカ大統領と日本の総理大臣を当てる三択クイズ
* 結果表示ボタンをクリックで、
* 問題１と問題２の正解か不正解かの結果をメッセージダイアログで表示
*
*/

public class RadioButton_quiz extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private RadioGroup radioGroup;//ラジオグループ
    private RadioGroup radioGroup2;//ラジオグループ


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        LinearLayout layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        //クイズタイトル
        TextView textView = new TextView(this);
        textView.setText("3 択クイズ");
        textView.setTextSize(32.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);

        //一問目質問
        TextView textView1 = new TextView(this);
        textView1.setText("問題１.アメリカの大統領は？");
        textView1.setTextSize(16.0f);
        textView1.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView1);

        //ラジオボタン０の生成
        RadioButton radio0 = new RadioButton(this);
        radio0.setId(1);
        radio0.setText("オバマ");
        radio0.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン２の生成
        RadioButton radio1 = new RadioButton(this);
        radio1.setId(2);
        radio1.setText("西川のりお");
        radio1.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン３の生成
        RadioButton radio2 = new RadioButton(this);
        radio2.setId(3);
        radio2.setText("タイガーマスク");
        radio2.setTextColor(Color.rgb(0, 0, 0));

        //ラジオグループの生成
        radioGroup = new RadioGroup(this);
        radioGroup.addView(radio0);
        radioGroup.addView(radio1);
        radioGroup.addView(radio2);
        radioGroup.clearCheck();
        radioGroup.check(1);
        radioGroup.setOnClickListener(this);
        radioGroup.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(radioGroup);

        //二問目質問
        TextView textView2 = new TextView(this);
        textView2.setText("問題２.日本の総理大臣は？");
        textView2.setTextSize(16.0f);
        textView2.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView2);

        //ラジオボタン１の生成
        RadioButton radio2_0 = new RadioButton(this);
        radio2_0.setId(1);
        radio2_0.setText("出川哲朗");
        radio2_0.setTextColor(Color.rgb(0, 0, 0));
        //ラジオボタン２の生成
        RadioButton radio2_1 = new RadioButton(this);
        radio2_1.setId(2);
        radio2_1.setText("西川きよし");
        radio2_1.setTextColor(Color.rgb(0, 0, 0));

        //ラジオボタン３の生成
        RadioButton radio2_2 = new RadioButton(this);
        radio2_2.setId(3);
        radio2_2.setText("安倍晋三");
        radio2_2.setTextColor(Color.rgb(0, 0, 0));

        //ラジオグループの生成
        radioGroup2 = new RadioGroup(this);
        radioGroup2.addView(radio2_0);
        radioGroup2.addView(radio2_1);
        radioGroup2.addView(radio2_2);
        radioGroup2.clearCheck();
        radioGroup2.check(1);
        radioGroup2.setOnClickListener(this);
        radioGroup2.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(radioGroup2);

        //結果表示ボタンの生成
        Button button = new Button(this);
        button.setText("結果表示");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);
    }


    @Override
    public void onClick(View v) {
        //一問目回答
        if (radioGroup.getCheckedRadioButtonId() == 1) {
            //正解
            Log.d("onClick", String.valueOf("正解"));
            MessageDialog.show(this, "クイズ問題１", "正解です");
        } else {
            //不正解
            Log.d("onClick", String.valueOf("不正解"));
            MessageDialog.show(this, "クイズ問題１", "不正解です");
        }
        //二問目回答
        if (radioGroup2.getCheckedRadioButtonId() == 3) {
            //正解
            Log.d("onClick", String.valueOf("正解"));
            MessageDialog.show(this, "クイズ問題２", "正解です");
        } else {
            //不正解
            Log.d("onClick", String.valueOf("不正解"));
            MessageDialog.show(this, "クイズ問題２", "不正解です");
        }
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