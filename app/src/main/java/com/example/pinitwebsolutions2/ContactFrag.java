package com.example.pinitwebsolutions2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class ContactFrag extends Fragment {

    private EditText nameField,subjectField,messageField;
    private Button sendButton,callButton;
    private String pinEmail,name,subject,message,number;
    private static final int REQUEST_CALL =1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.contact_frag,container,false);

        nameField=view.findViewById(R.id.name_field);
        subjectField=view.findViewById(R.id.subject_input);
        messageField=view.findViewById(R.id.message_input);
        sendButton=view.findViewById(R.id.button_send);
        callButton=view.findViewById(R.id.button_call);

        pinEmail="david@pinitonlinesolutions.com";
        number="+254754417450";



        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //get user name
                name = nameField.getText().toString();
                subject = subjectField.getText().toString();
                message = messageField.getText().toString();


                //check if fields are empty
                if (name.isEmpty()) {

                    nameField.setError("Field can't be empty");

                } else if(subject.isEmpty()){

                    subjectField.setError("Field can't be empty");


                }else if(message.isEmpty()){
                    messageField.setError("Field can't be empty");

                }else {

                    Toast.makeText(getContext(), "Redirecting to Gmail..Sending your message", Toast.LENGTH_LONG).show();

                    String[] recepients = pinEmail.split(",");


                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, recepients);
                    intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    intent.putExtra(Intent.EXTRA_TEXT, name + "\n" + "\n" + message);


                    intent.setType("message/rfc822");
                    startActivity(Intent.createChooser(intent, "Choose an email client"));

                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Calling...",Toast.LENGTH_LONG).show();

                makeCall();

            }
        });


        return view;
    }


    public void makeCall(){

        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

        }else{
            String dial= "tel:" + number;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
      if(requestCode == REQUEST_CALL){
          if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
              makeCall();
          }else{
              Toast.makeText(getContext(),"Permission DENIED",Toast.LENGTH_SHORT).show();
          }
      }
    }
}
