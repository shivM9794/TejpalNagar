package app.tejpalnagar.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import app.tejpalnagar.R;

public class VideoFullScreen extends AppCompatActivity {
    ImageView image_back;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_full_screen);
        image_back = findViewById(R.id.image_back);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        webView = findViewById(R.id.full_video);
        String link = getIntent().getStringExtra("link");
        webView.loadUrl(link);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }
}