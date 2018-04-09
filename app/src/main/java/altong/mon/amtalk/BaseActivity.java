package altong.mon.amtalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/*
 * Created by 15U560 on 2017-12-05.
 */

public class BaseActivity extends AppCompatActivity {
    public static SharedPreferences userData;
    public static String name, nickname, email, url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getWindow().getDecorView();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
        }
        userData = getSharedPreferences("userData", Context.MODE_PRIVATE);
        name = userData.getString("name", null);
        nickname = userData.getString("nickname", null);
        email = userData.getString("email", null);
        url = userData.getString("profile", null);

    }
}
