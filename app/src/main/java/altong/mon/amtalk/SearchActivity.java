package altong.mon.amtalk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import altong.mon.amtalk.databinding.ActivitySearchBinding;

/*
 * Created by 15U560 on 2018-04-06.
 */

public class SearchActivity extends BaseActivity {

    private ActivitySearchBinding binding;
    private static final int SEARCH = R.layout.activity_search;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, SEARCH);
    }
}
