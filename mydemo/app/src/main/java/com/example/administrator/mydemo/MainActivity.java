package com.example.administrator.mydemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String myquanxian = "com.ylc.cly";



    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new  WebViewClient(){
            public  boolean  shouldOverrideUrlLoading(WebView  view, String url) {
                view.loadUrl(url);
                return  true ;
            }
        });
        webView.loadUrl("http://www.baidu.com");


        //check 权限
        int checkResult = this.checkCallingOrSelfPermission(myquanxian);
        if(checkResult == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(MainActivity.this,"可以访问",1).show();
        }else{
            Toast.makeText(MainActivity.this,"不可以访问",1).show();
        }
    }

    public void open(View view){
        Intent it = new Intent(MainActivity.this,MainActivity2.class);
        MainActivity.this.startActivity(it);

    }

}
