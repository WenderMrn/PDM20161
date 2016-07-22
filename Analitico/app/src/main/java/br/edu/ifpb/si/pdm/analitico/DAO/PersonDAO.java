package br.edu.ifpb.si.pdm.analitico.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.si.pdm.analitico.util.DataBaseHelper;
import br.edu.ifpb.si.pdm.analitico.models.Person;

/**
 * Created by thor on 17/07/16.
 */
public class PersonDAO implements  DAO<Person>{
    private DataBaseHelper dataBaseHelper;
    private static final String TABLE = "person";

    public PersonDAO(Context context) {
        this.dataBaseHelper = new DataBaseHelper(context);
    }


    @Override
    public void create(Person obj) {
        ContentValues cv = new ContentValues();
        cv.put("photo", obj.getImg());
        cv.put("text_info",obj.getTextInfo());
        this.dataBaseHelper.getWritableDatabase().insert(TABLE, null, cv);
    }

    @Override
    public void update(Person obj) {

    }

    @Override
    public void delete(int id) {
        String[] where = {Integer.toString(id)};
        this.dataBaseHelper.getWritableDatabase().delete(TABLE, "id = ?", where);
    }

    @Override
    public void delete(Person obj) {
        this.delete(obj.getId());
    }

    @Override
    public Person read(int id) {
        return null;
    }

    @Override
    public List<Person> readAll() {
        String[] colunas = {"id", "photo","text_info"};
        List<Person> persons = new ArrayList<Person>();

        Cursor c = this.dataBaseHelper.getReadableDatabase().query(TABLE, colunas, null, null, null, null, "id");
        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                Person p = new Person();
                p.setId(c.getInt(c.getColumnIndex(colunas[0])));
                p.setImg(c.getBlob(c.getColumnIndex(colunas[1])));
                p.setTextInfo(c.getString(c.getColumnIndex(colunas[2])));
                persons.add(p);
            }while (c.moveToNext());
        }

        return persons;
    }
}
