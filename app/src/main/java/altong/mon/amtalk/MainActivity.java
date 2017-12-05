package altong.mon.amtalk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import altong.mon.amtalk.adapter.MainFragmentAdapter;
import altong.mon.amtalk.databinding.ActivityMainBinding;
import altong.mon.amtalk.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int LAYOUT = R.layout.activity_main;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, LAYOUT);
        Log.i(TAG,"onCreate()");
        int position = getIntent().getIntExtra("position", 0);
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
        MainViewModel mainViewModel = new MainViewModel(binding.addFab, binding.tabLayout, binding.viewPager, adapter, position);
        mainViewModel.onCreate();
    }
}
