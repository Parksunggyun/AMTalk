package altong.mon.amtalk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SplashActivity activity = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    startActivity(new Intent(activity, MainActivity.class));
                    /*Class toClass;
                    SharedPreferences autoLogin = getSharedPreferences(getString(R.string.autoLogin), Activity.MODE_PRIVATE);
                    String loginId = autoLogin.getString("email", null);
                    String restId = autoLogin.getString("rest_id", null);
                    if (!TextUtils.isEmpty(loginId) && !TextUtils.isEmpty(restId)) {
                        toClass = MainActivity.class;
                    } else if(!TextUtils.isEmpty(loginId) && TextUtils.isEmpty(restId)){
                        toClass = SelectRestActivity.class;
                    } else {
                        toClass = SelectActivity.class;
                    }
                    Intent intent = new Intent(activity, toClass);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fab_fadein,R.anim.fab_fadeout);*/
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1500);
    }
}
