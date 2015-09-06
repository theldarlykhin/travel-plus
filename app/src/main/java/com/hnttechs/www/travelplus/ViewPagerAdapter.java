package com.hnttechs.www.travelplus;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dell on 9/2/15.
 */
public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] name;
    String[] address;
    String[] phone;
    int[] logo;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] name, String[] address,
                            String[] phone, int[] logo) {
        this.context = context;
        this.name= name;
        this.address= address;
        this.phone= phone;
        this.logo= logo;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtname;
        TextView txtaddress;
        TextView txtphone;
        ImageView imglogo;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.hotel_detail, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtname= (TextView) itemView.findViewById(R.id.name);
        txtaddress = (TextView) itemView.findViewById(R.id.address);
        txtphone = (TextView) itemView.findViewById(R.id.phone);

        // Capture position and set to the TextViews
        txtname.setText(name[position]);
        txtaddress.setText(address[position]);
        txtphone.setText(phone[position]);

        // Locate the ImageView in viewpager_item.xml
        imglogo = (ImageView) itemView.findViewById(R.id.logo);
        // Capture position and set to the ImageView
        imglogo.setImageResource(logo[position]);

        // Add viewpager_item.xml to ViewPager
        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
