package com.hnttechs.www.travelplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

/**
 * Created by dell on 8/23/15.
 */
public class HotelDirectoryActivity extends ActionBarActivity {

    private Toolbar toolbar;
    Spinner cbo_hotel_name,cbo_rate,cbo_fees;
    private String[] hotel_name = { "Hotel Max","Sedona","Traders","Park Royal" };
    private String[] rate = { "5 Stars","4 Stars","3 Stars","2 Stars", "1 Stars" };
    private String[] fees = { "100,000 Ks","80,000 Ks","50,000 Ks","30,000 Ks" };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_directory);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        cbo_hotel_name = (Spinner) findViewById(R.id.cbo_hotel_name);
        ArrayAdapter<String> adapter_hotel_name = new ArrayAdapter<String>(this,R.layout.spinner_item, hotel_name);
        adapter_hotel_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cbo_hotel_name.setAdapter(adapter_hotel_name);
        cbo_hotel_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_hotel_name.setSelection(position);
                String sel_from_city = (String) cbo_hotel_name.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        cbo_rate = (Spinner) findViewById(R.id.cbo_rate);
        ArrayAdapter<String> adapter_rate = new ArrayAdapter<String>(this,R.layout.spinner_item, rate);
        adapter_rate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        cbo_rate.setAdapter(adapter_rate);
        cbo_rate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_rate.setSelection(position);
                String sel_from_city = (String) cbo_rate.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbo_fees = (Spinner) findViewById(R.id.cbo_fees);
        ArrayAdapter<String> adapter_fees = new ArrayAdapter<String>(this,R.layout.spinner_item, fees);
        adapter_fees.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        cbo_fees.setAdapter(adapter_fees);
        cbo_fees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_fees.setSelection(position);
                String sel_from_city = (String) cbo_fees.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        LinearLayout lin_hotel_detail = (LinearLayout)findViewById(R.id.lin_hotel_detail);
        lin_hotel_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ViewPagerMain.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle("ဟိုတယ္မ်ား");
    }
}
