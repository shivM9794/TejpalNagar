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

import app.tejpalnagar.Models.UpcomingEventModel;
import app.tejpalnagar.R;

public class CompletedEventAdapter extends RecyclerView.Adapter<CompletedEventAdapter.ViewHolder> {

    Context context;
    ArrayList<UpcomingEventModel> upcomingEventModels = new ArrayList<>();

    public CompletedEventAdapter(Context context, ArrayList<UpcomingEventModel> upcomingEventModels) {
        this.context = context;
        this.upcomingEventModels = upcomingEventModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.completed_events,parent,false);
        return new CompletedEventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UpcomingEventModel upcomingEventModel = upcomingEventModels.get(position);
        holder.eventTitle.setText(upcomingEventModel.getEventTitle());
        holder.imageView.setImageResource(upcomingEventModel.getImageView());

    }

    @Override
    public int getItemCount() {
        return upcomingEventModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView eventTitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            eventTitle = itemView.findViewById(R.id.eventTitle);
        }
    }
}
