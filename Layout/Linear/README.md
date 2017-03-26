# LinearLayout

LinearLayoutは、縦方向横方向へ指定して配置配置します


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
	
	
#### Map

|xml|内容|
|:--|:--|
|[aria_9.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/aria_9.xml)|画面を９個のさ市松模様に配置し、それぞれにHi!を表示|
|[aria_9_random.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/aria_9_random.xml)|画面を９個のさ市松模様に配置し、それぞれにHi!を表示Hiの位置を上下左右に指定して配置|
|[aria_all.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/aria_all.xml)|テキストビューを全画面に表示。(横方向)|
|[aria_size_dp.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/aria_size_dp.xml)|幅に具体的な値を設定して表示。(単位 dp)|
|[aria_size_px.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/aria_size_px.xml)|幅に具体的な値を設定して表示。(単位 px)|
|[layout_weight.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/layout_weight.xml)|テキストビューに表示幅の比率を設定して横方向に並べて表示|
|[nest.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/nest.xml)|縦方向の LinearLayout に横方向の LinearLayout を入れ子にして表示|
|[nest2.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/nest2.xml)|縦方向の LinearLayout に横方向の LinearLayout を入れ子にして表示。(複数行)|
|[text_T_M_B.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/text_T_M_B.xml)|テキストビューに上寄せ、センター寄せ、下寄せを設定して横方向に並べて表示|
|[text_center_center.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/text_center_center.xml)|テキストビューを全画面に表示。(縦方向)|
|[text_horizontal.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/text_horizontal.xml)|テキストビューを横方向に並べて表示|
|[text_lleft_right_vertical.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/text_lleft_right_vertical.xml)|テキストビューに対して左寄せ、センター寄せ、右寄せの設定をして縦方向に並べて表示|
|[text_vertical.xml](text_vertical.xml)|テキストビューを縦方向に並べて表示|
|[text_weight.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Linear/text_weight.xml)|テキストビューに表示幅の比率を設定して縦方向に並べて表示|
