package br.com.jogodamemoria.lugarfavorito;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private ImageView ivImagem;
    private TextView etNome;
    private TextView etDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        this.loadComponents();
        this.etNome.setText(getIntent().getStringExtra("LUGAR_NOME"));
        this.etDescricao.setText(getIntent().getStringExtra("LUGAR_DESCRICAO"));
        this.ivImagem.setImageBitmap((Bitmap)getIntent().getParcelableExtra("LUGAR_IMAGEM"));
    }

    public void loadComponents(){
        this.ivImagem = (ImageView) findViewById(R.id.ivShowImagem);
        this.etNome = (TextView) findViewById(R.id.tvShowNome);
        this.etDescricao = (TextView) findViewById(R.id.tvShowDescricao);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return super.onTouchEvent(event);
    }
}
