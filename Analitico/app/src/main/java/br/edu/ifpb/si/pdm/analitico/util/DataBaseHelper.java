package br.edu.ifpb.si.pdm.analitico.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thor on 17/07/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "analitico.db";
    private static final int VERSAO = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table person(" +
                "id integer primary key autoincrement not null, " +
                "photo blob null,text_info string null);";
        db.execSQL(sql);
        Log.i("ANALITICO", "Tabela person criada.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
