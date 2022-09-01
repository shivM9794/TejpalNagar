package app.tejpalnagar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.tejpalnagar.Models.MemorableModal;
import app.tejpalnagar.R;

public class MemorableAdapter extends RecyclerView.Adapter<MemorableAdapter.ViewHolder> {

    Context context;
    ArrayList<MemorableModal> memorableModals = new ArrayList<>();

    public MemorableAdapter(Context context, ArrayList<MemorableModal> memorableModals) {
        this.context = context;
        this.memorableModals = memorableModals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memorable_photos, parent, false);
        return new MemorableAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemorableModal memorableModal = memorableModals.get(position);
        holder.imagePoster.setImageResource(memorableModal.getImage());




    }

    @Override
    public int getItemCount() {
        return memorableModals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePoster;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePoster = itemView.findViewById(R.id.imagePoster);

        }
    }

}
