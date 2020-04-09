package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {

    private TextView sumTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_colocviu1_245_secondary);


        sumTextView = findViewById(R.id.all_term_text);
        Intent intent = getIntent();
        Bundle data = intent.getExtras();

        String sumString = data.getString("total");
        int total = 0;
        for(int i = 0; i < sumString.length(); i++){
            if(Character.isDigit(sumString.charAt(i))){
                int c = Integer.parseInt(String.valueOf(sumString.charAt(i)));
                total = total + c;
            }
        }

        Intent intentParent = new Intent();
        intentParent.putExtra("total", total + ""); //aici
        setResult(RESULT_OK, intentParent);
        finish();

    }
}
