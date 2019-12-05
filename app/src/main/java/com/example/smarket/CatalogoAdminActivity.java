package com.example.smarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class CatalogoAdminActivity extends AppCompatActivity {

    private AdapterListaCompras adapter;
    private Produtos produto;
    private ProdutosDAO dao = new ProdutosDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_admin);

        List<Produtos> lista = dao.listarProdutos();

        adapter = new AdapterListaCompras(lista, this);

        ListView listView = findViewById(R.id.listView_catalogo_admin);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        FloatingActionButton fab_cadastro = findViewById(R.id.fab_cadastro_produtos);
        fab_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogoAdminActivity.this, CadastroProdutoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_admin, menu);
    }

    public boolean onContextItemSelected (MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        produto = (Produtos) adapter.getItem(contextMenuInfo.position);

        if (item.getItemId() == R.id.admin_apagar){
            ProdutosDAO dao = new ProdutosDAO(this);
            dao.remover((Produtos) item);
            onResume();
        }
        if(item.getItemId() == R.id.admin_editar){
            Intent intent = new Intent(CatalogoAdminActivity.this, CadastroProdutoActivity.class);
            intent.putExtra("produto", produto);
            startActivity(intent);

        }
        //else if(item.getItemId() == R.id.admin_editar){}

        return  super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opcoes_admin, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        return super.onOptionsItemSelected(item);
    }

    protected void onResume(){

        super.onResume();
        adapter.atualiza(dao.listarProdutos());

    }

}
