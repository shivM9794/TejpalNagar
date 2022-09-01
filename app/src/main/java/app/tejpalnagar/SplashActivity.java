package app.tejpalnagar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class SplashActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setFCMToken();
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),Splash2Activity.class);
                startActivity(intent);
            }
        },3000);
    }

    private void setFCMToken() {

        try {
            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Firebase", "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            String token = task.getResult();
                            if (token != null && !token.isEmpty()) {

                            }
                            Log.e("Firebase-Token", token);
                        }


                    });

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}