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

import altong.mon.amtalk.adapter.ChatListAdapter;
import altong.mon.amtalk.databinding.FragmentChatlistBinding;
import altong.mon.amtalk.item.Profile;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class ChatListFragment extends Fragment {

    FragmentChatlistBinding binding;
    Vector<Profile> profiles;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_chatlist, container, false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.myChatListView.setLayoutManager(manager);
        profiles = new Vector<>();
        profiles.add(new Profile(R.drawable.nguiruk,"괴력몬","안녕, 반가워.","오전 11:11"));
        profiles.add(new Profile(R.drawable.ngenyuk,"근육몬","안녕하세요.","오후 1:15"));
        binding.myChatListView.setAdapter(new ChatListAdapter(profiles, getContext(), getActivity()));
        View view = binding.getRoot();
        //here data must be an instance of the class MarsDataProvider
        return view;
    }
}
