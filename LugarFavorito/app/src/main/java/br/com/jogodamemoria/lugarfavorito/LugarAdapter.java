package br.com.jogodamemoria.lugarfavorito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by thor on 28/06/16.
 */
public class LugarAdapter<T> extends BaseAdapter {
    private Cadastro cadastro;
    private Context context;

    public LugarAdapter(Cadastro cadastro, Context context) {
        this.cadastro = cadastro;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.cadastro.getQuantidade();
    }

    @Override
    public Object getItem(int position) {
        return this.cadastro.getLugar(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Lugar d = this.cadastro.getLugar(position);

        if (convertView == null){
            LayoutInflater li = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.layout_lugar, null);
        }else{
            view = convertView;
        }

        view.setMinimumHeight(300);

        ImageView ivFoto = (ImageView) view.findViewById(R.id.ivFotoCelula);
        TextView tvNome = (TextView) view.findViewById(R.id.tvNomeCelula);

        if (d.getFoto() != null)
            ivFoto.setImageBitmap(d.getFoto());

        tvNome.setText(d.getNome());

        return view;
    }
}
