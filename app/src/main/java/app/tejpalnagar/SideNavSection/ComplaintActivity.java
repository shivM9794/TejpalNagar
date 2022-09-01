package app.tejpalnagar.SideNavSection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.drjacky.imagepicker.ImagePicker;

import app.tejpalnagar.DashboardSection.DashboardActivity;
import app.tejpalnagar.R;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class ComplaintActivity extends AppCompatActivity {

    ImageView image_back, complaintImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        initViews();
    }

    private void initViews() {
        image_back = findViewById(R.id.image_back);
        image_back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        complaintImg = findViewById(R.id.complaintImg);
        complaintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(ComplaintActivity.this)
                        .crop()
                        .cropOval()
                        .maxResultSize(1080, 1080)
                        .start(0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Uri selectedImage = data.getData();
        complaintImg.setImageURI(selectedImage);
    }

    public void submitComplaint(View view) {

        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Complaint Submitted")
                .setContentText("You will receive an sms with complete details")
                .setConfirmText("OK")
                .setConfirmClickListener(sweetAlertDialog -> {
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                })
                .show();

    }
}
