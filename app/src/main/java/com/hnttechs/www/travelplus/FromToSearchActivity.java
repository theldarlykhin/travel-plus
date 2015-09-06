package com.hnttechs.www.travelplus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by dell on 8/19/15.
 */
public class FromToSearchActivity extends AppCompatActivity {

    Spinner cbo_from,cbo_to,cbo_by;
    private String[] transportation = { "Car","AirLine","Voyage","Train" };
    private String[] city = { "Yangon","Taunggyi","Mandalay","Aung Ban","TarChiLake" };
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.from_to_search);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        cbo_from = (Spinner) findViewById(R.id.cbo_from);
        cbo_to= (Spinner) findViewById(R.id.cbo_to);
        cbo_by = (Spinner) findViewById(R.id.cbo_by);

        ArrayAdapter<String> adapter_transportation = new ArrayAdapter<String>(this,R.layout.spinner_item, transportation);
        adapter_transportation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_city = new ArrayAdapter<String>(this,R.layout.spinner_item, city);
        adapter_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cbo_from.setAdapter(adapter_city);
        cbo_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_from.setSelection(position);
                String sel_from_city = (String) cbo_from.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbo_to.setAdapter(adapter_city);
        cbo_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                cbo_to.setSelection(position);
                String sel_to_City = (String) cbo_to.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        cbo_by.setAdapter(adapter_transportation);
        cbo_by.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_by.setSelection(position);
                String sel_by_transportation = (String) cbo_by.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle("From To Search");
    }

}
