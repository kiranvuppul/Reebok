package saiz.reebok;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.lang.reflect.Array;

/**
 * Created by saikiran on 11/20/2015.
 */
public class FourthActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    ListView listView;
    private EditText nameEditText, emailEditText;
    public String matter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth);

        nameEditText = (EditText) findViewById(R.id.inputname);
        emailEditText = (EditText) findViewById(R.id.inputEmail);
        //listView= (ListView) findViewById(R.id.listView2);
        Button loginButton = (Button) findViewById(R.id.button2);

        loginButton.setOnClickListener(this);

        sharedPreferences = getSharedPreferences("login_info", Context.MODE_PRIVATE);

        if (sharedPreferences.contains(KEY_USERNAME)) {
            nameEditText.setText(sharedPreferences.getString(KEY_USERNAME, ""));
        }

        if (sharedPreferences.contains(KEY_PASSWORD)) {
            emailEditText.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
        }
        Bundle b = getIntent().getExtras();

        if (b != null) {
            matter = b.getString("List");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                showWelcomeScreen();
                break;

        }
    }

    private void showWelcomeScreen() {

        sharedPreferences.edit().putString(KEY_USERNAME, nameEditText.getText().toString()).apply();
        sharedPreferences.edit().putString(KEY_PASSWORD, emailEditText.getText().toString()).apply();


        Intent intent = new Intent(this, FifthActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(KEY_USERNAME, nameEditText.getText().toString());
        bundle.putString(KEY_PASSWORD, emailEditText.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }



}




