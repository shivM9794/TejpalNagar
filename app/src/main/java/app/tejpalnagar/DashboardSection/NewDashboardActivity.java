package app.tejpalnagar.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import app.tejpalnagar.Adapters.SliderAdapter;
import app.tejpalnagar.Adapters.TejpalPhotoAdapter;
import app.tejpalnagar.Models.TejpalPhotoModal;
import app.tejpalnagar.R;

public class NewDashboardActivity extends AppCompatActivity {

    SliderView sliderView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dashboard);
        initViews();
        sliderImage();

    }

    private void initViews() {

        sliderView = findViewById(R.id.slider_image);
        imageView = findViewById(R.id.drawer_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
    }

    private void sliderImage() {
        ArrayList<Integer> slider = new ArrayList<>();
        slider.add(R.drawable.bannar1);
        slider.add(R.drawable.bannar2);
        slider.add(R.drawable.bannar3);
        slider.add(R.drawable.bannar4);
        SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext(), slider);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    }
