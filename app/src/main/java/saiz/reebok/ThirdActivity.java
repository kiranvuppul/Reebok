package saiz.reebok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by saikiran on 11/20/2015.
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button backB,buynow;
    public String listtext;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);
        Bundle b = getIntent().getExtras();
        if (b != null)
        {
            listtext = b.getString("List");

        }
        textView= (TextView) findViewById(R.id.nameOfText);
        textView.setText(listtext);
        backB= (Button) findViewById(R.id.back);
        buynow= (Button) findViewById(R.id.checkout);
        backB.setOnClickListener(this);
        buynow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back){
           super.onBackPressed();

        }
        else if(v.getId()==R.id.checkout){
            Intent intent=new Intent(this,FourthActivity.class);
            startActivity(intent);
        }
    }
}
