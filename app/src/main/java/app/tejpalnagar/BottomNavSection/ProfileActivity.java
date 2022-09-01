package app.tejpalnagar.BottomNavSection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.github.drjacky.imagepicker.ImagePicker;

import app.tejpalnagar.DashboardSection.DashboardActivity;
import app.tejpalnagar.R;
import app.tejpalnagar.SideNavSection.ComplaintActivity;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView image_back;
    CircleImageView profileupdate;
    EditText et_userName,et_userNo,et_userAddress,et_userPincode,et_userDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initViews();
    }

    private void initViews() {
        image_back = findViewById(R.id.image_back);
        image_back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });
        et_userName = findViewById(R.id.et_userName);
        et_userNo = findViewById(R.id.et_userNo);
        et_userAddress = findViewById(R.id.et_userAddress);
        et_userPincode = findViewById(R.id.et_userPincode);
        et_userDOB = findViewById(R.id.et_userDOB);
        profileupdate = findViewById(R.id.profileupdate);
        profileupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(ProfileActivity.this)
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
        profileupdate.setImageURI(selectedImage);
    }

    public void Update(View view) {


        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Congratulation")
                .setContentText("Profile Updated Successfully")
                .setConfirmText("OK")
                .setConfirmClickListener(sweetAlertDialog -> {
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                })
                .show();
    }
}