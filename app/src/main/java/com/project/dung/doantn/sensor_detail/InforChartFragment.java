package com.project.dung.doantn.sensor_detail;


import android.app.Fragment;
import android.graphics.Color;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.mikephil.charting.charts.LineChart;

import com.project.dung.doantn.R;

public class InforChartFragment extends Fragment {
    RelativeLayout mainLayout;
    LineChart mChart;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_activity, container, false);
        mainLayout = (RelativeLayout) view.findViewById(R.id.chartView);
        //create chart and add into layout


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
