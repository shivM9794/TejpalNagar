package app.tejpalnagar.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import app.tejpalnagar.R;

public class NarendarModiActivity extends AppCompatActivity {

    WebView webView;
    ImageView image_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narendar_modi);

        image_back = findViewById(R.id.image_back);
        image_back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        });


        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog = null;

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(NarendarModiActivity.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                try {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                } catch (Exception e) {

                }

            }
        });


        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://en.wikipedia.org/wiki/Narendra_Modi");
    }
}