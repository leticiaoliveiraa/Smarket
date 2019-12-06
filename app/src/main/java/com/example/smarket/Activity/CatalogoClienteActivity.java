package com.example.smarket.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.smarket.Adapter.AdapterCatalogo;
import com.example.smarket.BD.DaoLista;
import com.example.smarket.BD.ProdutosDAO;
import com.example.smarket.Objetos.Produtos;
import com.example.smarket.R;

import java.util.List;

public class CatalogoClienteActivity extends AppCompatActivity {

    private AdapterCatalogo adapter;
    private Produtos produto;
    private DaoLista daoLista;
    private ProdutosDAO dao = new ProdutosDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_cliente);
        List<Produtos> lista = dao.listarProdutos();

        adapter = new AdapterCatalogo(lista, this);

        ListView listView = findViewById(R.id.listView_catalogo);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_catalogo_cliente, menu);
    }

    public boolean onContextItemSelected (MenuItem item) {

        AdapterView.AdapterContextMenuInfo contextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        produto = (Produtos) adapter.getItem(contextMenuInfo.position);

        if (item.getItemId() == R.id.enviar_produto_cliente){

            Intent intent = new Intent(CatalogoClienteActivity.this, ListaComprasActivity.class);
            //intent.putExtra("produto", produto);

            daoLista.lista.add(produto);
            startActivity(intent);

        /*if(item.getItemId() == R.id.menu_item_editar){
            Intent minhaIntent = new Intent(this, AdicionarUsuario.class);
            minhaIntent.putExtra("usuario", usuario);
            startActivity(minhaIntent);
        }
        else if(item.getItemId() == R.id.menu_item_excluir){
            bancoDeDados.excluir(usuario.getId());
            this.onResume();
        }*/
        }

        return  super.onContextItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        List<Produtos> lista = new ProdutosDAO(this).listarProdutos();
        adapter.atualiza(dao.listarProdutos());
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
