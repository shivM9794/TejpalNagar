package app.tejpalnagar.DashboardSection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import app.tejpalnagar.Adapters.MemorableAdapter;
import app.tejpalnagar.Adapters.SliderAdapter;
import app.tejpalnagar.Adapters.TejpalPhotoAdapter;
import app.tejpalnagar.Adapters.VideoAdapter;
import app.tejpalnagar.Adapters.YoutubeAdapter;
import app.tejpalnagar.BottomNavSection.EventsActivity;
import app.tejpalnagar.BottomNavSection.ProfileActivity;
import app.tejpalnagar.Models.DataSetList;
import app.tejpalnagar.Models.MemorableModal;
import app.tejpalnagar.Models.TejpalPhotoModal;
import app.tejpalnagar.R;
import app.tejpalnagar.SideNavSection.AboutUsActivity;
import app.tejpalnagar.SideNavSection.BJPIndiaActivity;
import app.tejpalnagar.SideNavSection.BJPUPActivity;
import app.tejpalnagar.SideNavSection.ComplaintActivity;
import app.tejpalnagar.SideNavSection.LanguageTranslatorActivity;
import app.tejpalnagar.SideNavSection.PrivacyActivity;
import app.tejpalnagar.SideNavSection.ScanningActivity;
import app.tejpalnagar.SideNavSection.TermsAndConditionsActivity;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SliderView sliderView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView imageView, imgFlower, imgFlower2, imgFlower3, imgFlower4, imgFlower5, imgFlower6;
    LinearLayout clickable_ll;
    ChipNavigationBar bottom_nav;
    RecyclerView recyclerPhotos, recyclerview;
    TejpalPhotoAdapter tejpalPhotoAdapter;
    ViewPager2 viewPagerImageSlider;
    ArrayList<DataSetList> arrayList;
    private Handler sliderHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initViews();
        sliderImage();
        navigationdrawer();
        photoSection();
        videoSection();

        ArrayList<MemorableModal> memorableModals = new ArrayList<>();
        memorableModals.add(new MemorableModal(R.drawable.bannar2));
        memorableModals.add(new MemorableModal(R.drawable.memorable1));
        memorableModals.add(new MemorableModal(R.drawable.memorable2));
        memorableModals.add(new MemorableModal(R.drawable.memorable3));
        memorableModals.add(new MemorableModal(R.drawable.memorable4));
        memorableModals.add(new MemorableModal(R.drawable.memorable5));
        viewPagerImageSlider.setAdapter(new MemorableAdapter(this, memorableModals));
        viewPagerImageSlider.setClipToPadding(false);
        viewPagerImageSlider.setClipChildren(false);
        viewPagerImageSlider.setOffscreenPageLimit(3);
        viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPagerImageSlider.setPageTransformer(compositePageTransformer);
        viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);
            }
        });


        bottom_nav.setOnItemSelectedListener(i -> {
            switch (i) {

                case R.id.activity:
                    Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent);
                    break;

                case R.id.settings:
                    Intent intent1 = new Intent(getApplicationContext(), EventsActivity.class);
                    startActivity(intent1);
                    break;

            }

        });


    }

    private void videoSection() {
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        arrayList = new ArrayList<DataSetList>();
        DataSetList dataSetList = new DataSetList("https://www.youtube.com/watch?v=sZYuOjZIWpA");
        arrayList.add(dataSetList);
        DataSetList dataSetList1 = new DataSetList("https://www.youtube.com/watch?v=Om26855QKmY");
        arrayList.add(dataSetList1);
        DataSetList dataSetList2 = new DataSetList("https://www.youtube.com/watch?v=NMO-nYoDXig");
        arrayList.add(dataSetList2);
        DataSetList dataSetList3 = new DataSetList("https://www.youtube.com/watch?v=uT1Yh2DmUA4");
        arrayList.add(dataSetList3);
        DataSetList dataSetList4 = new DataSetList("https://www.youtube.com/watch?v=q7vmEr8VpRA");
        arrayList.add(dataSetList4);
        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(arrayList, getApplicationContext());
        recyclerview.setAdapter(youtubeAdapter);
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPagerImageSlider.setCurrentItem(viewPagerImageSlider.getCurrentItem() + 1);
        }
    };


    private void photoSection() {
        recyclerPhotos.setHasFixedSize(true);
        recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<TejpalPhotoModal> tejpalPhotoModals = new ArrayList<>();
        tejpalPhotoModals.add(new TejpalPhotoModal(R.drawable.bannar1));
        tejpalPhotoModals.add(new TejpalPhotoModal(R.drawable.bannar2));
        tejpalPhotoModals.add(new TejpalPhotoModal(R.drawable.bannar3));
        tejpalPhotoModals.add(new TejpalPhotoModal(R.drawable.bannar4));
        tejpalPhotoAdapter = new TejpalPhotoAdapter(this, tejpalPhotoModals);
        recyclerPhotos.setAdapter(tejpalPhotoAdapter);


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

    private void initViews() {
        sliderView = findViewById(R.id.slider_image);
        imageView = findViewById(R.id.drawer_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setItemSelected(R.id.home, true);
//        clickable_ll = findViewById(R.id.clickable_ll);
//        clickable_ll.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), AboutTejpalnagarActivity.class);
//            startActivity(intent);
//            finish();
//        });
        imgFlower = findViewById(R.id.imgFlower);
        imgFlower.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), AppoinmentActivity.class);
            startActivity(intent);
            finish();
        });
        imgFlower2 = findViewById(R.id.imgFlower2);
        imgFlower2.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), NarendarModiActivity.class);
            startActivity(intent);
            finish();
        });
        imgFlower3 = findViewById(R.id.imgFlower3);
        imgFlower3.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), YogiJiActivity.class);
            startActivity(intent);
            finish();
        });
        imgFlower4 = findViewById(R.id.imgFlower4);
        imgFlower4.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CowinActivity.class);
            startActivity(intent);
            finish();
        });
        imgFlower5 = findViewById(R.id.imgFlower5);
        imgFlower5.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DadriActivity.class);
            startActivity(intent);
            finish();
        });
        imgFlower6 = findViewById(R.id.imgFlower6);
        imgFlower6.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ComplaintActivity.class);
            startActivity(intent);
            finish();
        });
        recyclerPhotos = findViewById(R.id.recyclerPhotos);
        viewPagerImageSlider = findViewById(R.id.viewPagerImageSlider);
        recyclerview = findViewById(R.id.recyclerview);

    }

    private void navigationdrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.languageTranslator);
        imageView.setOnClickListener(v -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.languageTranslator:
//                Intent intent = new Intent(getApplicationContext(), LanguageTranslatorActivity.class);
//                startActivity(intent);
//                break;

            case R.id.imageScanner:
                Intent intent1 = new Intent(getApplicationContext(), ScanningActivity.class);
                startActivity(intent1);
                break;

            case R.id.whatsapp:
                startSupportChat();
                break;

            case R.id.privacy:
                Intent intent2 = new Intent(getApplicationContext(), PrivacyActivity.class);
                startActivity(intent2);
                break;

            case R.id.terms:
                Intent intent3 = new Intent(getApplicationContext(), TermsAndConditionsActivity.class);
                startActivity(intent3);
                break;

            case R.id.bjp_up:
                Intent intent4 = new Intent(getApplicationContext(), BJPUPActivity.class);
                startActivity(intent4);
                break;

            case R.id.bjp_india:
                Intent intent5 = new Intent(getApplicationContext(), BJPIndiaActivity.class);
                startActivity(intent5);
                break;

            case R.id.complaintRegistration:
                Intent intent6 = new Intent(getApplicationContext(), ComplaintActivity.class);
                startActivity(intent6);
                break;

            case R.id.aboutUs:
                Intent intent7 = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(intent7);
                break;
        }
        return true;
    }


    private void startSupportChat() {

        try {
            String headerReceiver = "";// Replace with your message.
            String bodyMessageFormal = "";// Replace with your message.
            String whatsappContain = headerReceiver + bodyMessageFormal;
            String trimToNumner = "+918112879804"; //10 digit number
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/" + trimToNumner + "/?text=" + ""));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}