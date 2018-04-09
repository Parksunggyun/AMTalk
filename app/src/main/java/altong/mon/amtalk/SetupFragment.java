package altong.mon.amtalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import altong.mon.amtalk.databinding.FragmentSetupBinding;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class SetupFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    FragmentSetupBinding binding;
    FingerprintManager manager;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_setup, container, false);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager = (FingerprintManager) getContext().getSystemService(Context.FINGERPRINT_SERVICE);
        }
        String url = BaseActivity.url;
        String nickName = BaseActivity.nickname;
        String email = BaseActivity.email;
        //Picasso.with(getContext()).load(url).transform(new RoundedCornersTransformation(50,0)).resize(100,100).into(binding.profileIv);
        binding.personalEmailTxtView.setText(email);
        binding.personalNicknameTxtView.setText(nickName);

        binding.logoutBtn.setOnClickListener(this);
        binding.fingerPrintTxtView.setOnClickListener(this);
        binding.personalLayout.setOnClickListener(this);
        binding.useFingerprintSwitch.setOnCheckedChangeListener(this);
        if(Build.VERSION.SDK_INT>=23) {
            if (manager.isHardwareDetected()) {
                boolean useFinger = BaseActivity.userData.getBoolean("fingerprint", false);
                if (useFinger) {
                    binding.useFingerprintSwitch.setChecked(true);
                } else {
                    binding.useFingerprintSwitch.setChecked(false);
                }
            } else {
                binding.fingerPrintTxtView.setText("Security");
                binding.useFingerprintSwitch.setVisibility(View.GONE);
            }
        } else {
            binding.fingerPrintTxtView.setText("Security");
            binding.useFingerprintSwitch.setVisibility(View.GONE);

        }
        view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        SharedPreferences.Editor editor = BaseActivity.userData.edit();
        if (b) {
            editor.putBoolean("fingerprint", true);
        } else {
            editor.putBoolean("fingerprint", false);
        }
        editor.apply();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logoutBtn:
                break;
            case R.id.fingerPrintTxtView:
                if(Build.VERSION.SDK_INT>=23) {
                    boolean isOn = manager.isHardwareDetected();
                    Log.d("Is this device use", "fingerprint ? => " + isOn);
                    if (manager.hasEnrolledFingerprints()) {
                        Log.d("지문이", "하나이상 등록되어 있슴다.");

                    } else {
                        Log.d("지문이", "등록되어 있지 않슴다.");
                    }
                } else {
                    Snackbar.make(view, "지문인식 기능을 지원하지 않는 기기입니다.", Snackbar.LENGTH_SHORT);
                }
                break;
            case R.id.personalLayout:
                break;
        }
    }

}
