# RelativeLayout

RelativeLayout は前後のウィジェットの相対的な関係でもって位置を決定します。

#### RelativeLayout 配下で利用出来る主なレイアウト属性

	基準 
		android:layout_below 指定したウィジェットの下に配置
		android:layout_toLeftOf 指定したウィジェットの左に配置
		android:layout_ toRightOf 指定したウィジェットの右に配置

	配置 
		android:layout_alignTop 基準となるウィジェットの上端に合わせる
		android:layout_ alignBttom 基準となるウィジェットの下端に合わせる
		android:layout_ alignLeft 基準となるウィジェットの左端に合わせる
		android:layout_ alignRight 基準となるウィジェットの右端に合わせる

	マージン 
		android:layout_margin 上下左右の余白
		android:layout_marginTop 上の余白
		android:layout_marginBottom 下の余白
		android:layout_marginLeft 左の余白
		android:layout_marginRight 右の余白

	パディング 
		android:layout_padding 上下左右のパディング
		android:layout_paddingTop 上のパディング
		android:layout_paddingBottom 下のパディング
		android:layout_paddingLeft 左のパディング
		android:layout_paddingRight 右のパディング

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
