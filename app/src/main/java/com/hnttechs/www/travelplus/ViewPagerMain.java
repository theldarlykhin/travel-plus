package com.hnttechs.www.travelplus;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by dell on 9/2/15.
 */
public class ViewPagerMain extends ActionBarActivity {

    // Declare Variables
    ViewPager viewPager;
    PagerAdapter adapter;
    String[] name;
    String[] address;
    String[] phone;
    int[] logo;
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from viewpager_main.xml
        setContentView(R.layout.viewpager_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // Generate sample data
        name = new String[] { "Hotel Max", "HotelMax2", "HotelMax3", "HotelMax4", "HotelMax5", "HotelMax6", "HotelMax7", "HotelMax8", "HotelMax9", "HotelMax10" };

        address = new String[] { "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.",
                "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.",
                "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.",
                "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar.", "Chaungtha beach, Pathein Township, Ayeyarwady Division, Myanmar." };

        phone = new String[] { "097483462", "097483462",
                "097483462", "097483462", "097483462", "097483462",
                "097483462", "097483462", "097483462", "097483462" };

        logo = new int[] { R.drawable.hotelmax, R.drawable.hotelmax,
                R.drawable.hotelmax, R.drawable.hotelmax,
                R.drawable.hotelmax, R.drawable.hotelmax, R.drawable.hotelmax,
                R.drawable.hotelmax, R.drawable.hotelmax, R.drawable.hotelmax };

        // Locate the ViewPager in viewpager_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Pass results to ViewPagerAdapter Class
        adapter = new ViewPagerAdapter(ViewPagerMain.this, name, address, phone, logo);
        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }
}
