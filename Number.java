
package com.example.myapplication;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;

public class Number extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// 1. Находим WebView по ID
        webView = findViewById(R.id.webView);

// 2. Включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);

// 3. Включаем хранение данных (для рекордов)
        webView.getSettings().setDomStorageEnabled(true);

// 4. Настраиваем масштабирование под экран
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

// 5. Загружаем игру из папки assets
        webView.loadUrl("file:///android_asset/index.html");

// 6. Ссылки открываются внутри приложения
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
    }

    // Кнопка "Назад" работает как в браузере
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}