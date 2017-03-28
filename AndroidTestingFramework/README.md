# Android Testing Framework 

AndroidSDKに標準装備されているものとしてAndroid Testing Frameworkがあります。これは、Java の JUnit という単体テストの為のフレームワークをAndroid 用に拡張したものです。JUnit 自体は単体テストに特化しており、UIのテストには不向きでしたが、Android Testing Framework なら UI のようなAndroid アプリに欠かせない要素もテストする事ができます。<br><br>

#### 作成するプロジェクト（通常通りのパッケージに作成） 

|プロジェクト名 |クラス名 |
|:------|:------------------|
|DisplayText|DisplayText|

#### テストプロジェクト（パッケージ名の後ろに（androidTest）の記述があるパッ
ケージに作成） 

|プロジェクト名 |クラス名 |
|:------|:------------------|
|DisplayTextTest|DisplayTextTest|

#### ファイル構成

~~~java
app
  manifests
  java
    com.hogehoge
      Calculator
      DisplayText
      MainActivity
    com.hogehoge(AndroidTest)
      Calculator
      DisplayText
      MainActivity
    com.hogehoge(test)
~~~

#### build.gradle(Module:app) 

~~~xml
android {
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    defaultConfig {
        applicationId "com.tajima.mgt.androidtest2"
        minSdkVersion 17
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'),
                    'proguard-rules.pro'
        }
    }
}
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })
    compile 'com.android.support:appcompat-v7:25.1.0'
    testCompile 'junit:junit:4.12'
}
~~~

#### レイアウトファイル <br>res/layout/activity_main.xml 
