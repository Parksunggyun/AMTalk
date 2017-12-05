package altong.mon.amtalk.adapter;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Vector;

import altong.mon.amtalk.item.Chat;
import altong.mon.amtalk.databinding.ItemChatBinding;

/*
 * Created by 15U560 on 2017-12-05.
 */

public class ChatAdapter extends RecyclerView.Adapter {

    private Vector<Chat> chats;
    private Context context;

    ChatAdapter(Vector<Chat> chats, Context context) {
        this.chats = chats;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        ItemChatBinding binding = ItemChatBinding.inflate(LayoutInflater.from(context), parent, false);
        holder = new ChatHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatHolder itemViewHolder = (ChatHolder) holder;
        final ItemChatBinding binding = itemViewHolder.binding;

        int who = chats.get(position).getWho();
        String msg = chats.get(position).getChat();
        switch (who) {
            case 0:
                binding.friendChatLayout.setVisibility(View.GONE);
                binding.myChatLayout.setVisibility(View.VISIBLE);
                binding.myMsgTxtView.setText(msg);
                break;
            case 1:
                binding.myChatLayout.setVisibility(View.GONE);
                binding.friendChatLayout.setVisibility(View.VISIBLE);
                binding.friendMsgTxtView.setText(msg);

                binding.friendImgView.setImageResource(chats.get(position).getProfile());
                binding.friendImgView.setBackground(new ShapeDrawable(new OvalShape()));
                if(Build.VERSION.SDK_INT >= 21) {
                    binding.friendImgView.setClipToOutline(true);
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }


    private class ChatHolder extends RecyclerView.ViewHolder {
        ItemChatBinding binding;

        ChatHolder(ItemChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
