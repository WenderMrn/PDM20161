package br.com.jogodamemoria.lugarfavorito;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private static final int TELA_CADASTRAR = 1, TELA_SOBRE = 2,TELA_SHOW = 3;
    private ListView lvLista;
    private Cadastro cadastro;
    //private ArrayAdapter<Lugar> listAdapter;
    private LugarAdapter adapter;
    public MainActivity(){
        this.cadastro = new Cadastro();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadComponents();
        //this.listAdapter = new ArrayAdapter<Lugar>(this,android.R.layout.simple_list_item_1,this.cadastro.getLugares());
        this.adapter = new LugarAdapter(this.cadastro,this);
        this.lvLista.setAdapter(this.adapter);
        this.lvLista.setOnItemClickListener(new OnClick());

    }

    private void loadComponents(){
        this.lvLista = (ListView) findViewById(R.id.lvLista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, TELA_CADASTRAR, 1, "Cadastrar");
        menu.add(0, TELA_SOBRE, 2, "Sobre");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case TELA_CADASTRAR:
                Intent it = new Intent(MainActivity.this,CadastroActivity.class);
                startActivityForResult(it, TELA_CADASTRAR);
                break;
            case TELA_SOBRE:
                Intent it2 = new Intent(MainActivity.this,SobreActivity.class);
                startActivityForResult(it2,TELA_SOBRE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == TELA_CADASTRAR){
                String nome = (String)data.getSerializableExtra("LUGAR_NOME");
                String descricao = (String)data.getSerializableExtra("LUGAR_DESCRICAO");
                Bitmap imagem = (Bitmap) data.getParcelableExtra("LUGAR_IMAGEM");
                Lugar l = new Lugar(nome,descricao,null,imagem);
                MainActivity.this.cadastro.cadastrar(l);
                this.adapter.notifyDataSetChanged();
                //Log.i("LF","Chegou");
            }
        }

    }

    private class OnClick implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent it = new Intent(MainActivity.this,ShowActivity.class);
            it.putExtra("LUGAR_NOME",MainActivity.this.cadastro.getLugares().get(position).getNome());
            it.putExtra("LUGAR_DESCRICAO",MainActivity.this.cadastro.getLugares().get(position).getDescricao());
            it.putExtra("LUGAR_IMAGEM",MainActivity.this.cadastro.getLugares().get(position).getFoto());
            startActivityForResult(it, TELA_SHOW);
        }
    }
}
