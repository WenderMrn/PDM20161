package br.edu.ifpb.si.pdm.analitico.models;

/**
 * Created by thor on 17/07/16.
 */
public class Person {
    private int id;
    private byte[] img;
    private String textInfo;

    public Person(){}
    public Person(byte[] url_img, String textInfo){
        this.img = url_img;
        this.textInfo = textInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return this.img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }
}
