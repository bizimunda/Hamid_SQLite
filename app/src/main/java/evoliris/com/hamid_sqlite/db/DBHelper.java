package evoliris.com.hamid_sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import evoliris.com.hamid_sqlite.db.dao.UserDao;

/**
 * Created by temp on 29/08/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="user_db";
    public static final int DB_VERSION=2;


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDao.CREATE_REQUEST);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserDao.DROP_REQUEST);
        db.execSQL(UserDao.CREATE_REQUEST);


    }
}
