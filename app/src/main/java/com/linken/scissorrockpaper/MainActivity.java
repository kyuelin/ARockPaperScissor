package com.linken.scissorrockpaper;

import android.graphics.Color;
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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout yours, mine;
    Button btnAgain;
    ImageView viewYR, viewYS, viewYP, viewMR, viewMS, viewMP;
    ArrayList<ImageView> listOfYourViews, listOfMyViews;
    //ArrayList<String> listOfViewNames;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //greeting();
        addListenerOnYourImageView();
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
                for(ImageView image: listOfYourViews) {
                    image.setVisibility(View.VISIBLE);
                    image.setClickable(true);
                }
                for(ImageView image: listOfMyViews) {
                    image.setVisibility(View.INVISIBLE);
                }
                btnAgain.setText(R.string.btn_pick_one);
                yours.setBackgroundColor(Color.WHITE);
                mine.setBackgroundColor(Color.WHITE);
                result.setText("");

            }
        });
    }

    private void addListenerOnYourImageView() {
        viewYR = (ImageView) findViewById(R.id.yourRock);
        viewYS = (ImageView) findViewById(R.id.yourScissor);
        viewYP = (ImageView) findViewById(R.id.yourPaper);

        listOfYourViews = new ArrayList<>();
        listOfYourViews.add(viewYR);
        listOfYourViews.add(viewYS);
        listOfYourViews.add(viewYP);

//        listOfViewNames = new ArrayList<>();
//        listOfViewNames.add("Rock");
//        listOfViewNames.add("Scissor");
//        listOfViewNames.add("Paper");
       
        viewYR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherYourViews(viewYR);
                play(viewYR);
            }
        });

        viewYS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherYourViews(viewYS);
                play(viewYS);
            }
        });

        viewYP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideOtherYourViews(viewYP);
                play(viewYP);
            }
        });
    }

    private void play(ImageView yourView) {
        viewMR = (ImageView) findViewById(R.id.myRock);
        viewMS = (ImageView) findViewById(R.id.myScissor);
        viewMP = (ImageView) findViewById(R.id.myPaper);

        listOfMyViews = new ArrayList<>();
        listOfMyViews.add(viewMR);
        listOfMyViews.add(viewMS);
        listOfMyViews.add(viewMP);

        yours = (LinearLayout) findViewById(R.id.yours);
        mine  = (LinearLayout) findViewById(R.id.mine);

        int yourInd = listOfYourViews.indexOf(yourView);
        int myInd = new Random().nextInt(3);
        StringBuilder strBuild = new StringBuilder();
//        strBuild.append("You selected ").append(listOfViewNames.get(yourInd)).append(".\n");
//        strBuild.append("I selected ").append(listOfViewNames.get(myInd)).append(".\n");
        listOfMyViews.get(myInd).setVisibility(View.VISIBLE);

        if (yourInd == myInd) {
            strBuild.append("Draw!");
            yours.setBackgroundColor(Color.BLUE);
            mine.setBackgroundColor(Color.BLUE);
        }
        else if ((yourInd+1)%3 == myInd) {
            strBuild.append("You won!");
            yours.setBackgroundColor(Color.GREEN);
            mine.setBackgroundColor(Color.RED);
        }
        else {
            strBuild.append("You lost!");
            mine.setBackgroundColor(Color.GREEN);
            yours.setBackgroundColor(Color.RED);
        }
        
        //Toast.makeText(MainActivity.this, strBuild.toString(), Toast.LENGTH_SHORT).show();
        result = (TextView) findViewById(R.id.result);
        result.setText(strBuild.toString());

        btnAgain.setText(R.string.btn_play_again);
        yourView.setClickable(false);
    }

    private void hideOtherYourViews(ImageView selected) {
        for(ImageView view : listOfYourViews) {
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
