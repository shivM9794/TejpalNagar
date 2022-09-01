package app.tejpalnagar.SideNavSection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import app.tejpalnagar.R;

public class TermsAndConditionsActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.app-privacy-policy.com/live.php?token=tXqb2pYnPfc3wsV0aGlTpYa90JrOFoow");
    }
}