package app.tejpalnagar.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.tejpalnagar.DashboardSection.VideoFullScreen;
import app.tejpalnagar.Models.DataSetList;
import app.tejpalnagar.R;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.ViewHolder> {

    ArrayList<DataSetList> arrayList;
    Context context;

    public YoutubeAdapter(ArrayList<DataSetList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_per_row,parent,false);
        return new YoutubeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DataSetList current = arrayList.get(position);
        holder.webView.loadUrl(current.getLink());
        holder.button.setOnClickListener(view -> {

            Intent i = new Intent(context, VideoFullScreen.class);
            i.putExtra("link",current.getLink());
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WebView webView;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            webView = itemView.findViewById(R.id.video_view);
            button = itemView.findViewById(R.id.fullscreen);
            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
        }
    }
}
