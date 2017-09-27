package com.example.dabin.www.xinkaibin1508a20170927;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private TextView textView;
    private String loadUrl = "http://www.baidu嘻嘻哈哈.com";
    String loadUrs1;
    String loadUrs2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview_main);
        textView = (TextView) findViewById(R.id.textview_main);
        final StringBuffer stringBuffer = new StringBuffer(loadUrl);
        stringBuffer.delete(16,20);

        textView.setText(stringBuffer.toString());
        //下划线
        textView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        webView.getSettings().setJavaScriptEnabled(true);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(stringBuffer.toString());
                webView.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String  url) {
                        if(url!=""){
                            view.loadUrl(url);   //在当前的webview中跳转到新的url
                            System.out.println("url:"+url);
                        }
                        return true;
                    }
                });

            }
        });




    }
}
