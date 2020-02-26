package com.example.allexercises.LayoutsPackage.WebView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.allexercises.R
import kotlinx.android.synthetic.main.activity_web__view.*

class Web_View : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web__view)

        val webView: WebView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("http://www.google.com")

        val webSettings: WebSettings =webView.settings
        webSettings.javaScriptEnabled = true
    }

    override fun onBackPressed() {
        if (webview.canGoBack())
        {
            webview.goBack()
        } else
        {
            super.onBackPressed()
        }
    }
}
