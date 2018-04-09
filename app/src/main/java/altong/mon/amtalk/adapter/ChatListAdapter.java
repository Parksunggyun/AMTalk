package altong.mon.amtalk.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import altong.mon.amtalk.ChatRoomActivity;
import altong.mon.amtalk.item.Profile;
import altong.mon.amtalk.databinding.ItemChatlistBinding;

/*
 * Created by 15U560 on 2017-12-04.
 */

public class ChatListAdapter extends RecyclerView.Adapter {

    private Vector<Profile> profiles;
    private Context context;
    private Activity activity;

    public ChatListAdapter(Vector<Profile> profiles, Context context, Activity activity) {
        this.profiles = profiles;
        this.context = context;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        ItemChatlistBinding binding  = ItemChatlistBinding.inflate(LayoutInflater.from(context), parent, false);
        holder = new ChatViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatViewHolder itemViewHolder = (ChatViewHolder) holder;
        final ItemChatlistBinding binding = itemViewHolder.binding;
        final int pos = position;
        binding.friendProfileImgView.setImageResource(profiles.get(pos).getUrl());
        binding.friendNameTxtView.setText(profiles.get(pos).getNickname());
        binding.friendLastMsgTxtView.setText(profiles.get(pos).getMsg());
        binding.friendLastMsgTimeTxtView.setText(profiles.get(pos).getTime());
        binding.chatLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ChatRoomActivity.class);
                intent.putExtra("fName", profiles.get(pos).getNickname());
                intent.putExtra("fImg", profiles.get(pos).getUrl());
                activity.startActivity(intent);
                activity.finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    private class ChatViewHolder extends RecyclerView.ViewHolder {

        ItemChatlistBinding binding;

        ChatViewHolder(ItemChatlistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
