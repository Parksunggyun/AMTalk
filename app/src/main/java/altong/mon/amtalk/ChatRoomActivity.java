package altong.mon.amtalk;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.Vector;

import altong.mon.amtalk.adapter.ChatAdapter;
import altong.mon.amtalk.databinding.ActivityChatroomBinding;
import altong.mon.amtalk.item.Chat;

/*
 * Created by 15U560 on 2017-12-04.
 */

public class ChatRoomActivity extends AppCompatActivity {

    private static final String TAG = "ChatRoomActivity";
    ActivityChatroomBinding binding;
    private static final int CHATROOM = R.layout.activity_chatroom;

    private Vector<Chat> chats;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, CHATROOM);
        String fName = getIntent().getStringExtra("fName");
        int img = getIntent().getIntExtra("fImg", 0);
        chats = new Vector<>();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.chatRoomListView.setLayoutManager(manager);
        binding.chatRoomFriendNameTxtView.setText(fName);
        switch (fName) {
            case "근육몬":
                chats.add(new Chat("근육몬", "안녕",0, 0));
                chats.add(new Chat("근육몬", "안녕~",1, R.drawable.ngenyuk));
                chats.add(new Chat("근육몬", "반가워 나는 알통몬이야.",0, 0));
                chats.add(new Chat("근육몬", "나도 반가워 난 근육몬이야 ㅎㅎ",1,R.drawable.ngenyuk));
                chats.add(new Chat("근육몬", "안드로이드 알아?",0,0));
                chats.add(new Chat("근육몬", "알긴 아는데 잘 몰라 ㅎ",1,R.drawable.ngenyuk));
                chats.add(new Chat("근육몬", "애국가는?",0,0));
                chats.add(new Chat("근육몬", "1절만 알아",1,R.drawable.ngenyuk));
                chats.add(new Chat("근육몬", "알려줘",0,0));
                chats.add(new Chat("근육몬", "동해물과 백두산이 마르고 닳도록 하나님이 보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세",1,R.drawable.ngenyuk));
                break;
            case "괴력몬":
                chats.add(new Chat("괴력몬", "안녕하세요",0 ,0));
                chats.add(new Chat("괴력몬", "안녕하세요~",1,R.drawable.nguiruk));
                chats.add(new Chat("괴력몬", "반가워여 저는 알통몬입니다.",0,0));
                chats.add(new Chat("괴력몬", "반가워요 저는 괴력몬이에요~~",1,R.drawable.nguiruk));
                chats.add(new Chat("괴력몬", "안드로이드 아세요?",0,0));
                chats.add(new Chat("괴력몬", "알긴 아는데 잘 몰라요^^",1,R.drawable.nguiruk));
                chats.add(new Chat("괴력몬", "애국가는요??",0,0));
                chats.add(new Chat("괴력몬", "1절만 알아여",1,R.drawable.nguiruk));
                chats.add(new Chat("괴력몬", "알려줘요",0,0));
                chats.add(new Chat("괴력몬", "동해물과 백두산이 마르고 닳도록 하나님이 보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세",1,R.drawable.nguiruk));
                break;
        }
        adapter = new ChatAdapter(chats, this);
        binding.chatRoomListView.setAdapter(adapter);
        binding.backChatRoomListImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.sendMsgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = binding.msgEditText.getText().toString();
                chats.add(new Chat(chats.get(0).getFriend(), msg, 0, 0));
                adapter.notifyDataSetChanged();
                binding.chatRoomListView.scrollToPosition(chats.size()-1);
                binding.msgEditText.setText(null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChatRoomActivity.this, MainActivity.class);
        intent.putExtra("position", 1);
        startActivity(intent);
        finish();
    }
}
