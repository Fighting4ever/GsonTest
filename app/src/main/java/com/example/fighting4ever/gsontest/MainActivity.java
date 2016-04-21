package com.example.fighting4ever.gsontest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.to_json)
    Button toJson;
    @Bind(R.id.from_json)
    Button fromJson;
    @Bind(R.id.list_json)
    Button listJson;
    @Bind(R.id.add_user)
    Button addUser;
    @Bind(R.id.tjson)
    Button tJson;
    @Bind(R.id.json_to_object)
    EditText jsonToObject;
    @Bind(R.id.user_name)
    EditText userName;
    @Bind(R.id.phone_number)
    EditText phoneNumber;
    @Bind(R.id.email)
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toJson.setOnClickListener(this);
        fromJson.setOnClickListener(this);
        listJson.setOnClickListener(this);
        addUser.setOnClickListener(this);
        tJson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.from_json:
                String string = jsonToObject.getText().toString();
                if (!string.isEmpty()){
                    Gson fromGson = new Gson();
                    User toUser = fromGson.fromJson(string, User.class);
                    userName.setText(toUser.getUsername());
                    phoneNumber.setText(toUser.getPhonenumber());
                    email.setText(toUser.getEmail());
                }
                break;
            case R.id.to_json:
                User toUser = new User();
                toUser.setUsername(userName.getText().toString());
                toUser.setPhonenumber(phoneNumber.getText().toString());
                toUser.setEmail(email.getText().toString());
                Gson gson = new Gson();
                String str = gson.toJson(toUser, User.class);
                jsonToObject.setText(str);
                break;
            case R.id.list_json:
                Intent intent = new Intent(MainActivity.this, ListJson.class);
                startActivity(intent);
                break;
            case R.id.add_user:
                User user = new User();
                user.setUsername(userName.getText().toString());
                user.setPhonenumber(phoneNumber.getText().toString());
                user.setEmail(email.getText().toString());
                saveUserData(user);
                break;
            case R.id.tjson:
                Intent TIntent = new Intent(MainActivity.this, TJson.class);
                startActivity(TIntent);
                break;
            default:
                break;
        }
    }

    public void saveUserData(User user){
        Gson gson = new Gson();
        String string = gson.toJson(user, User.class) + ",";
        FileOutputStream fos = null;
        BufferedWriter bfw = null;
        try {
            fos = openFileOutput("jsondata", MODE_APPEND);
            bfw = new BufferedWriter(new OutputStreamWriter(fos));
            bfw.write(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bfw != null){
                try {
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
