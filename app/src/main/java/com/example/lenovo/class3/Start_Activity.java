package com.example.lenovo.class3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Start_Activity extends AppCompatActivity  {
EditText editText;
TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        setTitle("XYZ");
        Button startButton=(Button)findViewById(R.id.startButton);
        editText=(EditText)findViewById(R.id.nameEditText);
        nameTextView=(TextView)findViewById(R.id.textView);

        final SharedPreferences sharedPreferences=getSharedPreferences("tic_tac_toe ",MODE_PRIVATE);// tic_tac_toe is file name and MODE_PRIVATE is mode of reading MODE_PRIVATE is now compulsory mode in newer API versions
        //if it is not final then we cannot use in onclick fuction it we donot want it to be final make it global(class variable)
        String name=sharedPreferences.getString("userName ",null); //for retrieving vaule from file (null is given if that key-value pair doesnot exists
        if(name==null){
            nameTextView.setText("welcome user ");
        }else{
            nameTextView.setText("welcome "+name);
        }

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                if(name.isEmpty()){
                    Toast.makeText(Start_Activity.this,"Enter name !!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //for putting entry in sharedPreferences
                SharedPreferences.Editor editor=sharedPreferences.edit(); //edit func. returns editor type object
                editor.putString("userName ",name);
                editor.commit(); //to commit or saved changes in file

                //to delete data from sharedpreferences
            //    editor.remove("userName"); //userName is key of the value to be deleted

                Intent i=new Intent(Start_Activity.this,MainActivity.class); //Intent is used to communicate between differt activity
                i.putExtra("user_name",name);// putExtra put extracontents to be passed along with intent in intent-bundle bundle is similar to hashmap
                 //we can either pass value in intent bundle or can make our bundle and can pass it to another class
                startActivity(i);
              //here username is key and name is value
            }
        });
    }


//    @Override
//    public void onClick(View v) {
//        Intent i=new Intent(this,MainActivity.class); //Intent is used to communicate between differt activity
//        Start_Activity(i);
//    }
}
