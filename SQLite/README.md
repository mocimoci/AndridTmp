# SQLite

データベースを操作する言語の無料簡易版<br>
Android / iPhoneで使われている
 
 
<br><br><br>

### Android 端末内の SQLite の操作

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
-rw-rw---- 1 u0_a109 u0_a109 20480 2017-03-27 01:30 test.db
-rw------- 1 u0_a109 u0_a109  8720 2017-03-27 01:30 test.db-journal
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
drop emp1;
CREATE TABLE emp1 (
_id integer primary key autoincrement,
emp_name text not null,
dep_no integer not null,
saraly integer not null);
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (1, 'sam', '101', '350000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (2, 'michal', '101', '330000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (3, 'mika', '101', '340000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (4, 'jyun', '102', '280000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (5, 'ichiro', '102', '260000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (6, 'yasu', '201', '320000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (7, 'toranpu', '201',
'300000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (8, 'yama', '201', '290000' ) ;
insert into emp1 ( _id, emp_name, dep_no, saraly ) values (9, 'joe', '202', '250000' ) ;
drop dep1;
CREATE TABLE dep1 (
dep_no integer primary key,
dep_name text not null);
insert into dep1 ( dep_no, dep_name ) values ( 101, 'sales' ) ;
insert into dep1 ( dep_no, dep_name ) values ( 102, 'develop' ) ;
insert into dep1 ( dep_no, dep_name ) values ( 201, 'personal' ) ;
insert into dep1 ( dep_no, dep_name ) values ( 202, 'planning' ) ;
~~~
14. 終了
~~~java
.exit
~~~

~~~java

~~~
