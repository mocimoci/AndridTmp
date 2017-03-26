package bb_brain.net.measuringapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/*
*
*
* スピナーを使って 2016年 12月 1日から 12月 31日まで動的にセットして、
* 選択された日付をメッセージダイアログで表示
*
*
*/
public class Spinner2 extends Activity implements View.OnClickListener {

    private final static int WC = LinearLayout.LayoutParams.WRAP_CONTENT;
    private final static String BR = System.getProperty("line.separator");

    private CheckBox checkBox;//チェックボックス
    private RadioGroup radioGroup;//ラジオグループ
    private Spinner spinner;//スピナー
    private Spinner spinner2;//スピナー
    private Button button;//ボタン
    LinearLayout layout;
    Activity context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //レイアウトの生成
        layout = new LinearLayout(this);
        layout.setBackgroundColor(Color.WHITE);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
        context = this;

        //タイトル
        TextView textView = new TextView(this);
        textView.setText("2016 年 12 月");
        textView.setTextSize(28.0f);
        textView.setTextColor(Color.rgb(0, 0, 0));
        layout.addView(textView);

        //スピナー生成
        createSpiinner();

        //ボタンの生成
        button = new Button(this);
        button.setText("選択");
        button.setOnClickListener(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(button);
    }


    @Override
    public void onClick(View v) {
        //チェックボックスとラジオボタンとスピナーの状態取得
        Log.d("onClick", String.valueOf("onClick"));
        String selectedSpinner = (String) spinner2.getSelectedItem();
        Log.d("onClick", String.valueOf("selectedSpinner:" + selectedSpinner));
        MessageDialog.show(context, "2016 年 12 月", selectedSpinner);
    }


    //スピナー生成
    private void createSpiinner() {
        ArrayList<String> list = new ArrayList<String>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();

        //2016 年 12 月 1 日から 12 月 31 日
        for (int i = 1; i <= 31; i++) {
            cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), i);
            list.add(format.format(cal.getTime()));
        }

        //スピナーの生成
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);

        spinner2 = new Spinner(this);
        spinner2.setAdapter(adapter);
        spinner2.setSelection(0);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner spinner = (Spinner) parent;
                // 選択されたアイテムを取得します
                String item = (String) spinner.getSelectedItem();
                Log.d("item:", String.valueOf(item));
                MessageDialog.show(context, "2016 年 12 月", String.valueOf(item));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinner2.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
        layout.addView(spinner2);
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