package com.project.dung.doantn.view;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.dung.doantn.MainActivity;
import com.project.dung.doantn.R;
import com.project.dung.doantn.model.SensorModel;
import com.project.dung.doantn.sensor_detail.SensorInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dung on 4/13/2017.
 */

public class RecyclerDataAdapter extends RecyclerView.Adapter<RecyclerDataAdapter.DataViewHolder> {
    private ArrayList<SensorModel> sensor;
    private Context context;
    private LayoutInflater inflater;
    private String post_key= null;

    public RecyclerDataAdapter(Context context, ArrayList<SensorModel> ss) {
        sensor = ss;
        this.context = context;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public RecyclerDataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = inflater.from(parent.getContext()).inflate(R.layout.item_sensor_activity, parent, false);

        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerDataAdapter.DataViewHolder holder, int position) {
        String img = sensor.get(position).getImgSensor();
        String name = sensor.get(position).getSensorName();
        holder.setPic(img);
        holder.setSensorName(name);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  post_key = getRef()
                Intent myIntent = new Intent(view.getContext(), SensorInformation.class);
                context.startActivity(myIntent);



            }
        });

    }

    @Override
    public int getItemCount() {
        return sensor == null ? 0 : sensor.size();
    }


    public static class DataViewHolder extends RecyclerView.ViewHolder {
        View view;

        public DataViewHolder(View itemView) {
            super(itemView);
            view = itemView;
          }
          public void setSensorName(String name){
              TextView tvName = (TextView) view.findViewById(R.id.sensorName);
              tvName.setText(name);
          }
          public void setPic(String pic){
              TextView tvPic = (TextView) view.findViewById(R.id.imgSensor);
              tvPic.setText(pic);
          }

       /* public void setImage(Context ctx, String imageUser) {
            ImageView postImage = (ImageView) mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(imageUser).into(postImage);

        }*/
    }
}


