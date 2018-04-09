package altong.mon.amtalk.item;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class Profile {

    private int url;
    private String nickname;
    private String msg;
    private String time;
    private String strUrl;


    public Profile(String strUrl, int url, String nickname, String msg) {
        this.url = url;
        this.nickname = nickname;
        this.msg = msg;
        this.strUrl = strUrl;
    }

    public Profile(int url, String nickname, String msg, String time) {
        this.url = url;
        this.nickname = nickname;
        this.msg = msg;
        this.time = time;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public int getUrl() {
        return url;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }
}
