package com.example.smarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        Button button_cadastro_produto = findViewById(R.id.button_cadastro_produto);
        button_cadastro_produto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText editTextNome = findViewById(R.id.editText_nome);
                EditText editTextCategoria = findViewById(R.id.editText_categoria);
                EditText editTextPreco = findViewById(R.id.editText_preco);
                EditText editTextMarca = findViewById(R.id.editText_marca);
                EditText editTextDataValidade = findViewById(R.id.editText_data);

                String nome = editTextNome.getText().toString();
                String categoria = editTextCategoria.getText().toString();
                Double preco = Double.parseDouble(editTextPreco.getText().toString());
                String marca = editTextMarca.getText().toString();
                String data = editTextDataValidade.getText().toString();

                ProdutosDAO dao = new ProdutosDAO(CadastroProdutoActivity.this);

                Produtos produto = new Produtos(nome, categoria ,preco, marca, data);
                Toast.makeText(getApplicationContext(), "Produto cadastrado", Toast.LENGTH_LONG);
                Intent intent = new Intent(CadastroProdutoActivity.this, CatalogoClienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
