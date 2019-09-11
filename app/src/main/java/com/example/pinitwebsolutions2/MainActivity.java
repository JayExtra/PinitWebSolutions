package com.example.pinitwebsolutions2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout dotsLayout;
    private SlideAdapter sliderAdapter;
    private TextView[] nDots;
    private Button nextButton,prevButton,finishButton;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dotsLayout = findViewById(R.id.dots_layout);
        viewPager = findViewById(R.id.view_pager);
        nextButton= findViewById(R.id.next);
        prevButton= findViewById(R.id.previous);
        finishButton=findViewById(R.id.finish_btn);

        sliderAdapter = new SlideAdapter(this);

        viewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        viewPager.addOnPageChangeListener(viewListener);
        nextButton.setText("Swipe ->");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    public void addDotsIndicator(int position) {
        nDots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < nDots.length; i++) {
            nDots[i] = new TextView(this);
            nDots[i].setText(Html.fromHtml("&#8226;"));
            nDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            nDots[i].setTextSize(35);

            dotsLayout.addView(nDots[i]);

        }
        if (nDots.length > 0) {
            nDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            mCurrentPage=i;

            if(i==0){
                nextButton.setEnabled(true);
                prevButton.setEnabled(false);
                finishButton.setEnabled(false);
                prevButton.setVisibility(View.INVISIBLE);
                finishButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.VISIBLE);

                nextButton.setText("Swipe ->");
                prevButton.setText("");

            }else if(i==nDots.length-1){

                nextButton.setEnabled(false);
                prevButton.setEnabled(true);
                finishButton.setEnabled(true);

                prevButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                finishButton.setVisibility(View.VISIBLE);

               // nextButton.setText("Finish");
                prevButton.setText("<- Previous");

                //set on click listener to finish button here
                finishButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent= new Intent(MainActivity.this, HomeActivity.class);
                        MainActivity.this.startActivity(intent);
                    }
                });


            }else{

                nextButton.setEnabled(true);
                prevButton.setEnabled(true);
                finishButton.setEnabled(false);

                prevButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
                finishButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Swipe ->");
                prevButton.setText("<- Previous");
            }


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
