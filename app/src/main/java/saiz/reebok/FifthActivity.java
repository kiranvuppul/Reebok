package saiz.reebok;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by saikiran on 11/22/2015.
 */
public class FifthActivity extends AppCompatActivity {
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    public String listtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth);

        TextView nameEditText = (TextView) findViewById(R.id.textView6);
        TextView passwordEditText = (TextView) findViewById(R.id.textView7);

        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString(KEY_USERNAME);
        String password = bundle.getString(KEY_PASSWORD);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            listtext = b.getString("List");

        }
        TextView items = (TextView) findViewById(R.id.textView11);

        nameEditText.setText(username);
        passwordEditText.setText(password);

        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM  dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        items.setText(dateString);
    }


}



