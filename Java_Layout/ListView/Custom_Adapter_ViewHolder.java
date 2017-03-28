package com.mgt.android2016.adapterex;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
/*
*
* カスタムアダプター(ビューホルダーを使用)
* アダプタークラスを作成して独自のレイアウトを表示。
* ※値設定時にウィジェットの参照を取得する手順を省くことで処理を高速化出来る
*
*/
public class Custom_Adapter_ViewHolder extends Activity {
    private ArrayList<AdapterItem7> items;
    //アクティビティ起動時に呼ばれる
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //要素の情報群の生成
        items = new ArrayList<AdapterItem7>();
        for (int i = 0; i < 30;i++){
            AdapterItem7 item = new AdapterItem7();
            item.icon = res2bmp(this,R.drawable.sample);
            item.text1 = "項目 1"+i;
            item.text2= "項目 2"+i;
            items.add(item);
        }
        //リストビューの生成
        ListView listView = new ListView(this);
        listView.setScrollingCacheEnabled(false);
        listView.setAdapter(new MyAdapter(this,items));
        setContentView(listView);
    }
    //リソース→ビットマップ
    public Bitmap res2bmp(Context context, int resID) {
        return BitmapFactory.decodeResource(
                context.getResources(), resID);
    }
    //自作アダプター
    private class MyAdapter extends ArrayAdapter<AdapterItem7>{
        //レイアウトファイルから View オブジェクトを生成するため
        LayoutInflater inflater;
        MyAdapter(Context context, List<AdapterItem7> items){
            super(context,0,items);
            //インフレーターを取得
            inflater = getLayoutInflater();
        }
        //要素数の取得
        public int getCount(){
            return items.size();
        }
        //要素の取得
        public AdapterItem7 getItem(int pos){
            return items.get(pos);
        }
        //要素 ID との取得
        public long getItemId(int pos){
            return pos;
        }
        //セルのビューの生成
        public View getView(int pos, View view , ViewGroup parent){
            Context context = Custom_Adapter_ViewHolder.this;
            //AdapterItem7 item = items.get(pos);
            //AdapterItem7 オブジェクトを取得
            AdapterItem7 item = getItem(pos);
            ViewHolder holder;
            //view には使いまわすための View があれば入っている
            if(view == null){
                //ない場合は生成する
//レイアウトファイルの場合
                //view = inflater.inflate(R.layout.row,null);
                LinearLayout layout = new LinearLayout(context);
                layout.setBackgroundColor(Color.WHITE);
                layout.setPadding(10,10,10,10);
                layout.setGravity(Gravity.CENTER_VERTICAL);
                layout.setOrientation(LinearLayout.VERTICAL);
                view = layout;
                //アイコン
                ImageView imageView = new ImageView(context);
                imageView.setTag("icon");
                imageView.setLayoutParams(new LinearLayout.LayoutParams(120,120));
                layout.addView(imageView);
                //テキストの指定
                TextView textView = new TextView(context);
                textView.setTag("text");
                textView.setTextColor(Color.BLACK);
                textView.setPadding(10,20,10,20);
                layout.addView(textView);
                //テキストの指定
                TextView textView2 = new TextView(context);
                textView2.setTag("text2");
                textView2.setTextColor(Color.BLACK);
                textView2.setPadding(10,20,10,20);
                layout.addView(textView2);
                holder = new ViewHolder();
                //参照をセット
                holder.imageView = (ImageView)view.findViewWithTag("icon");
                holder.textView = (TextView)view.findViewWithTag("text");
                holder.textView2 = (TextView)view.findViewWithTag("text2");
                //ViewHolder を使いまわせるようにセットしておく
                view.setTag(holder);
            }else {
                //ある場合は ViewHolder を取り出して再利用
                holder = (ViewHolder)view.getTag();
            }
            //値の指定
            holder.imageView.setImageBitmap(item.icon);
            holder.textView.setText(item.text1);
            holder.textView2.setText(item.text2);
            //表示するビューを返す
            return view;
        }
    }
    class AdapterItem7 {
        public Bitmap icon;
        public String text1;
        public String text2;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView textView2;
    }
}
