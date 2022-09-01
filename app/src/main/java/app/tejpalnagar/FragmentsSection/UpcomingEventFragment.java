package app.tejpalnagar.FragmentsSection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.tejpalnagar.Adapters.UpcomingEventAdapter;
import app.tejpalnagar.Models.UpcomingEventModel;
import app.tejpalnagar.R;


public class UpcomingEventFragment extends Fragment {

    RecyclerView recyclerUpcomingEvents;
    UpcomingEventAdapter upcomingEventAdapter;

    public UpcomingEventFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming_event, container, false);
        recyclerUpcomingEvents = view.findViewById(R.id.recyclerUpcomingEvents);
        showEvents();
        return view;
    }

    private void showEvents() {

        recyclerUpcomingEvents.setHasFixedSize(true);
        recyclerUpcomingEvents.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        ArrayList<UpcomingEventModel> upcomingEventModels = new ArrayList<>();
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventModels.add(new UpcomingEventModel(R.drawable.rally,"Beti Padho Beti Bachoo Abhiyaan"));
        upcomingEventAdapter = new UpcomingEventAdapter(getContext(),upcomingEventModels);
        recyclerUpcomingEvents.setAdapter(upcomingEventAdapter);
    }

}