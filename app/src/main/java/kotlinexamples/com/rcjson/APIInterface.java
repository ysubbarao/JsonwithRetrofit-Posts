package kotlinexamples.com.rcjson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by subbaraoy on 4/5/18.
 */

public interface APIInterface {

    //@POST("comments?postId=1")
    @GET("/comments?postId=1")
    Call<ArrayList<UserDetails>> getUserDetails();
}
