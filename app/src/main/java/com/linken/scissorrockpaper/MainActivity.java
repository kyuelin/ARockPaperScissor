package com.linken.scissorrockpaper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        TextView helloView = (TextView) findViewById(R.id.helloView);
        StringBuilder strb = new StringBuilder("Hello ");
        int rint = new Random().nextInt(100)%4;
        System.out.println("random int : " + rint);
        switch(rint) {
            case 0:
                strb.append("Linus!");
                break;
            case 1:
                strb.append("Lyla!");
                break;
            case 2:
                strb.append("Peggy!");
                break;
            default:
                strb.append("Kenneth!");
                break;
        }
        helloView.setText(strb.toString());

        addListenerOnButton();

    }

    public  void addListenerOnButton () {
        final RadioGroup rspGroup = (RadioGroup) findViewById(R.id.rspGroup);
        Button plyBtn = (Button) findViewById(R.id.plyBtn);

        plyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rspGroup.getCheckedRadioButtonId();
                RadioButton selBtn = (RadioButton) findViewById(selected);
                Toast.makeText(MainActivity.this, selBtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
