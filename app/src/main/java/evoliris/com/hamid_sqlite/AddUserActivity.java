package evoliris.com.hamid_sqlite;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import evoliris.com.hamid_sqlite.db.dao.UserDao;
import evoliris.com.hamid_sqlite.model.User;


public class AddUserActivity extends ActionBarActivity {

    private EditText username, salary;
    private Button btnSubmit;
    private DatePicker datePicker;
    private CheckBox cbDob;
    private int checkBox=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        username= (EditText) findViewById(R.id.et_addUser_username);
        salary= (EditText) findViewById(R.id.et_addUser_salary);
        btnSubmit= (Button) findViewById(R.id.btn_addUser_submit);
        datePicker= (DatePicker) findViewById(R.id.dp_addUser_dob);
        cbDob= (CheckBox) findViewById(R.id.cb_addUser_favorite);

        final Integer dobYear=datePicker.getYear();
        final Integer dobMonth=datePicker.getMonth();
        final Integer dobDate=datePicker.getDayOfMonth();

        btnSubmit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etUsername=username.getText().toString();
                String etSalary=salary.getText().toString();
                addListenerCheckBox();

                User user= new User();
                user.setName(etUsername);
                Calendar c= Calendar.getInstance();
                c.set(dobYear, dobMonth, dobDate);
                user.setDob(c.getTime());
                user.setSalary(Float.valueOf(etSalary));
                user.setFavourite(addListenerCheckBox());

                UserDao userDao= new UserDao(AddUserActivity.this);
                userDao.openWritable();
                if(userDao.create(user)){
                    Toast.makeText(AddUserActivity.this,"User added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddUserActivity.this,"Error ---", Toast.LENGTH_SHORT).show();
                }
                userDao.close();


            }
        });

    }

    public boolean addListenerCheckBox(){
        if(cbDob.isChecked()){
            checkBox=1;
            return true;
        } else {
            checkBox=0;
            return false;
        }
    }



}
