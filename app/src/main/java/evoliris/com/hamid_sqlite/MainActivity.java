package evoliris.com.hamid_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private Button btnAddUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Creation of DB

        /*UserDao userDao= new UserDao(this);
        userDao.openWritable();
        userDao.close();
        Toast.makeText(this, "DB Created", Toast.LENGTH_SHORT).show();*/

        //endregion

        btnAddUsers= (Button) findViewById(R.id.btn_main_addUsers);

        btnAddUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddUser= new Intent(MainActivity.this, AddUserActivity.class);
                startActivity(intentAddUser);
            }
        });


    }



}
