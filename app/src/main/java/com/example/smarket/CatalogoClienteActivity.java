package com.example.smarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CatalogoClienteActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_cliente);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        ListView listView = findViewById(R.id.listView_catalogo);
        listView.setAdapter(adapter);

    }

    protected void onResume() {
        super.onResume();
        List<Produtos> lista = new ProdutosDAO(this).listarProdutos();
        adapter.clear();
        adapter.addAll(lista);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_opcoes_cliente, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){


            return super.onOptionsItemSelected(item);
        }

}
