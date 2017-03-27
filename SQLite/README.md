# SQLite

データベースを操作する言語の無料簡易版<br>
Android / iPhoneで使われている
 
保存先は<br>
> /data/data/パッケージ名/databases/データベースファイル名<br>

アプリケーションをアンインストールするとファイルとして作成したデータベースも自動的に削除される。
削除はAndroid SDKのDDMS（Dalvik Debug Monitor Service）からではなく、Androidエミュレータの［Manage Applications］から行うこと。DDMSからアプリの削除を行うと、アプリケーションが作成したデータベースやファイルが削除ないので、注意が必要。

### SQLite主な命令

|命令|説明|
|:------|:------------------|
|create|テーブルの生成|
|drop|テーブルの削除|
|query|レコードの検索及びデータ抽出|
|update|レコードの更新|
|insert|レコードの挿入|
|delete|レコードの削除|

### SQLiteの列に指定出来る型
 
|型|説明|
|:------|:------------------|
|TEXT|文字列を格納する|
|NUMERIC|整数または浮動小数点を格納する|
|INTEGER|整数を格納する|
|REAL|浮動小数点数を格納する|
|NONE|変換なし|

### SQLiteの列に指定出来る制約

|制約|説明|
|:------|:------------------|
|PRIMARY_KEY|テーブルの主キー|
|NOT NULL|NULLを保存するとエラーになる|
|DEFAULT|生成時に指定されない場合のデフォルト値を設定|
|UNIQUE|重複した値を格納した場合はエラーになる|
|AUTOINCREMENT|生成時に自動で値をナンバリングする|

<br>
 
## SQLiteの使い方

1. Androidでデータベースにアクセスするには、SQLiteOpenHelperクラスを継承したクラス「データベースヘルパー」を定義する。ヘルパーはDBの生成とアップグレードを管理してくれる。SQLiteOpenHelperクラスのonCreate()とonUpgrade()をオーバーライドする。

~~~java
onCreate()メソッド     //データベース生成時に呼ばれる
onUpgrade()メソッド    //データベースアップグレード時に呼ばれる
~~~

2. 各種変数を定義する

~~~java
private final static String DB_NAME    = "test.db";//DB名
private final static String DB_TABLE   = "test";   //テーブル名
private final static int    DB_VERSION = 1;        //バージョン
private SQLiteDatabase db;  //データベースオブジェクト
~~~

3. onCreate内でデータベースオブジェクトを取得

~~~java
//データベースオブジェクトの取得
DBHelper dbHelper = new DBHelper(this);
db = dbHelper.getWritableDatabase();
~~~

4. onClick内で書き込みと読み込み（trycatchで囲う）
~~~java
//TAG_WRITEが押された多DBへの書き込み
String str = editText.getText().toString();
writeDB(str);
        
//TAG_READが押されたらDBからの読み込み
String str = readDB();
editText.setText(str);
~~~

~~~java
//書き込み用のwriteDBメソッド
private void writeDB(String info) throws Exception {
    ContentValues values = new ContentValues();
    values.put("id", "0");
    values.put("info", info);
    int colNum = db.update(DB_TABLE, values, null, null);
    if (colNum == 0) db.insert(DB_TABLE, "", values);
}
~~~

~~~java
//読み込み用のreadDBメソッド
private String readDB() throws Exception {
    Cursor c = db.query(DB_TABLE, new String[]{"id", "info"},"id='0'", null, null, null, null);
    
    if (c.getCount() == 0) throw new Exception();
    c.moveToFirst();
    String str = c.getString(1);
    c.close();
    return str;
}
~~~

5. データベースヘルパー登場！<br>DBの生成時には、onCreateメソッドが呼ばれ、execSQLメソッドでSQLの命令文が実行される。<br>アップグレードの場合は、dropで削除した後にonCreateを呼び出して新しく作成

~~~java
//データベースヘルパーの定義
private static class DBHelper extends SQLiteOpenHelper {
    //データベースヘルパーのコンストラクタ
    //①コンテキスト②DBファイル名③ファクトリー④ヴァージョン
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //データベースの生成時にこのonCreateメソッドが呼ばれる
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+DB_TABLE+"(id text primary key,info text)");
    }

    //データベースのアップグレード
    //onUpgradeの引数　①DBオブジェクト②旧バージョン番号③新バージョン番号
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("drop talbe if exists "+DB_TABLE);
        onCreate(db);
    }
}
~~~

<br>

## Android 端末内の SQLite の操作

1. エミュレータを起動(起動しないと中に入れない)
~~~java
C:\Users\●●●> adb shell
//パスが通ってなかったらこっち
C:\Users\●●●> C:\Users\●●●●\AppData\Local\Android\sdk\platform-tools\adb shell
~~~
2. これが出たら成功
~~~java
generic_x86_64:/ $
~~~
3. run-as でAndroidのパッケージに入る
~~~java
generic_x86_64:/ $ run-as com.hogehoge
~~~
4. 入れた！
~~~java
generic_x86_64:/data/data/com.hogehoge $
~~~
5. 入れたらpwd コマンドでカレントディレクトリを調べる
~~~java
generic_x86_64:/data/data/com.hogehoge $ pwd
/data/data/com.hogehoge
~~~
6. ls コマンドでカレントディレクトリのフォルダ、ファイルを一覧表示
~~~java
127|generic_x86_64:/data/data/com.hogehoge $ ls -la
total 48
drwx------   4 ●●●● ●●●● ●●●● 2017-03-27 01:30 .
drwxrwx--x 131 system  system  ●●●● 2017-03-27 01:30 ..
drwxrwx--x   2 ●●●● ●●●● ●●●● 2017-03-27 01:30 cache
drwxrwx--x   2 ●●●● ●●●● ●●●● 2017-03-27 01:30 databases
~~~
7. cd コマンドで databases フォルダに移動
~~~java
generic_x86_64:/data/data/com.hogehoge $ cd databases
generic_x86_64:/data/data/com.hogehoge/databases $
~~~
8. ls コマンドでカレントディレクトリのフォルダ、ファイルを一覧表示<br>
※拡張子「db」がデータベース
~~~java
generic_x86_64:/data/data/com.hogehoge/databases $ ls -l
total 64
-rw-rw---- 1 ●●●● ●●●● ●●●● 2017-03-27 01:30 test.db
-rw------- 1 ●●●● ●●●● ●●●● 2017-03-27 01:30 test.db-journal
~~~
9. sqlite3 test.dbで、特定のデータベースを指定して、データベースを開く
sqlite>が表示されれば成功！
~~~java
generic_x86_64:/data/data/com.hogehoge/databases $ sqlite3 test.db
SQLite version 3.9.2 2015-11-02 18:31:45
Enter ".help" for usage hints.
sqlite>
~~~
10. .tablesで存在するテーブルの確認
~~~java
sqlite> .tables
android_metadata  test
sqlite>
~~~
11. .schema テーブル名、でテーブルの構成を確認
~~~java
sqlite> .schema test
CREATE TABLE test(id text primary key,info text);
sqlite>
~~~
12. sqlite3 データベース名、でデータベースの作成
~~~java
sqlite> sqlite3 test
   ...>
~~~
13. テーブルの作成
~~~java
create table pason(id integer, name text);
insert into pason values(1, 'Shiga');
insert into pason values(2, 'Tokyo');
insert into pason values(3, 'Kyoto');
~~~
14.テーブルの情報確認
~~~java
//構成
sqlite> .schema pason
CREATE TABLE pason(id integer, name text);
//中身
sqlite> select * from pason;
1|Shiga
2|Tokyo
3|Kyoto
~~~
15. 終了
~~~java
.exit
~~~

## Android 端末内の SQLite の操作 (Mac編)

SQLite3が入ってるのを確認したら
~~~java
$ sqlite3 -version
3.8.10.2 2015-05-20 18:17:19 2ef4f3a5b1d1d0c4338f8243d40a2452cc1f7fe4
~~~

そのまま入る！
~~~java
$ sqlite3 com.hogehoge
SQLite version 3.8.10.2 2015-05-20 18:17:19
Enter ".help" for usage hints.
sqlite> 
~~~

あとはだいたい同じ
~~~java
sqlite> .database  // 現在接続してるDBとファイルの保存場所を確認
sqlite> .quit  // SQLiteを終了する
sqlite> .exit  // SQLiteを終了する
sqlite> .help  // コマンドの一覧
sqlite> .table  // テーブルの一覧
~~~
