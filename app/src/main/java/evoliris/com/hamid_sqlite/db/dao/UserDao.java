package evoliris.com.hamid_sqlite.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import evoliris.com.hamid_sqlite.db.DBHelper;
import evoliris.com.hamid_sqlite.model.User;

/**
 * Created by temp on 29/08/2016.
 */
public class UserDao {

    public static final String TABLE_NAME="user";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_DOB = "dob";
    public static final String COL_SALARY = "salary";
    public static final String COL_FAVORITE = "favorite";

    public static final String CREATE_REQUEST = "CREATE TABLE " + TABLE_NAME
            + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL, "
            + COL_DOB + " DATE, "
            + COL_SALARY + " FLOAT, "
            + COL_FAVORITE + " BOOLEAN NOT NULL "
            + ");";

    public static final String DROP_REQUEST = "DROP TABLE " + TABLE_NAME;

    private DBHelper helper;
    private Context context;
    private SQLiteDatabase db;

    public UserDao(Context context){
        this.context=context;
    }

    public UserDao openWritable(){
        helper=new DBHelper(context);
        db=helper.getWritableDatabase();
        return this;
    }

    public UserDao openReadable(){
        helper=new DBHelper(context);
        db=helper.getReadableDatabase();
        return this;
    }

    public void close(){
        helper.close();
        db.close();

    }

    public boolean create(User user) {
        ContentValues values = new ContentValues();

        values.put(COL_NAME, user.getName());
        values.put(COL_DOB, user.getDob().getTime());
        values.put(COL_SALARY, user.getSalary());
        values.put(COL_FAVORITE, user.isFavourite());
        long id = db.insert(TABLE_NAME, null, values);
        if (id == -1) {
            return false;
        } else {
            user.setId(id);
            return true;
        }
    }

}
