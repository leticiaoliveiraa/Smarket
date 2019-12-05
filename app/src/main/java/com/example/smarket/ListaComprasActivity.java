package com.example.smarket;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListaComprasActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compras);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        ListView listView = findViewById(R.id.listView_ListaCompras);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);



        FloatingActionButton fab_catalogo = findViewById(R.id.fab_catalogo_produtos);
        fab_catalogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaComprasActivity.this, CatalogoClienteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Produtos> lista = new ListaDeComprasDAO(this).listarProdutos();
        adapter.clear();
        adapter.addAll(lista);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_cliente, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Produtos p = (Produtos) adapter.getItem(contextMenuInfo.position);

        if(item.getItemId() == R.id.cliente_apagar){
            ListaDeComprasDAO bd = new ListaDeComprasDAO(this);
            bd.apagarProduto(p);
            onResume();
        }

        return super.onContextItemSelected(item);

    }


}
