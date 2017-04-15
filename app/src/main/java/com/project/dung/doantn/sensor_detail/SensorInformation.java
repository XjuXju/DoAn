package com.project.dung.doantn.sensor_detail;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.project.dung.doantn.R;

public class SensorInformation extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_information);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });*/
        getSupportActionBar().setDisplayShowTitleEnabled(false);     //dont display title

        addFragments();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return  true;
    }

    public void addFragments(){

        InforChartFragment inforChartFragment = new InforChartFragment();
        SensorInforFragment sensorInforFragment = new SensorInforFragment();
        final FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, inforChartFragment, "mychart");
        fragmentTransaction.add(R.id.container2, sensorInforFragment, "myInfor");
        fragmentTransaction.commit();
//        fragmentTransaction.replace(R.id.view_container, inforChartFragment);
//        fragmentTransaction.commit();
//        fragmentTransaction.replace(R.id.view_container, sensorInforFragment);
//        fragmentTransaction.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnNotification:

                Toast.makeText(this, "notification", Toast.LENGTH_SHORT).show();
                //
                break;
            case R.id.mnSetting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
