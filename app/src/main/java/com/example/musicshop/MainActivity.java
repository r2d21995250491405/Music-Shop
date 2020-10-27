package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int i = 0;
    ArrayList arrayList;
    ArrayAdapter spinnerAdapter;
    HashMap goodsMap;
    String goodsName;
    double price;
    Spinner spinner;
    Button btnOrder;
    EditText USERNAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        USERNAME = findViewById(R.id.putname);

        btnOrder = findViewById(R.id.button4);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order();
                order.username = USERNAME.getText().toString();
                order.goodsname = goodsName;
                order.quant = i;
                order.priceforine = price;
                order.price = price * i;

                Intent i = new Intent(MainActivity.this, OrderActivity.class);
                i.putExtra("usernameforIntent", order.username);
                i.putExtra("goodsname", order.goodsname);
                i.putExtra("quant", order.quant);
                i.putExtra("priceforone", order.priceforine);
                i.putExtra("price", order.price);
                startActivity(i);


            }
        });


        spinner = findViewById(R.id.spinner3);
        spinner.setOnItemSelectedListener(this);
        arrayList = new ArrayList();
        arrayList.add("guitar");
        arrayList.add("drums");
        arrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        goodsMap = new HashMap();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1000.0);
        goodsMap.put("keyboard", 1500.0);


        Button btn1 = findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reduceQuant();
            }
        });


        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increasQuant();
            }
        });

    }

    private void reduceQuant() {
        TextView text = findViewById(R.id.textView12);
        i--;
        if (i < 0) {
            i = 0;
        }
        text.setText(i + "");
        TextView textViewprice = findViewById(R.id.textView8);
        textViewprice.setText("" + i * price);


    }

    private void increasQuant() {
        i++;
        TextView text = findViewById(R.id.textView12);
        text.setText(i + " ");
        TextView textViewprice = findViewById(R.id.textView8);
        textViewprice.setText("" + i * price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double) goodsMap.get(goodsName);
        TextView textViewprice = findViewById(R.id.textView8);
        textViewprice.setText("" + i * price);

        ImageView goodsView = findViewById(R.id.imageView4);
        switch (goodsName) {
            case "guitar":
                goodsView.setImageResource(R.drawable.gutar);
                break;
            case "drums":
                goodsView.setImageResource(R.drawable.drums);
                break;
            case "keyboard":
                goodsView.setImageResource(R.drawable.keyboard);
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}