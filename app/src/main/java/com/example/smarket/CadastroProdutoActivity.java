package com.example.smarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        Button button_cadastro_produto = findViewById(R.id.button_cadastro_produto);
        button_cadastro_produto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CadastroProdutoActivity.this, CatalogoClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
