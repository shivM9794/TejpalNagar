package app.tejpalnagar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.tejpalnagar.Models.VideoModal;
import app.tejpalnagar.R;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    Context context;
    ArrayList<VideoModal> videoModals = new ArrayList<>();

    public VideoAdapter(Context context, ArrayList<VideoModal> videoModals) {
        this.context = context;
        this.videoModals = videoModals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video,parent,false);
        return new VideoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VideoModal videoModal = videoModals.get(position);
        holder.imageView.setImageResource(videoModal.getImageView());

    }

    @Override
    public int getItemCount() {
        return videoModals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
