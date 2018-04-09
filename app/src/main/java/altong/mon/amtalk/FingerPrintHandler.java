package altong.mon.amtalk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

/*
 * Created by 15U560 on 2017-12-06.
 */

@TargetApi(Build.VERSION_CODES.M)
public class FingerPrintHandler extends FingerprintManager.AuthenticationCallback {

    private Context appContext;
    private AppCompatActivity baseActivity;
    private ImageView imgView;

    public FingerPrintHandler(Context context, AppCompatActivity activity, ImageView imgView) {
        this.appContext = context;
        this.baseActivity = activity;
        this.imgView = imgView;
    }

    public void startAuth(FingerprintManager manager, FingerprintManager.CryptoObject cryptoObject) {
        CancellationSignal cancellationSignal = new CancellationSignal();
        manager.authenticate(cryptoObject, cancellationSignal, 0, this, null);
    }

    @Override
    public void onAuthenticationError(int errMsgId,
                                      CharSequence errString) {
        Toast.makeText(appContext,
                "Authentication error\n" + errString,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationHelp(int helpMsgId,
                                     CharSequence helpString) {
        Toast.makeText(appContext,
                "Authentication help\n" + helpString,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAuthenticationFailed() {
        Toast.makeText(appContext,
                "등록되지 않은 지문입니다." ,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAuthenticationSucceeded(
            FingerprintManager.AuthenticationResult result) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    imgView.setImageResource(R.drawable.ic_fingerprint_after_24dp);
                    Thread.sleep(300);
                    baseActivity.startActivity(new Intent(baseActivity, MainActivity.class));
                    baseActivity.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 300);
    }
}
