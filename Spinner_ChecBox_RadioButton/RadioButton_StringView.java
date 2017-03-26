package bb_brain.net.measuringapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/*
*
* ラジオボタンを使って「日本食」、「中華」、「イタリアン」、「フレンチ」を表示して、
* それぞれ選択して「結果表示」ボタンをクリックすると
* 下の方で選択された数を＊マークで表示する
*
* 関連:RadioButton.java
*
*/

public class RadioButton_StringView extends View {
    private String[] foodNames;
    private int[] enqResults;

    public RadioButton_StringView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }

    //アクテビティクラスから呼び出せるメソッド
    //フード名、アンケート結果を配列として受け取る
    public void setText1(String[] foodNames, int[] enqResults) {
        this.foodNames = foodNames;
        this.enqResults = enqResults;
        //再描画
        invalidate();
    }

    //描画
    protected void onDraw(Canvas canvas) {
        Log.d("StringView7", "onDraw");
        //描画オブジェクトの生成
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        //文字サイズと文字色の指定
        paint.setTextSize(48);
        paint.setColor(Color.rgb(0, 0, 0));
        int height = 10;
        for (int i = 0; i < foodNames.length; i++) {
            canvas.drawText(foodNames[i] + ":", 0, 60 * ++height, paint);
            int size = enqResults[i];
            for (int j = 0; j < size; j++) {
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                //文字サイズと文字色の指定
                paint2.setTextSize(48);
                paint2.setColor(Color.rgb(0, 255, 0));
                //＊の文字幅取得
                int astMeasure = (int) paint2.measureText("＊");
                //最大の文字数の食事ジャンル文字幅取得
                int baseMeasure = (int) paint2.measureText("イタリアン");

                Log.d("StringView7", String.valueOf("jitu:" + (baseMeasure + astMeasure * j) + "astMeasure:" + astMeasure + "height:" + (60 * height) + "baseMeasure:" + baseMeasure));
                canvas.drawText("＊", (baseMeasure + 30) + astMeasure * j, 60 * height, paint2);
            }
        }
    }
}