package com.hnttechs.www.travelplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by dell on 8/23/15.
 */
public class PackageSearchActivity extends ActionBarActivity {

    Spinner cbo_package_name;
    private String[] package_name = { "Holiday Package","Spring Time Package","Summer Package","Discount Package" };
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.package_search);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        cbo_package_name = (Spinner) findViewById(R.id.cbo_package);
        ArrayAdapter<String> adapter_package_name = new ArrayAdapter<String>(this,R.layout.spinner_item, package_name);
        adapter_package_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cbo_package_name.setAdapter(adapter_package_name);
        cbo_package_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cbo_package_name.setSelection(position);
                String sel_from_city = (String) cbo_package_name.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        getSupportActionBar().setTitle("ခရီးစဥ္မ်ား");
    }
}
