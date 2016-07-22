package br.edu.ifpb.si.pdm.analitico.activity;

import android.content.Intent;
import android.graphics.Bitmap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import br.edu.ifpb.si.pdm.analitico.util.BitmapByteHelper;
import br.edu.ifpb.si.pdm.analitico.R;

public class DetailActivity extends AppCompatActivity {
    private ImageView ivPhoto;
    private TextView tvInfo;
    private Button btnSalvar;
    private byte[] photo_bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        loadComponents();

        Intent it = getIntent();

        String photo_url = it.getStringExtra("photo_url");
        if(photo_url != null){
            Picasso.with(DetailActivity.this)
                .load(photo_url)
                .resize(600,450)
                .onlyScaleDown()
                .transform(new BitmapTransformation())
                .into(this.ivPhoto);
        }else{
            byte[] photo = it.getByteArrayExtra("photo");
            if(photo != null){
                this.ivPhoto.setImageBitmap(BitmapByteHelper.getImage(photo));
                this.btnSalvar.setVisibility(View.INVISIBLE);
            }
        }


        String text = it.getStringExtra("formated_text");

        this.tvInfo.setText(text);

        this.btnSalvar.setOnClickListener(new OnClick());
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent it = new Intent();
            String text = DetailActivity.this.tvInfo.getText().toString();
            byte[] photo = DetailActivity.this.photo_bmp;
            it.putExtra("formated_text",text);
            it.putExtra("photo",photo);
            setResult(RESULT_OK,it);
            finish();
        }
    }

    private void loadComponents(){
        this.ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        this.tvInfo = (TextView) findViewById(R.id.tvInfo);
        this.btnSalvar = (Button) findViewById(R.id.btnSalvar);
    }

    public class BitmapTransformation implements Transformation {
        @Override public Bitmap transform(Bitmap source) {
            DetailActivity.this.photo_bmp = BitmapByteHelper.getBytes(source);
            return source;
        }

        @Override public String key() { return "square()"; }
    }

}
