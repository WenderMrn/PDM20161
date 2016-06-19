package br.com.jogodamemoria.lugarfavorito;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thor on 15/06/16.
 */
public class Cadastro {
    private List<Lugar> lugares;
    public Cadastro() {
        this.lugares = new ArrayList<Lugar>();
        this.inserir();
    }

    private void inserir(){
        this.lugares.add(new Lugar("Pizza Mia","Pizzaria",null,null));
        this.lugares.add(new Lugar("Banco do Brasil","banco",null,null));
        this.lugares.add(new Lugar("Parque", "parque de diversao",null,null));
    }

    public int getQuantidade(){
        return this.lugares.size();
    }

    public void cadastrar(String nome, String descricao, Location p, Bitmap f){
        this.lugares.add(new Lugar(nome,descricao,p,f));
    }
    public void cadastrar(Lugar l){
        this.lugares.add(l);
    }

    public List<Lugar> getLugares(){
        return this.lugares;
    }
}

