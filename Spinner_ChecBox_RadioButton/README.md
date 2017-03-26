# Spinner ChecBox RadioButton

レイアウトとは、複数のウィジェットをまとめたり、どのように配置すべきかを決める為のビューです。

### XML
XML は、ExtensibleMarkupLanguage の略であり、
インターネット上で様々なデータを扱う場合に特に利点を発揮します。
１９９８年に W３C により勧告された比較的新しい言語ですが、
仕様が簡単であるため、広く使用されるようになりました。




#### Spinner
~~~java
spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        
        // 選択されたアイテムを取得します
        String item = (String) spinner.getSelectedItem();
        Log.d("item:",String.valueOf(item));

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
});
~~~


#### ChecBox
	wrap_content 
		コンテンツのサイズに合わせてウィジェットのサイズが決まります。
		例えば、テキストビューであれば表示するテキストの内容で幅が決まります。
	fill_parent,match_parent 
		親要素いっぱいにウィジェットのサイズが拡がります。
		たとえば、横幅が fill_parent が設定されている LinearLayoutの入れ子として、
		横幅が fill_parent が設定されているテキストビューを記述した場合、
		画面幅いっぱいにテキストビューが表示されます。



#### RadioButton

	horizontal 
		top 上寄せ
		center_vertical 垂直方向に中央寄せ
		bottom 下寄せ

	vertical 
		left 左寄せ
		center_horizontal 水平方向に中央寄せ
		right 右寄せ

	android:gravity=”left” or ”center” or ”right”
		まとめて左右中央寄せが出来る。

