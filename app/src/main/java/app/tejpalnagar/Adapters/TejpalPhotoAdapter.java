package app.tejpalnagar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.tejpalnagar.Models.TejpalPhotoModal;
import app.tejpalnagar.R;

public class TejpalPhotoAdapter extends RecyclerView.Adapter<TejpalPhotoAdapter.ViewHolder> {

    Context context;
    ArrayList<TejpalPhotoModal> tejpalPhotoModals = new ArrayList<>();

    public TejpalPhotoAdapter(Context context, ArrayList<TejpalPhotoModal> tejpalPhotoModals) {
        this.context = context;
        this.tejpalPhotoModals = tejpalPhotoModals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tejpal_photos,parent,false);
        return new TejpalPhotoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TejpalPhotoModal tejpalPhotoModal = tejpalPhotoModals.get(position);
        holder.imageView.setImageResource(tejpalPhotoModal.getImageView());

    }

    @Override
    public int getItemCount() {
        return tejpalPhotoModals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
