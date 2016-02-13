package com.example.cidseuser.gestures;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView gestureText;
    private GestureDetectorCompat gesturedetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        gestureText = (TextView) findViewById(R.id.textView);
        gesturedetector = new GestureDetectorCompat(this,this);
        gesturedetector.setOnDoubleTapListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    //begin implements
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureText.setText("Single Tap Confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureText.setText("Double Tap Confirmed");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureText.setText("onDoubleTapEvent Confirmed");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        gestureText.setText("onDown Confirmed");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureText.setText("onShowPress Confirmed");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureText.setText("onSingleTapUp Confirmed");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureText.setText("onScroll Confirmed");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureText.setText("onLongPress Confirmed");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureText.setText("onFling Confirmed");
        return true;
    }
    //end implements


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gesturedetector.onTouchEvent(event);
        return super.onTouchEvent(event);
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
