package com.example.pinitwebsolutions2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SlideAdapter(Context context){
        this.context=context;
    }
    //Arrays
    public int [] slide_images={
            R.drawable.code,
            R.drawable.boost_img,
            R.drawable.branding2

    };
    public String[] slide_headings={
            "WEB DEVELOPMENT",
            "BOOST YOUR WEBSITE",
            "EXPAND YOUR BRAND"

    };

    public String[] slide_description={
            "Stand out from the crowd with excellent websites developed using tried-and-true design elements",
            "We utilize top web designs and UX trends that will ensure your website is at top notch performance and has a world wide reach",
            "We create unique eye-catching logos and ad campaigns that will grow your brand and business fast "


    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView= view.findViewById(R.id.slide_img);
        TextView slideDescription= view.findViewById(R.id.slide_desc);
        TextView slideHeading= view.findViewById(R.id.slide_heading);

        slideImageView.setImageResource(slide_images[position]);
        slideDescription.setText(slide_description[position]);
        slideHeading.setText(slide_headings[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object){
        container.removeView((RelativeLayout)object);

    }


}
