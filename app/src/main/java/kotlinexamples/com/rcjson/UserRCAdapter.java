package kotlinexamples.com.rcjson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserRCAdapter extends RecyclerView.Adapter<UserRCViewHolder> {

    Context context;
    LayoutInflater layoutInflater;
    MainActivity mainActivity;
    public static final String TAG = "message";
    private List<UserDetails> userList = new ArrayList<>();


    public UserRCAdapter(MainActivity mainActivity,List<UserDetails> userList){
        this.userList = userList;
        this.mainActivity = mainActivity;
       // layoutInflater.from(mainActivity);

    }

    @Override
    public UserRCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.posts,parent,false);
        UserRCViewHolder userRCViewHolder = new UserRCViewHolder(view);

        Log.d(TAG,"userRCViewHolder");

        return userRCViewHolder;
    }

    @Override
    public void onBindViewHolder(UserRCViewHolder holder, int position) {

        holder.userId.setText(String.valueOf(userList.get(position).getUserId()));
        holder.id.setText(String.valueOf(userList.get(position).getID()));
        holder.title.setText(userList.get(position).getTitle());
        holder.body.setText(userList.get(position).getBody());


    }


    @Override
    public int getItemCount() {

        return userList.size();
    }
}
