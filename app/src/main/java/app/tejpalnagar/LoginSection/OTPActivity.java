package app.tejpalnagar.LoginSection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import app.tejpalnagar.DashboardSection.DashboardActivity;
import app.tejpalnagar.R;

public class OTPActivity extends AppCompatActivity {

    TextInputLayout text_email_1, text_email_2, text_email_3, text_email_4;
    TextInputEditText et_email_1, et_email_2, et_email_3, et_email_4;
    String e1 = "", e2 = "", e3 = "", e4 = "";
    TextView tv_resendOTP, tv_error_msg, txt_heading;
    String code;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpactivity);

        initviews();
        addListeners();
    }

    private void initviews() {

        text_email_1 = findViewById(R.id.text_email_1);
        text_email_2 = findViewById(R.id.text_email_2);
        text_email_3 = findViewById(R.id.text_email_3);
        text_email_4 = findViewById(R.id.text_email_4);
        et_email_1 = findViewById(R.id.et_email_1);
        et_email_2 = findViewById(R.id.et_email_2);
        et_email_3 = findViewById(R.id.et_email_3);
        et_email_4 = findViewById(R.id.et_email_4);
        tv_error_msg = findViewById(R.id.tv_error_msg);
        txt_heading = findViewById(R.id.txt_heading);
        lottie = findViewById(R.id.lottie);
    }

    private void addListeners() {

        et_email_1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e1 = s.toString();
                if (e1.length() == 1)
                    et_email_2.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e2 = s.toString();
                if (e2.length() == 1)
                    et_email_3.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e3 = s.toString();
                if (e3.length() == 1)
                    et_email_4.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e4 = s.toString();
                checkForBlanks();
                if (e4.length() == 1)
                    hideKeyboardFrom(getApplicationContext(), et_email_4);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });


    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void checkForBlanks() {
        if (e1.equals("") || e2.equals("") || e3.equals("") || e4.equals("")) {
            findViewById(R.id.btn_submit).setVisibility(View.GONE);
        } else {

            findViewById(R.id.btn_submit).setVisibility(View.VISIBLE);
        }

    }

    public void verify_otp(View view) {


        String e = e1 + e2 + e3 + e4;

        Log.e("Email Otp", e);

        Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
//        intent.putExtra("user_id",userid);
//        intent.putExtra("verification_code",e);
        startActivity(intent);
        finish();
    }


}