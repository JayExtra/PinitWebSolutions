package com.example.pinitwebsolutions2;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.pinitwebsolutions2.ui.main.PlaceholderFragment;

import java.util.List;

public class FragmentHome extends Fragment {
    private ImageView imgFacebook, imgTwitter, imgInstagram, imgLinkedin;
    private ViewFlipper viewFlipper;
    private Button buttonBook;
    ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewFlipper = view.findViewById(R.id.v_flipper);
        imgFacebook = view.findViewById(R.id.icon_facebook);
        imgTwitter = view.findViewById(R.id.icon_twitter);
        imgInstagram = view.findViewById(R.id.icon_instagram);
        imgLinkedin = view.findViewById(R.id.icon_linkedin);
        buttonBook=view.findViewById(R.id.button_book);

        int images[] = new int[]{R.drawable.client_1, R.drawable.client_2, R.drawable.client_3, R.drawable.client_4,
                R.drawable.client_7, R.drawable.client_6};


        //for loop for images within the view flipper
        for (int image : images) {
            flipperImages(image);

        }

        //book services button
        buttonBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((HomeActivity)getActivity()).tabSelect(4);


            }
        });

        //social media icons
        imgFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent facebookIntent = openFacebook(getActivity());
                startActivity(facebookIntent);

                Toast.makeText(getActivity(), "Starting facebook..", Toast.LENGTH_SHORT).show();


            }
        });
        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twitterIntent = openTwitter(getActivity());
                startActivity(twitterIntent);
                Toast.makeText(getActivity(), "Starting twitter..", Toast.LENGTH_SHORT).show();

            }
        });
        imgInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instagramIntent = openInstagram(getActivity());
                startActivity(instagramIntent);
                Toast.makeText(getActivity(), "Starting instagram..", Toast.LENGTH_SHORT).show();


            }
        });

        imgLinkedin.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View view) {

             Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/[740025658]"));
             final PackageManager packageManager = getContext().getPackageManager();
             final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
             if (list.isEmpty()) {
                 intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=740025658"));
             }
             startActivity(intent);

         }
        });

        return view;
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        //loads image into view flipper and controls time in between image transitions
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);


        //controls the style of animation between different images
        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    public static Intent openFacebook(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/999241103588149"));
        } catch (Exception e) {

            return new Intent(Intent.ACTION_VIEW, Uri.parse("https:www.facebook.com/pinitonlinesolutions"));
        }


    }

    public static Intent openTwitter(Context context) {

        try {
            // get the Twitter app if possible
            context.getPackageManager().getPackageInfo("com.twitter.android", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?user_id=1103971982859821056"));
        } catch (Exception e) {
            // no Twitter app, revert to browser
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/pinitonlinesolutions"));
        }

    }


    public Intent openInstagram(Context context) {

        Uri uri = Uri.parse("http://instagram.com/_u/pinitonline");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/pinitonline")));
        }

        return likeIng;
    }







}
