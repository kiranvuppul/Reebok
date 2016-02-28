package saiz.reebok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by saikiran on 11/20/2015.
 */
public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {
    ListView listView;
    Spinner s;
    String matter;

    private ArrayAdapter<String> productAdapter;
    String[] mShoes={"Premier Zigfly ","Runtone Motive","Premier Aztrec 2 ","Premier Verona" +
            "Supreme 2","Coral Hex (Shaft)"};
    String[] mApparel={"D7 Polo ","ICC WC India Tricolour Flag Tee","Revolution Reebok Tee","Lifestyle Core"};
    String[] mAccessories={"Reeload (Men) Perfume","Sunglasses - Egret","Watch - Cantura","Runtone Motive " };
    ArrayAdapter<String> a1,a2,a3;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.second);

        s = (Spinner) findViewById(R.id.countrySpinner);
        listView= (ListView) findViewById(R.id.listView1);


        productAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        productAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        productAdapter.add("Shoes");
        productAdapter.add("Apparel");
        productAdapter.add("Accessories");
        a1= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mShoes);
        a2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mApparel);
        a3=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mAccessories);
        s.setAdapter(productAdapter);
        s.setOnItemSelectedListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, "Selected Category is " + productAdapter.getItem(position), Toast.LENGTH_SHORT).show();
        if(position==0) {

            listView.setAdapter(a1);
            a1.notifyDataSetChanged();
        }
        else if(position==1) {

            listView.setAdapter(a2);
            a2.notifyDataSetChanged();
        }
        else if(position==2) {

            listView.setAdapter(a3);
            a3.notifyDataSetChanged();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent third=new Intent(this,ThirdActivity.class);
        String list=listView.getItemAtPosition(position).toString();
        Bundle b = new Bundle();
        b.putString("List",list);
        third.putExtras(b);
        startActivity(third);
        Toast.makeText(SecondActivity.this, "Selected Item is " + list, Toast.LENGTH_LONG).show();


    }
}
