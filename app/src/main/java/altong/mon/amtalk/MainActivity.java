package altong.mon.amtalk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import altong.mon.amtalk.adapter.MainFragmentAdapter;
import altong.mon.amtalk.databinding.ActivityMainBinding;
import altong.mon.amtalk.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    private static final int LAYOUT = R.layout.activity_main;

    ActivityMainBinding binding;

    String[] myProfiles = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, LAYOUT);
        Log.i(TAG,"onCreate()");
        int position = getIntent().getIntExtra("position", 0);

        myProfiles[0] = userData.getString("email",null);
        myProfiles[1] = userData.getString("nickname",null);
        myProfiles[2] = userData.getString("profile_url",null);

        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(),myProfiles);
        MainViewModel mainViewModel = new MainViewModel(this, binding.addFab, binding.tabLayout, binding.viewPager, adapter, position);
        mainViewModel.onCreate();
        binding.setMainModel(mainViewModel);
    }
}
