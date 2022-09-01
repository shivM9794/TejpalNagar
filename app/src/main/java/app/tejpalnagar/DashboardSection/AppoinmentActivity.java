package app.tejpalnagar.DashboardSection;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import app.tejpalnagar.R;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class AppoinmentActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    ImageView image_back;
    int count = 0;
    TextView tv_timer1,tv_date;
    int t1Hour,t1Minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);
        initViews();
    }

    private void initViews() {
        image_back = findViewById(R.id.image_back);
        image_back.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(intent);
            finish();
        });
        tv_date = findViewById(R.id.tv_date);
        tv_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
                count = 1;
            }
        });
        tv_timer1 = findViewById(R.id.tv_timer1);
        tv_timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(AppoinmentActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        t1Hour = i;
                        t1Minute = i1;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,t1Hour,t1Minute);
                        tv_timer1.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                },12,0,false);
                timePickerDialog.updateTime(t1Hour,t1Minute);
                timePickerDialog.show();
            }
        });

    }


    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        if (count == 1) {
            String date = "" + i + "/" + i1 + "/" + i2;
            tv_date.setText(date);
        }



    }

    public void schedule(View view) {

        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Appointment Scheduled!")
                .setContentText("You will receive an sms with complete details")
                .setConfirmText("OK")
                .setConfirmClickListener(sweetAlertDialog -> {
                    Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                    startActivity(intent);
                })
                .show();



    }
}