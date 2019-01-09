package com.example.ianschoenrock.layoutdesigner


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebViewClient




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.web_view)
        myWebView.webViewClient = Callback()

        search_button.setOnClickListener {

            var url = url_edit_text.text.toString()

            if(!url.contains("https://www."))
                url = "https://www.$url"

            myWebView.loadUrl(url)
        }

    }

    private inner class Callback : WebViewClient() {  

        override fun shouldOverrideUrlLoading(view: WebView, url: WebResourceRequest): Boolean {
            return false
        }

    }



}
