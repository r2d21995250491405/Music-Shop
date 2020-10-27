package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {
    String [] addresses = {"ilyusha.mishhishin@mail.ru"};
    String subject ="Order From Music Shop";
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        Button sendbtn = findViewById(R.id.button);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, subject);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        setTitle("Order");



        Intent orderIntent = getIntent();
        TextView textView = findViewById(R.id.textView4);
        String username = orderIntent.getStringExtra("usernameforIntent");
        String goodsname = orderIntent.getStringExtra("goodsname");
        int quant = orderIntent.getIntExtra("quant", 0);
        double price = orderIntent.getDoubleExtra("price", 0.0);
        double priceforone = orderIntent.getDoubleExtra("priceforone", 0.0);
        text = "Customer: " + username + "\n" + "Goods Name: " + goodsname + "\n " + "Quantity: " + quant + " \n" + "Order Price: " + price + " $. (Price for one item is " + priceforone;
        textView.setText(text);


    }
}