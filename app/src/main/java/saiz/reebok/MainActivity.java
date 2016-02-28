package saiz.reebok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView mListView;
    String[] titles={"Shoes","Apparel","Accessories"};
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        mListView= (ListView) findViewById(R.id.listView);
        mImageView= (ImageView) findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.logo);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,titles);
        mListView.setAdapter(arrayAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String titles = String.valueOf(parent.getItemAtPosition(position));
        switch (position){
            case 0:
                Intent intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(this,SecondActivity.class);
                startActivity(intent);
                break;

        }
    }

     }






