package com.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.myapplication.Model.ImageLiveData;
import com.myapplication.Model.UrlData;
import com.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageLiveDataAdapter extends RecyclerView.Adapter<ImageLiveDataAdapter.MyViewHoler> {

    private final Context context;
    private final List<ImageLiveData> imageLiveData;

    public ImageLiveDataAdapter(Context context, List<ImageLiveData> imageLiveData) {
        this.context = context;
        this.imageLiveData = imageLiveData;
    }

    @NonNull
    @Override
    public ImageLiveDataAdapter.MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.raw_live_image, parent, false);

        return new MyViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageLiveDataAdapter.MyViewHoler holder, int position) {

        UrlData urlData = new UrlData();

        int lastPosition = imageLiveData.size();
        Picasso.get().load(urlData.image_url + imageLiveData.get(position).getPhoto()).into(holder.imageData);
        holder.textData.setText(imageLiveData.get(position).getName());
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        holder.itemView.startAnimation(animation);
        lastPosition = position;
    }

    @Override
    public int getItemCount() {
        return imageLiveData.size();
    }

    public static class MyViewHoler extends RecyclerView.ViewHolder {

        ImageView imageData;
        TextView textData;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);

            imageData = itemView.findViewById(R.id.image_live);
            textData = itemView.findViewById(R.id.tv_live_data);
        }
    }
}
