package com.example.fighting4ever.gsontest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Fighting4Ever on 2016/4/21.
 */
public class TJson extends AppCompatActivity {
    @Bind(R.id.text_view1)
    TextView boxTv;
    @Bind(R.id.text_view2)
    TextView carTv;
    @Bind(R.id.listview)
    ListView listView;
    private static final String BOXES ="[{\"code\":\"5\",\"price\":\"135.6\",\"co\":{\"weight\":\"8.96\",\"height\":\"6.98\"}}," +
            "{\"code\":\"6\",\"price\":\"268.9\",\"co\":{\"weight\":\"7.96\",\"height\":\"6.18\"}}," +
            "{\"code\":\"7\",\"price\":\"777.8\",\"co\":{\"weight\":\"5.68\",\"height\":\"3.72\"}}," +
            "{\"code\":\"8\",\"price\":\"989.8\",\"co\":{\"weight\":\"6.38\",\"height\":\"3.99\"}}]";
    private static final String CAR ="{\"code\":\"10\",\"price\":\"96888.88\",\"co\":{\"brand\":\"Benzs\",\"color\":\"black\"}}";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_json);
        ButterKnife.bind(this);
        boxTv.setText(BOXES);
        carTv.setText(CAR);
        List<String> coms = new ArrayList<>();
        Gson gson = new Gson();
        List<Commodity<Box>> boxCommodities = gson.fromJson(BOXES, new TypeToken<List<Commodity<Box>>>(){}.getType());
        for (Commodity<Box> boxCommodity : boxCommodities){
            Box box = boxCommodity.co;
            coms.add(box.toString());
        }
        Commodity<Car> carCommodity = gson.fromJson(CAR, new TypeToken<Commodity<Car>>(){}.getType());
        Car car = carCommodity.co;
        coms.add(car.toString());
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coms));
    }
}
