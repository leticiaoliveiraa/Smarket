package com.example.smarket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smarket.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonla = (Button) findViewById(R.id.admin_button);
        buttonla.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, LoginAdmin.class);
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });


        final Button buttoncli = (Button) findViewById(R.id.cliente_button);
        buttoncli.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, ListaComprasActivity.class);
                MainActivity.this.startActivity(activityChangeIntent);
            }
        });



    }
}
