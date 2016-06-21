package br.com.jogodamemoria.lugarfavorito;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CadastroActivity extends AppCompatActivity {
    private static final int FOTO = 1;
    private LinearLayout llImagem;
    private EditText etNome;
    private EditText etDescricao;
    private ImageView ivImagem;
    private Bitmap bmImagem;
    private TextView tvMsgImagem;
    private Button btnCadastrar;
    private Button btnCancelar;
    private LinearLayout llApagarFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        this.loadComponents();
        this.btnCadastrar.setOnClickListener(new OnClick());
        this.btnCancelar.setOnClickListener(new OnClick());
        this.llImagem.setOnClickListener(new OnClick());
        this.llApagarFoto.setOnClickListener(new OnClick());
        this.llApagarFoto.setVisibility(View.INVISIBLE);
    }

    private void loadComponents(){
        this.etNome = (EditText) findViewById(R.id.etNome);
        this.etDescricao = (EditText) findViewById(R.id.etDescricao);
        this.ivImagem = (ImageView) findViewById(R.id.ivImagem);
        this.llImagem = (LinearLayout) findViewById(R.id.llImagem);
        this.btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        this.btnCancelar = (Button) findViewById(R.id.btnCancelar);
        this.tvMsgImagem = (TextView) findViewById(R.id.tvMsgImagem);
        this.llApagarFoto = (LinearLayout) findViewById(R.id.llApagarFoto);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == FOTO){
                CadastroActivity.this.bmImagem = (Bitmap) data.getParcelableExtra("data");
                CadastroActivity.this.ivImagem.setImageBitmap(CadastroActivity.this.bmImagem);
                CadastroActivity.this.tvMsgImagem.setText("trocar imagem");
                CadastroActivity.this.llApagarFoto.setVisibility(View.VISIBLE);
            }
        }
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            if(v.equals(CadastroActivity.this.btnCadastrar)){
                String nome = CadastroActivity.this.etNome.getText().toString();
                String descricao = CadastroActivity.this.etDescricao.getText().toString();

                Intent it = new Intent();
                it.putExtra("LUGAR_NOME",nome);
                it.putExtra("LUGAR_DESCRICAO",descricao);
                it.putExtra("LUGAR_IMAGEM",CadastroActivity.this.bmImagem);
                setResult(RESULT_OK, it);
                finish();
            }else if(v.equals(CadastroActivity.this.btnCancelar)){
                finish();
            }else if(v.equals(CadastroActivity.this.llImagem)){
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(it,CadastroActivity.this.FOTO);
            }else if(v.equals(CadastroActivity.this.llApagarFoto)){
                CadastroActivity.this.llApagarFoto.setVisibility(View.INVISIBLE);
                CadastroActivity.this.ivImagem.setImageResource(0);
                CadastroActivity.this.tvMsgImagem.setText(R.string.btn_add_imagem);
            }

        }
    }
}
