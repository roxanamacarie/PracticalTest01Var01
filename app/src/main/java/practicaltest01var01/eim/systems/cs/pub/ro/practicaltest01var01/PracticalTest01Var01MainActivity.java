package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private TextView text = null;
    private Button north = null;
    private Button east = null;
    private Button west = null;
    private Button south = null;
    private Button next_activity = null;
    private int numberOfClicks = 0;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private static final String TAG ="MAINAC";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();



    private String fill ="";
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.n:
                    text.setText(text.getText().toString() + ",NORTH");
                    fill += ",NORTH";
                    Log.d(TAG,"north");
                    numberOfClicks++;
                    Log.d(TAG,Integer.toString(numberOfClicks));

                    break;
                case R.id.e:
                    text.setText(text.getText().toString() + ",EAST");
                    numberOfClicks++;
                    fill += ",EAST";
                    Log.d(TAG,Integer.toString(numberOfClicks));


                    break;
                case R.id.w:
                    text.setText(text.getText().toString() + ",WEST");
                    numberOfClicks++;
                    fill += ",WEST";
                    Log.d(TAG,Integer.toString(numberOfClicks));

                    break;
                case R.id.s:
                    text.setText(text.getText().toString() + ",SOUTH");
                    numberOfClicks++;
                    fill += ",SOUTH";
                    Log.d(TAG,Integer.toString(numberOfClicks));


                    break;
                case R.id.next:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
                    intent.putExtra("numberOfClicks", numberOfClicks);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        text = (TextView)findViewById(R.id.text);
        north = (Button)findViewById(R.id.n);
        east = (Button)findViewById(R.id.e);
        west = (Button)findViewById(R.id.w);
        south = (Button)findViewById(R.id.s);
        next_activity = (Button)findViewById(R.id.next);

        north.setOnClickListener(buttonClickListener);
        east.setOnClickListener(buttonClickListener);
        west.setOnClickListener(buttonClickListener);
        south.setOnClickListener(buttonClickListener);
        next_activity.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("text")) {
            text.setText(savedInstanceState.getString("text"));
        }
    }
}
