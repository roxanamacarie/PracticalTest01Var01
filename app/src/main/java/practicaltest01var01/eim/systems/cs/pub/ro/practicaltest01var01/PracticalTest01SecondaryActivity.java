package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 03.04.2018.
 */

public class PracticalTest01SecondaryActivity extends AppCompatActivity {
    private TextView text2 = null;
    private Button register = null;
    private Button cancel = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();



    private String fill ="";
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.register:
                    break;
                case R.id.cancel:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01MainActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        text2 = (TextView)findViewById(R.id.text2);
        register = (Button)findViewById(R.id.register);
        cancel = (Button)findViewById(R.id.cancel);

        register.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);
    }
}
