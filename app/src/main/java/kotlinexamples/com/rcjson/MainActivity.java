package kotlinexamples.com.rcjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "message";
    Context context;


    RecyclerView recyclerView;
    UserRCAdapter userRCAdapter;
    RecyclerView.LayoutManager layoutManager;
    APIInterface apiInterface;
    private List<UserDetails> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        // make call async tasks




        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        userRCAdapter = new UserRCAdapter(MainActivity.this, userList);


       /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL );
       recyclerView.addItemDecoration(dividerItemDecoration);*/


        recyclerView.setAdapter(userRCAdapter);

        apiInterface = APIClient.getApiClient().create(APIInterface.class);


        Call<ArrayList<UserDetails>> call = apiInterface.getUserDetails();
       // Call<UserDetails> call = apiInterface.getUserDetails();
        call.enqueue(new Callback<ArrayList<UserDetails>>() {
            @Override
            public void onResponse(Call<ArrayList<UserDetails>> call, Response<ArrayList<UserDetails>> response) {
               // userList.addAll(response.body().bookstore);
                userList.addAll(response.body());
                Log.d(TAG, "userList values " + userList.toString());
                userRCAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<ArrayList<UserDetails>> call, Throwable t) {
                Log.d(TAG, "onfailure " + t.getLocalizedMessage());
            }
        });

    }

}
