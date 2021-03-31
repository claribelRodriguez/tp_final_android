package com.clari.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.SearchView;

public class Documentacion extends AppCompatActivity {

    private WebView wvWeb;
    private SearchView svSearch;
    private static final String WIKI = "https://es.wikipedia.org/";
    private static final String HTTPS = "https://www.";
    private static final String SEARCH = "/search?q=";
    private ImageButton volver_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentacion);

        wvWeb = (WebView) findViewById(R.id.wv_web);
        wvWeb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                svSearch.setQuery(url, false);
            }
        });


        wvWeb.getSettings().setJavaScriptEnabled(true);
        wvWeb.loadUrl(WIKI);

        svSearch = (SearchView) findViewById(R.id.sv_search);
        svSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.isEmpty()) {
                    if (URLUtil.isValidUrl(HTTPS + query)) {
                        wvWeb.loadUrl(HTTPS + query);
                    }
                    else {
                        wvWeb.loadUrl(WIKI + SEARCH + query);
                    }
                    return true;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        volver_home = (ImageButton) findViewById(R.id.volver);

        volver_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Volver();
            }
        });
    }

    private void Volver() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (wvWeb.canGoBack()){
            wvWeb.goBack();
        }
        else {
            super.onBackPressed();
        }
    }
}