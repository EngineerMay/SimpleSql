package com.example.mayankchauhan.sqlmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText USER_PASS , USER_NAME,CON_PASS;
    String uname,upass,cpass;
    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USER_NAME = (EditText) findViewById(R.id.name);
        USER_PASS = (EditText) findViewById(R.id.pass);
        CON_PASS = (EditText) findViewById(R.id.conpass);
        reg = (Button) findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        uname = USER_NAME.getText().toString();
        upass = USER_PASS.getText().toString();
        cpass = CON_PASS.getText().toString();

        if(!(cpass.equals(upass))){
            Toast.makeText(getBaseContext(),"PASSWORD NOT MATCHING",Toast.LENGTH_LONG).show();
            USER_NAME.setText("");
            USER_PASS.setText("");
            CON_PASS.setText("");
        }
        else
        {
            DatabaseOperations db = new DatabaseOperations(this);
            db.putInformation(db,uname,upass);
            Toast.makeText(this,"REGISTERATION SUCCESS",Toast.LENGTH_LONG).show();
            finish();
        }

    }
}
