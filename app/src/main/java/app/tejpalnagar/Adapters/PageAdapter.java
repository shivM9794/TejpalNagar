package app.tejpalnagar.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import app.tejpalnagar.FragmentsSection.CompletedEventFragment;
import app.tejpalnagar.FragmentsSection.UpcomingEventFragment;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0: return new UpcomingEventFragment();
            case 1: return new CompletedEventFragment();
            default: return null;

        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }

}
