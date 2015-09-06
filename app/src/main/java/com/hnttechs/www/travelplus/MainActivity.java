package com.hnttechs.www.travelplus;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Fragment {
    public MainActivity(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main, container, false);

        ImageView btn_hotel = (ImageView) rootView.findViewById(R.id.btn_hotel);
        btn_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),HotelDirectoryActivity.class);
                startActivity(i);
            }
        });

        final FloatingActionButton btn_from_to = (FloatingActionButton) rootView.findViewById(R.id.btn_from_to);
        btn_from_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),FromToSearchActivity.class);
                startActivity(i);
            }
        });

        final FloatingActionButton btn_transportation = (FloatingActionButton) rootView.findViewById(R.id.btn_transportation);
        btn_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),PackageSearchActivity.class);
                startActivity(i);
            }
        });

        return rootView;
    }
}
