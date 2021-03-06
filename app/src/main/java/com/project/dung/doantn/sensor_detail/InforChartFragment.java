package com.project.dung.doantn.sensor_detail;


import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.Nullable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.project.dung.doantn.R;
import com.project.dung.doantn.adatabase.DatabaseManager;

import java.util.ArrayList;

public class InforChartFragment extends Fragment {
    DatabaseManager databaseManager;

    private SimpleCursorAdapter adapter;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chart_activity, container, false);
        LineChart lineChart = (LineChart) view.findViewById(R.id.chart);
        //create db and insert data

        databaseManager = new DatabaseManager(view.getContext());
     /*   databaseManager.insertData("SS7", (float) 4.0, "00:37:11" , "20-1-2017");
        databaseManager.insertData("SS8", (float) 10, "00:39:11" , "20-2-2017");
        databaseManager.insertData("SS9", (float) 12, "00:40:11" , "20-3-2017");
        databaseManager.insertData("SS10", (float) 14, "00:45:11" , "20-4-2017");
        databaseManager.insertData("SS11", (float) 17, "00:50:11" , "20-5-2017");
        databaseManager.insertData("SS12",(float) 19, "00:55:11" , "20-6-2017");
*/
//doc data from db




        ArrayList<Entry> entries = new ArrayList<>();
        float fl;
        for (int i=0; i< databaseManager.countData();i++){
            fl=databaseManager.getDataSensor()[i];
            entries.add(new Entry(fl, i));
            Toast.makeText(view.getContext(), "data"+databaseManager.getDataSensor()[i], Toast.LENGTH_SHORT).show();
        }
        /*entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));
        entries.add(new Entry(4f, 6));
        entries.add(new Entry(8f, 7));
        entries.add(new Entry(6f, 8));
        entries.add(new Entry(2f, 9));
        entries.add(new Entry(18f,10));
        entries.add(new Entry(9f, 11));*/


        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        for (int i=0; i<databaseManager.countData(); i++) {
            labels.add(databaseManager.getLable()[i]);
        }
       /* labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");

        labels.add("June");
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");*/

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
