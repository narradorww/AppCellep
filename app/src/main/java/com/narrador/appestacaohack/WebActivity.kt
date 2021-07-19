package com.narrador.appestacaohack

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.narrador.appestacaohack.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //habilitandi a execução de codigo javascript
        binding.webView.settings.javaScriptEnabled = true

        binding.webView.loadUrl("https://br.cellep.com/estacaohack/")

        binding.webView.webViewClient = WebViewClient()


    }
}