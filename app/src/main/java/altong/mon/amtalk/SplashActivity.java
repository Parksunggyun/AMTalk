package altong.mon.amtalk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import altong.mon.amtalk.login.LoginActivity;
import altong.mon.amtalk.security.FingerPrintActivity;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SplashActivity activity = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if(!TextUtils.isEmpty(email)) {
                        boolean useFingerprint = userData.getBoolean("fingerprint", false);
                        Log.d("useFingerprint", "=>" + useFingerprint);
                        if(useFingerprint) {
                            startActivity(new Intent(activity, FingerPrintActivity.class));
                        } else {
                            startActivity(new Intent(activity, MainActivity.class));
                        }
                    } else {
                            startActivity(new Intent(activity, LoginActivity.class));
                    }
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1500);
    }
}
