package com.example.fighting4ever.gsontest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fighting4Ever on 2016/4/21.
 */
public class ListJson extends AppCompatActivity {
    @Bind(R.id.list_view)
    ListView listView;
    private List<User> userList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_json);
        ButterKnife.bind(this);
        userList = getUsers();
        if (!userList.isEmpty()){
            List<String> dataList = new ArrayList<>();
            for (User user : userList){
                dataList.add(user.toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
            listView.setAdapter(adapter);
        }
    }
    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        FileInputStream fis = null;
        BufferedReader bfr = null;
        try {
            fis = openFileInput("jsondata");
            bfr = new BufferedReader(new InputStreamReader(fis));
            StringBuilder builder = new StringBuilder();
            String str = "";
            while ((str = bfr.readLine()) != null){
                builder.append(str);
            }
            String bs = builder.toString();
            String jsonString = "[" + bs.substring(0, bs.length()-1) + "]";
            Log.v("lijianqi", jsonString);
            Gson gson = new Gson();
            Type type = new TypeToken<List<User>>(){}.getType();
            users = gson.fromJson(jsonString, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bfr != null){
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }
}
