package app.tejpalnagar.FragmentsSection;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.tejpalnagar.Adapters.CompletedEventAdapter;
import app.tejpalnagar.Adapters.UpcomingEventAdapter;
import app.tejpalnagar.Models.UpcomingEventModel;
import app.tejpalnagar.R;


public class CompletedEventFragment extends Fragment {
    
    RecyclerView recyclerCompletedEvents;
    CompletedEventAdapter completedEventAdapter;
    
    public CompletedEventFragment(){
        
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_event, container, false);
        recyclerCompletedEvents = view.findViewById(R.id.recyclerCompletedEvents);
        completedEvents();
        return view;
    }

    private void completedEvents() {

        recyclerCompletedEvents.setHasFixedSize(true);
        recyclerCompletedEvents.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ArrayList<UpcomingEventModel> upcomingEventModels = new ArrayList<>();
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        completedEventAdapter = new CompletedEventAdapter(getContext(),upcomingEventModels);
        recyclerCompletedEvents.setAdapter(completedEventAdapter);
    }
}