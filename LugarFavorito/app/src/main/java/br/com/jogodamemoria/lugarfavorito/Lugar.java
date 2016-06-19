package br.com.jogodamemoria.lugarfavorito;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Location;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by thor on 15/06/16.
 */
public class Lugar implements Serializable{
    private String nome;
    private String descricao;
    private Location localizacao;
    transient Bitmap foto;

    public Lugar(String nome, String descricao, Location localizacao,Bitmap foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Location getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Location localizacao) {
        this.localizacao = localizacao;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}

