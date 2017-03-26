# GridLayout

GridLayout はウィジェットをテーブル(格子) 状に配置する為のレイアウトです。
TableRow が不要です。


#### 基本形
	GridLayout
	  android:columnCount="3"
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1"
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1" 
		TextView 
		  android:layout_columnWeight="1" 
	/GridLayout



#### ウィジェットのサイズの指定方法
	wrap_content 
		コンテンツのサイズに合わせてウィジェットのサイズが決まります。
		例えば、テキストビューであれば表示するテキストの内容で幅が決まります。
	fill_parent,match_parent 
		親要素いっぱいにウィジェットのサイズが拡がります。
		たとえば、横幅が fill_parent が設定されている LinearLayoutの入れ子として、
		横幅が fill_parent が設定されているテキストビューを記述した場合、
		画面幅いっぱいにテキストビューが表示されます。


#### android:layout_gravity 属性の設定値

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



#### サイズに指定出来る単位
	dp 解像度に依存しない単位。
	sp 解像度に依存しない単位(文字サイズに利用する)。
	px ピクセル数
