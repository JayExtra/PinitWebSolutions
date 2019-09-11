package com.example.pinitwebsolutions2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ClientsSlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public ClientsSlideAdapter(Context context){
        this.context=context;
    }

    //Arrays
    public int [] slide_images={
            R.drawable.client_1,
            R.drawable.client_2,
            R.drawable.client_3,
            R.drawable.client_4,
            R.drawable.client_7,
            R.drawable.client_6

    };

    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container,int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.clients,container,false);

        ImageView slideImageView= view.findViewById(R.id.clients_img);
        slideImageView.setImageResource(slide_images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object){
        container.removeView((RelativeLayout)object);

    }

}
