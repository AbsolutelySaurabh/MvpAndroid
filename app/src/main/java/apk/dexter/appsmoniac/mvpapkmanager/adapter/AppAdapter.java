package apk.dexter.appsmoniac.mvpapkmanager.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import apk.dexter.appsmoniac.mvpapkmanager.R;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {
    private Context context;
    private List<ApplicationInfo> list = new ArrayList<>();

    public AppAdapter(Context context, List<ApplicationInfo> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public AppAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(AppAdapter.MyViewHolder holder, int position) {
        holder.app_name.setText(list.get(position).packageName);
        //holder.app_image.setImageDrawable(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView app_name;
        ImageView app_image;
        public MyViewHolder(View itemView) {
            super(itemView);
            app_name = (TextView)itemView.findViewById(R.id.app_name);
            app_image = (ImageView)itemView.findViewById(R.id.app_image);

        }
    }
}
