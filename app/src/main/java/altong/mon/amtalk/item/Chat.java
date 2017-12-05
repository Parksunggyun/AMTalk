package altong.mon.amtalk.item;

/*
 * Created by 15U560 on 2017-12-05.
 */

public class Chat {

    private String friend;

    private String chat;

    private int who;

    private int profile;

    public Chat(String friend, String chat, int who, int profile) {
        this.friend = friend;
        this.chat = chat;
        this.who = who;
        this.profile = profile;
    }

    public int getProfile() {
        return profile;
    }

    public String getFriend() {
        return friend;
    }

    public String getChat() {
        return chat;
    }

    public int getWho() {
        return who;
    }
}
