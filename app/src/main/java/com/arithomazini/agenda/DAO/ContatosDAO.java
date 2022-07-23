package com.arithomazini.agenda.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.biometrics.BiometricManager;

import androidx.annotation.Nullable;

import com.arithomazini.agenda.model.Contatos;

public class ContatosDAO extends SQLiteOpenHelper {
    public ContatosDAO(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table CONTATOS(" +
                "id integer," +
                "nome text," +
                "sobrenome text," +
                "email text," +
                "telefone text)";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void save(Contatos contatos) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nome", contatos.getNome());
        values.put("sobrenome", contatos.getSobreNome());
        values.put("email", contatos.getEmail());
        values.put("telefone", contatos.getTelefone());

        writableDatabase.insert("CONTATOS", null, values);
    }
}
