package com.example.patel.mananvpatel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webVIew extends AppCompatActivity {
    private WebView myWV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        //get the WebView and set javascript to be enabled for this webview
        myWV = (WebView) findViewById(R.id.mainWV);
        WebSettings webSettings = myWV.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //force the link to open in a webview instead of opening a browser.
        myWV.setWebViewClient(new WebViewClient());

        // get the information passed in from the other activity
        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("website");

        /* Based on the website logo clicked and passed in open the appropriate website*/

        if(value.equals("gh"))
        {
            myWV.loadUrl("https://github.com/MananVPatel");
        }
        if(value.equals("li"))
        {
            myWV.loadUrl("https://www.linkedin.com/in/manan-patel-40a7b960/");
        }
        if(value.equals("fb"))
        {
            myWV.loadUrl("https://www.facebook.com/mananvp");
        }

    }
}
