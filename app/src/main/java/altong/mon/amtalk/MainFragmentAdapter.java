package altong.mon.amtalk;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private static final int PAGE_COUNT = 3;

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FriendListFragment();
            case 1:
                return new ChatListFragment();
            case 2:
                return new SetupFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
