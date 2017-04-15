package com.project.dung.doantn.view;


import android.content.Context;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import com.project.dung.doantn.R;
import com.project.dung.doantn.model.SensorModel;

import java.util.ArrayList;


public class SensorFragment extends Fragment {
   RecyclerView recyclerView;
    ArrayList<SensorModel> sensorModels = new ArrayList<>();
    RecyclerDataAdapter dataAdapter ;
    Context thisContext;

    public SensorFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        thisContext = container.getContext();
        View view =inflater.inflate(R.layout.sensor_activity, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycleView);
     //   SensorModel md=new SensorModel("sensor nhiet1", "anh sensor");
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 1"));
        sensorModels.add(new SensorModel("pic", "sensor nhiet 2"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 3"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 4"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 1"));
        sensorModels.add(new SensorModel("pic", "sensor nhiet 2"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 3"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 4"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 1"));
        sensorModels.add(new SensorModel("pic", "sensor nhiet 2"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 3"));
        sensorModels.add(new SensorModel("pic ", "sensor nhiet 4"));

        dataAdapter = new RecyclerDataAdapter(thisContext, sensorModels);
        recyclerView.setAdapter(dataAdapter);
        //recyclerView.setAdapter(new ContentAdapter();
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(thisContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        return  view;



    }


}


