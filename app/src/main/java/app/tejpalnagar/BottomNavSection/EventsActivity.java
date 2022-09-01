package app.tejpalnagar.BottomNavSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import app.tejpalnagar.Adapters.PageAdapter;
import app.tejpalnagar.DashboardSection.DashboardActivity;
import app.tejpalnagar.R;

public class EventsActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    PageAdapter pageAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        tabLayout = findViewById(R.id.tablayout);
        tabItem1 = findViewById(R.id.tab1);
        tabItem2 = findViewById(R.id.tab2);
        viewPager = findViewById(R.id.vpager);
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
    }
