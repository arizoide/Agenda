package br.edu.ifspsaocarlos.agenda.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "agenda.db";
    static final String DATABASE_TABLE = "contatos";
    static final String KEY_ID = "id";
    static final String KEY_NAME = "nome";
    static final String KEY_FONE = "fone";
    static final String KEY_EMAIL = "email";
    static final String KEY_FAVORITO = "favorito";
    static final String KEY_FONE_ADICIONAL = "foneAdicional";
    static final String KEY_EMAIL_ADICIONAL = "emailAdicional";
    static final String KEY_ANIVERSARIO = "aniversario";
    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_CREATE = "CREATE TABLE " + DATABASE_TABLE + " (" +
            KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            KEY_NAME + " TEXT NOT NULL, " +
            KEY_FONE + " TEXT, " +
            KEY_FONE_ADICIONAL + " TEXT, " +
            KEY_EMAIL + " TEXT, " +
            KEY_EMAIL_ADICIONAL + " TEXT, " +
            KEY_ANIVERSARIO + " TEXT, " +
            KEY_FAVORITO + " INTEGER);";

    SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            String sql = "ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN " + KEY_FAVORITO + " INTEGER";
            database.execSQL(sql);
            ContentValues values = new ContentValues();
            values.put(SQLiteHelper.KEY_FAVORITO, Boolean.FALSE);
            database.update(SQLiteHelper.DATABASE_TABLE, values, null, null);
        }

        if (oldVersion < 3) {
            String sql = "ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN " + KEY_FONE_ADICIONAL + " TEXT";
            database.execSQL(sql);
        }

        if (oldVersion < 4) {
            String sql = "ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN " + KEY_EMAIL_ADICIONAL + " TEXT";
            database.execSQL(sql);

            String sqlAniver = "ALTER TABLE " + DATABASE_TABLE + " ADD COLUMN " + KEY_ANIVERSARIO + " TEXT";
            database.execSQL(sqlAniver);
        }
    }
}

