package com.linken.scissorrockpaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout bg;
    Button btnAgain;
    ImageView viewR;
    ImageView viewS;
    ImageView viewP;
    ArrayList<ImageView> listOfViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.linear_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //greeting();
        addListenerOnImageView();
        addListenerOnButton();
    }

    private void greeting() {
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
    }

    private void addListenerOnButton() {
        btnAgain = (Button) findViewById(R.id.buttonAgn);
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(ImageView image: listOfViews) {
                    image.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void addListenerOnImageView() {
        viewR = (ImageView) findViewById(R.id.imgRock);
        viewS = (ImageView) findViewById(R.id.imgScissor);
        viewP = (ImageView) findViewById(R.id.imgPaper);

        listOfViews = new ArrayList<>();
        listOfViews.add(viewR);
        listOfViews.add(viewS);
        listOfViews.add(viewP);

        viewR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherView(viewR);
                Toast.makeText(MainActivity.this, "You selected Rock!", Toast.LENGTH_SHORT).show();
            }
        });

        viewS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherView(viewS);
                Toast.makeText(MainActivity.this, "You selected Scissor!", Toast.LENGTH_SHORT).show();
            }
        });

        viewP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherView(viewP);
                Toast.makeText(MainActivity.this, "You selected Paper!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void hideOtherView(ImageView selected) {

        for(ImageView view : listOfViews) {
            if (view != selected) {
                view.setVisibility(View.INVISIBLE);
            }
        }
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
