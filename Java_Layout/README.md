# AndroidLayout

レイアウトとは、複数のウィジェットをまとめたり、どのように配置すべきかを決める為のビューです。

#### レイアウトの種類と概要
	LinearLayout ウィジェットを縦/横一列に配置
	RelativeLayout ウィジェットの位置を前後の相対位置を指定
	AbsoluteLayout ウィジェットの位置を絶対座標で指定
	TableLayout ウィジェットをテーブル(格子)状に配置
	GridLayout ウィジェットをテーブル(格子)状に配置
	FrameLayout ウィジェットを左上に重ねて配置


#### Layout基本形

~~~java
//文字列取得
String hello1 = getString(R.string.hello1);

//レイアウトの生成
LinearLayout layout = new LinearLayout(this);
layout.setBackgroundColor(Color.WHITE);
layout.setOrientation(LinearLayout.VERTICAL);
setContentView(layout);

	//テキストビューの生成
	TextView textView = new TextView(this);
	textView.setText(hello1);
	textView.setTextSize(48.0f);

	textView.setGravity(Gravity.CENTER);
	textView.setGravity(Gravity.LEFT);
	textView.setGravity(Gravity.RIGHT);

	textView.setGravity(Gravity.TOP);
	textView.setGravity(Gravity.CENTER);
	textView.setGravity(Gravity.BOTTOM);

	textView.setGravity(Gravity.LEFT|Gravity.TOP);
	textView3.setGravity(Gravity.RIGHT|Gravity.BOTTOM);
	textView4.setGravity(Gravity.TOP|Gravity.RIGHT);

	textView.setTextColor(Color.rgb(0,0,0));

	//コンポーネントのサイズ指定
	textView.setLayoutParams(new LinearLayout.LayoutParams(MP,MP));
	textView.setLayoutParams(new LinearLayout.LayoutParams(MP,WC));

	//レイアウトへのコンポーネントの追加
	layout.addView(textView);
~~~

#### EditText入力域に、ヒントテキストを入れる

~~~java
edittext.setHint("書き込むと消えるテキスト");
~~~

#### テキストビューの周りにマージンを指定して表示。(横幅のサイズを固定)

~~~java
//RelativeLayout

//テキストビュー１の生成
TextView textView1 = new TextView(this);
textView1.setId(R.id.id1);
textView1.setText(hello2);
textView1.setGravity(Gravity.CENTER);
RelativeLayout.LayoutParams params0;

params0 = new RelativeLayout.LayoutParams(340, MP);
params0.setMargins(10,10,10,10);

textView1.setLayoutParams(params0);
layout.addView(textView1);

//テキストビュー2 の生成
TextView textView2 = new TextView(this);
textView2.setId(R.id.id2);
textView2.setText(hello2);
textView2.setGravity(Gravity.CENTER);
RelativeLayout.LayoutParams params1;

params1 = new RelativeLayout.LayoutParams(340, MP);
params1.addRule(RelativeLayout.RIGHT_OF, R.id.id1);//1 の右
params1.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.id1);//1 の下端
params1.setMargins(10,10,10,10);

textView2.setLayoutParams(params1);
layout.addView(textView2);

//テキストビュー3 の生成
TextView textView3 = new TextView(this);
textView3.setId(R.id.id3);
textView3.setText(hello2);
textView3.setGravity(Gravity.CENTER);
RelativeLayout.LayoutParams params2;

params2 = new RelativeLayout.LayoutParams(340, MP);
params2.addRule(RelativeLayout.RIGHT_OF, R.id.id2);//2 の右
params2.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.id2);//2 の下端
params2.setMargins(10,10,10,10);

textView3.setLayoutParams(params2);
layout.addView(textView3);
~~~

#### テキストビューに表示幅の比率を設定して縦方向に並べて表示

~~~java
//VERTICALのLinearLayoutの中で指定

//コンポーネントのサイズ指定
LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(MP,WC);
params1.weight = 3.0f;  // １：３：１ など、それぞれ比率を持たせる

//レイアウトへのコンポーネントの追加
layout.addView(textView,params1);  // 第２引数に追加
~~~

#### テキストビューに表示幅の具体的な数値を設定して縦方向に並べて表示。(単位ピクセル)

~~~java
//VERTICALのLinearLayoutの中で指定

//コンポーネントのサイズ指定
LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(MP,300);

//レイアウトへのコンポーネントの追加
layout.addView(textView,params1);  // 第２引数に追加
~~~

#### テーブルレイアウト

~~~java
//テーブルの骨組み
TableLayout (Gravity.LEFT)(MP, WC)
layout.setStretchAllColumns(true);
setContentView(layout);

	//1 段目
	TableRow　(Gravity.CENTER)(MP, WC)
	layout.addView(row);

		textView1
		row.addView(textView1);
		textView2
		row.addView(textView2);
		textView3
		row.addView(textView3);

	//2 段目
	TableRow2　(Gravity.CENTER)(MP, WC)
	layout.addView(row2);

		textView4
		row2.addView(textView4);
		textView5
		row2.addView(textView5);
		textView6
		row2.addView(textView6);

	//3 段目
	TableRow3　(Gravity.CENTER)(MP, WC)
	layout.addView(row3);

		textView7
		row3.addView(textView7);
		textView8
		row3.addView(textView8);
		textView9
		row3.addView(textView9);

~~~


#### グリッドレイアウト

~~~java
//グリッドレイアウト
GridLayout layout = new GridLayout(this);
layout.setColumnCount(3);//3 列表示
layout.setRowCount(3);//3 行表示
setContentView(layout);

	//テキストビュー1
	TextView text1 = new TextView(this);

	GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
	params1.width = 180;
	params1.height = 120;
	params1.columnSpec = GridLayout.spec(0);//0⇒1 列目
	params1.rowSpec = GridLayout.spec(0);//0⇒1 行目

	text1.setText(num1);
	text1.setGravity(Gravity.CENTER);
	layout.addView(text1,params1);

	//テキストビュー2
	params2.columnSpec = GridLayout.spec(1);//1⇒2 列目
	params2.rowSpec = GridLayout.spec(0);//0⇒1 行目
	layout.addView(text2);

	//テキストビュー3
	params3.columnSpec = GridLayout.spec(2);//2⇒3 列目
	params3.rowSpec = GridLayout.spec(0);//0⇒1 行目 
	layout.addView(text3);

	//テキストビュー4
	params4.columnSpec = GridLayout.spec(0);//0⇒1 列目
	params4.rowSpec = GridLayout.spec(1);//1⇒2 行目 
	layout.addView(text4);
~~~

#### セルを３列で折り返してテキストビューを表示。(GridLayout.spec の設定で幅を均等に表示)

~~~java
//グリッドレイアウト 
GridLayout layout = new GridLayout(this);
layout.setColumnCount(3);
layout.setRowCount(3);
setContentView(layout);

	//テキストビュー1
	TextView text1 = new TextView(this);
	GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
	params1.width = WC;
	params1.height = WC;

	params1.columnSpec = GridLayout.spec(0, GridLayout.FILL, 1);
	//GridLayout.spec(0⇒1 列目、GridLayout.FILL⇒セル領域拡張、1⇒重み(比重))

	params1.rowSpec = GridLayout.spec(0);
	text1.setText(num1);
	text1.setGravity(Gravity.CENTER);
	text1.setBackgroundColor(Color.rgb(0,255,0));
	layout.addView(text1,params1);

	//テキストビュー2
	params2.rowSpec = GridLayout.spec(0);
	params2.columnSpec = GridLayout.spec(1, GridLayout.FILL, 1);

	//テキストビュー3
	params3.rowSpec = GridLayout.spec(0);
	params3.columnSpec = GridLayout.spec(2, GridLayout.FILL, 1);

	//テキストビュー4
	params4.rowSpec = GridLayout.spec(1);
	params4.columnSpec = GridLayout.spec(0, GridLayout.FILL, 1);

	//テキストビュー5
	params5.rowSpec = GridLayout.spec(1);
	params5.columnSpec = GridLayout.spec(1, GridLayout.FILL, 1);

	//テキストビュー6
	params6.rowSpec = GridLayout.spec(1);
	params6.columnSpec = GridLayout.spec(2, GridLayout.FILL, 1);
~~~

#### セルにマージンを設定して３列で折り返してテキストビューを表示

~~~java
//グリッドレイアウト
GridLayout layout = new GridLayout(this);
layout.setColumnCount(3);
layout.setRowCount(3);
setContentView(layout);

	//テキストビュー1
	TextView text1 = new TextView(this);
	GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
	params1.width = WC;
	params1.height = WC;
	//左、上、右、下の順番でマージンを設定
	params1.setMargins(20,20,20,20);
	params1.columnSpec = GridLayout.spec(0, GridLayout.FILL, 1);
	params1.rowSpec = GridLayout.spec(0);
	text1.setText(num1);
	//左、上、右、下の順番でパディングを設定
	text1.setPadding(20,20,20,20);
	text1.setGravity(Gravity.CENTER);
	text1.setBackgroundColor(Color.rgb(0,255,0));
	layout.addView(text1,params1);

	//テキストビュー2
	//テキストビュー3
	//テキストビュー4
	//テキストビュー5
	//テキストビュー6
~~~

#### ３列で折り返してテキストビューを表示。<br>テキストビューが画面に収まり切らない場合 ScrollView を使用。

~~~java
//スクロールビュー
ScrollView scrollView = new ScrollView(this);
setContentView(scrollView);

	//グリッドレイアウト
	GridLayout layout = new GridLayout(this);
	layout.setColumnCount(3);
	layout.setRowCount(3);
	scrollView.addView(layout);

		//テキストビュー1
		TextView text1 = new TextView(this);
		GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
		params1.width = WC;
		params1.height = 900;
		params1.setMargins(20,20,20,20);
		params1.columnSpec = GridLayout.spec(0, GridLayout.FILL, 1);
		params1.rowSpec = GridLayout.spec(0);
		text1.setText(num1);
		text1.setGravity(Gravity.CENTER);
		layout.addView(text1,params1);

		//テキストビュー2
		//テキストビュー3
		//テキストビュー4
		//テキストビュー5
		//テキストビュー6
~~~

#### 画面下部にテキストビューを固定して、3 列で折り返してテキストビューを表示。<br>テキストビューが画面に収まり切らない場合 ScrollView を使用。

~~~java
//レイアウトの生成
LinearLayout linear = new LinearLayout(this);
linear.setBackgroundColor(Color.WHITE);
linear.setOrientation(LinearLayout.VERTICAL);
setContentView(linear);

	//スクロールビュー
	ScrollView scrollView = new ScrollView(this);
	LinearLayout.LayoutParams params0 = new
	inearLayout.LayoutParams(MP,WC);
	params0.weight = 1.0f;
	linear.addView(scrollView,params0);

		//グリッドレイアウト
		GridLayout layout = new GridLayout(this);
		layout.setColumnCount(3);
		layout.setRowCount(3);
		scrollView.addView(layout);

			//テキストビュー1
			TextView text1 = new TextView(this);
			GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
			params1.width = WC;
			params1.height = 900;
			params1.setMargins(20,20,20,20);
			params1.columnSpec = GridLayout.spec(0, GridLayout.FILL, 1);
			params1.rowSpec = GridLayout.spec(0);
			text1.setText(num1);
			text1.setGravity(Gravity.CENTER);
			text1.setBackgroundColor(Color.rgb(0,255,0));
			layout.addView(text1,params1);

			//テキストビュー2
			//テキストビュー3
			//テキストビュー4
			//テキストビュー5
			//テキストビュー6

	//テキストビュー7
	TextView text7 = new TextView(this);
	LinearLayout.LayoutParams params7 = new LinearLayout.LayoutParams(MP,WC);
	params7.weight = 0;
	text7.setText(hello1);
	text7.setGravity(Gravity.CENTER);
	text7.setBackgroundColor(Color.rgb(255,255,255));
	linear.addView(text7,params7);
~~~
















