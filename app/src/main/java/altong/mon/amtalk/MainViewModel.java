package altong.mon.amtalk;

/*
 * Created by 15U560 on 2017-11-29.
 */

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

public class MainViewModel implements ViewModel {

    private FloatingActionButton fab;
    private TabLayout tab;
    private ViewPager pager;
    private MainFragmentAdapter adapter;

    MainViewModel(FloatingActionButton fab, TabLayout tab, ViewPager pager, MainFragmentAdapter adapter) {
        this.fab = fab;
        this.tab = tab;
        this.pager = pager;
        this.adapter = adapter;
    }

    @Override
    public void onCreate() {
        bindingViewPager();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }
    private void bindingViewPager() {
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_people_black_24dp),0,true);
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_chat_bubble_black_24dp),1);
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_more_horiz_black_24dp),2);
        tab.addOnTabSelectedListener(pagerListener);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));
    }
    private TabLayout.OnTabSelectedListener pagerListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            pager.setCurrentItem(tab.getPosition());
            switch (tab.getPosition()) {
                case 0:
                    fab.setImageResource(R.drawable.ic_person_add_black_24dp);
                    fab.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    fab.setImageResource(R.drawable.ic_message_black_24dp);
                    fab.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    fab.setVisibility(View.GONE);
                    break;
            }
        }
        @Override public void onTabUnselected(TabLayout.Tab tab) {}
        @Override public void onTabReselected(TabLayout.Tab tab) {}
    };
}
