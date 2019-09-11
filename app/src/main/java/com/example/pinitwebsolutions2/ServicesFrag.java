package com.example.pinitwebsolutions2;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ServicesFrag extends Fragment {
    private Button buttonAnalysis,buttonWeb,buttonContent,buttonSocial,buttonMarketing,buttonBranding;
    Dialog myDialog;
    TextView txtDesc;
    ImageView popImg;
    Button buttonClose;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.services_frag,container,false);

        myDialog=new Dialog(getContext());

        buttonAnalysis=view.findViewById(R.id.button_analystics);
        buttonWeb=view.findViewById(R.id.button_webdev);
        buttonContent=view.findViewById(R.id.button_content);
        buttonSocial=view.findViewById(R.id.button_social);
        buttonMarketing=view.findViewById(R.id.button_mrkt);
        buttonBranding=view.findViewById(R.id.button_branding);


        buttonAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup1();
            }
        });
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup2();
            }
        });

        buttonContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup3();
            }
        });

        buttonSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup4();
            }
        });
        buttonMarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup5();
            }
        });
        buttonBranding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup6();
            }
        });




        return  view;
    }

    public void showPopup1(){
        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }
    public void showPopup2(){

        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);
        txtDesc=(TextView) myDialog.findViewById(R.id.details);

        popImg.setImageResource(R.drawable.webdev2);
        txtDesc.setText("We use the latest technology design simple and easy to use websites considering the latest trends online.");


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void showPopup3(){
        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);
        txtDesc=(TextView) myDialog.findViewById(R.id.details);

        popImg.setImageResource(R.drawable.crt3);
        txtDesc.setText("We can write new pages for your website to accommodate a wider audience while boosting authority and maintaining brand voice.");


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }
    public void showPopup4(){
        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);
        txtDesc=(TextView) myDialog.findViewById(R.id.details);

        popImg.setImageResource(R.drawable.social_mrkt);
        txtDesc.setText("Grow your brand’s popularity on social media networks through our robust social media marketing strategy.");


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }
    public void showPopup5(){

        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);
        txtDesc=(TextView) myDialog.findViewById(R.id.details);


        popImg.setImageResource(R.drawable.content_mrkt);
        txtDesc.setText("Leverage content marketing to reach your audience and promote your brand as well as your unique voice and message.");



        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }
    public void showPopup6(){

        myDialog.setContentView(R.layout.popup);
        buttonClose=(Button) myDialog.findViewById(R.id.close_btn);
        popImg=(ImageView) myDialog.findViewById(R.id.pop_img);
        txtDesc=(TextView) myDialog.findViewById(R.id.details);


        popImg.setImageResource(R.drawable.branding_img);
        txtDesc.setText("We utilize the top social networks to communicate with potential customers and industry influences while promoting your brand using a unique voice.");


        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();


    }
}
