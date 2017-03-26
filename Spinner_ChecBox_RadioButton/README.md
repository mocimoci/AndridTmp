# Spinner, ChecBox, RadioButton

プルダウンやチェックで簡単に項目を選択できる



#### Spinner
~~~java
//（１）スピナーを定義する ------------------------------
private android.widget.Spinner spinner;//スピナー

//（２）中身を作る -----------------------------------------
//スピナーの生成
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        
//アダプター
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//項目
String[] strs = {"赤", "青", "黄"};
for (int i = 0; i < strs.length; i++) {
    adapter.add(strs[i]);
}

spinner = new android.widget.Spinner(this);
spinner.setAdapter(adapter);
spinner.setSelection(0);
spinner.setLayoutParams(new LinearLayout.LayoutParams(WC, WC));
layout.addView(spinner);

//（３）ボタンが押されたら判定する ------------------------------
public void onClick(View v) {

    //スピナーの状態取得
    String selectedSpinner = (String) spinner.getSelectedItem();
    
    if (selectedSpinner.equals("赤")) {
        layout.setBackgroundColor(Color.RED);
    } else if (selectedSpinner.equals("青")) {
        layout.setBackgroundColor(Color.BLUE);
    } else if (selectedSpinner.equals("黄")) {
        layout.setBackgroundColor(Color.YELLOW);
    }
}
~~~
#### スピナーが選択された時の処理
~~~java
spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        
        // 選択されたアイテムを取得します
        String item = (String) spinner.getSelectedItem();

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
});
~~~


#### ChecBox
~~~java
//（１）チェックボックスを定義する ------------------------------
private android.widget.CheckBox checkBox1;//チェックボックス
private android.widget.CheckBox checkBox2;//チェックボックス

//（２）中身を作る -----------------------------------------
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

//（３）ボタンが押されたら判定する ------------------------------
@Override
public void onClick(View v) {
    //チェックボックス状態取得
    boolean chk1 = checkBox1.isChecked();
    boolean chk2 = checkBox2.isChecked();

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
    MessageDialog.show(this, "行きたい国", msg);
}
~~~



#### RadioButton

~~~java
//（１）ラジオグループを定義する ------------------------------
private RadioGroup radioGroup;//ラジオグループ

//（２）中身を作る -----------------------------------------
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


//（３）ボタンが押されたら判定する ------------------------------
public void onClick(View v) {
    //一問目回答
    if (radioGroup.getCheckedRadioButtonId() == 1) {
        //正解
        MessageDialog.show(this, "クイズ問題１", "正解です");
    } else {
        //不正解
        MessageDialog.show(this, "クイズ問題１", "不正解です");
    }
}
~~~

