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



#### Map
|xml|内容|
|:--|:--|
|[column_3.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/column_3.xml)|セルを３列で折り返してテキストビューを表示|
|[column_3_Even.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/column_3_Even.xml)|セルを３列で折り返してテキストビューを表示。<br>(layout_columnWeight で幅を均等に設定)|
|[join.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/join.xml)|セルを横に結合して３列で折り返してテキストビューを表示|
|[join_2.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/join_2.xml)|セルを縦に結合して３列で折り返してテキストビューを表示|
|[join_3.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/join_3.xml)|セルを横方向と縦方向に結合して３列で折り返してテキストビューを表示|
|[margin_padding.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/margin_padding.xml)|セルにマージンとパディングを設定して３列で折り返してテキストビューを表示|
|[margin_padding_<br>ScrollView.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/margin_padding_ScrollView.xml)|列で折り返してテキストビューを表示。<br>テキストビューが画面に収まり切らない場合ScrollView を使用。|
|[margin_padding_<br>ScrollView_<br>bottomtext.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/margin_padding_ScrollView_bottomtext.xml)|画面下部にテキストビューを固定して、3 列で折り返してテキストビューを表示。<br>テキストビューが画面に収まり切らない場合ScrollView を使用。|
|[margin_padding_<br>ScrollView_<br>bottomtext_RelativeLayout.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/margin_padding_ScrollView_bottomtext_RelativeLayout.xml)|画面下部にテキストビューを固定して、3 列で折り返してテキストビューを表示。<br>テキストビューが画面に収まり切らない場合ScrollView を使用。<br>※RelativeLayout を使用|
|[stert_3_wrap_3.xml](https://github.com/mocimoci/AndridTmp/blob/master/Layout/Grid/stert_3_wrap_3.xml)|３番目のセルから開始して３列で折り返してテキストビューを表示|
