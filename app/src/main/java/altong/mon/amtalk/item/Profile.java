package altong.mon.amtalk.item;

/*
 * Created by 15U560 on 2017-11-29.
 */

public class Profile {

    private int url;
    private String name;
    private String msg;
    private String time;


    public Profile(int url, String name, String msg) {
        this.url = url;
        this.name = name;
        this.msg = msg;
    }

    public Profile(int url, String name, String msg, String time) {
        this.url = url;
        this.name = name;
        this.msg = msg;
        this.time = time;
    }

    public int getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }
}
