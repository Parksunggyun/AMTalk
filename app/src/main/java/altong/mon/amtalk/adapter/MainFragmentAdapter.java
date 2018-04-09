package altong.mon.amtalk.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import altong.mon.amtalk.ChatListFragment;
import altong.mon.amtalk.FriendListFragment;
import altong.mon.amtalk.SetupFragment;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private static final int PAGE_COUNT = 3;

    private String[] myProfiles;

    public MainFragmentAdapter(FragmentManager fm, String[] myProfiles) {
        super(fm);
        this.myProfiles = myProfiles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FriendListFragment();
                Bundle args = new Bundle();
                args.putString("email",myProfiles[0]);
                args.putString("nickname",myProfiles[1]);
                args.putString("profile_url",myProfiles[2]);
                fragment.setArguments(args);
                break;
            case 1:
                fragment = new ChatListFragment();
                break;
            case 2:
                fragment =  new SetupFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
