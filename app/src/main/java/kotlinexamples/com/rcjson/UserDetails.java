package kotlinexamples.com.rcjson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserDetails {


    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int ID;

    @SerializedName("title")
    private  String title;

    @SerializedName("body")
    private String body;

    public int getUserId() {
        return userId;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
