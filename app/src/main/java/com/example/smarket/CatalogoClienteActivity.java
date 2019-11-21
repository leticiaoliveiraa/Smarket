package com.example.smarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CatalogoClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_cliente);
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_cliente, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){
            if(item.getItemId() == R.id.menu_item_lista_compras){
                Intent intent = new Intent(CatalogoClienteActivity.this,ListaComprasActivity.class);
                startActivity(intent);
            }

            return super.onOptionsItemSelected(item);
        }

}
