package kotlinexamples.com.rcjson;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by subbaraoy on 4/4/18.
 */

public class UserRCViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "message";


    TextView userId,id,title,body;

    public UserRCViewHolder(View itemView) {
        super(itemView);
        Log.d(TAG,"UserRCViewHolder");

        userId    = itemView.findViewById(R.id.userId);
        id     = itemView.findViewById(R.id.ID);
        title   = itemView.findViewById(R.id.title);
        body   = itemView.findViewById(R.id.body);





    }
}
