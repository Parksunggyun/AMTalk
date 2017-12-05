package altong.mon.amtalk;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import altong.mon.amtalk.adapter.ProfileAdapter;
import altong.mon.amtalk.databinding.FragmentFriendlistBinding;
import altong.mon.amtalk.item.Profile;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class FriendListFragment extends Fragment {

    FragmentFriendlistBinding binding;
    Vector<Profile> profiles;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_friendlist, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.myListView.setLayoutManager(manager);
        profiles = new Vector<>();
        profiles.add(new Profile(0,"내 프로필",""));
        profiles.add(new Profile(R.drawable.naltong,"알통몬","촤하하"));
        profiles.add(new Profile(0,"친구목록",""));
        profiles.add(new Profile(R.drawable.ngenyuk,"근육몬","추후후"));
        profiles.add(new Profile(R.drawable.nguiruk,"괴력몬","췌헤헤"));
        binding.myListView.setAdapter(new ProfileAdapter(profiles, getContext()));
        View view = binding.getRoot();

        //here data must be an instance of the class MarsDataProvider
        return view;
    }
}
