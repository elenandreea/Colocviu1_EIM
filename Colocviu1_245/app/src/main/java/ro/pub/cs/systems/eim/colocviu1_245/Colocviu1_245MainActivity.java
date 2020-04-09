package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    private EditText nextTermText;
    private TextView allTermsText;
    private Button addBtn;
    private Button computeBtn;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {


            int term = Integer.valueOf(nextTermText.getText().toString());

            switch(view.getId()) {
                case R.id.add_button:
                    if(allTermsText.getText().toString() != ""){
                        String all_terms =  allTermsText.getText().toString();
                        allTermsText.setText(all_terms + "+" + term );
                    }else{
                        allTermsText.setText(term + '+');
                    }
                    break;
                case R.id.compute_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_245SecondaryActivity.class);
                    String total = allTermsText.getText().toString();
                    intent.putExtra("total", total);
                    startActivityForResult(intent, 1);
            }
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_245_main);

        nextTermText = (EditText)findViewById(R.id.next_term_text);
        allTermsText = (TextView) findViewById(R.id.all_term_text);

        addBtn = (Button)findViewById(R.id.add_button);
        addBtn.setOnClickListener(buttonClickListener);
        computeBtn = (Button)findViewById(R.id.compute_button);
        computeBtn.setOnClickListener(buttonClickListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "The activity returned with result " + intent.getStringExtra("total"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView allTerms = (TextView)findViewById(R.id.all_term_text);
        savedInstanceState.putString("all_terms", allTerms.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView allTerms = (TextView)findViewById(R.id.all_term_text);
        if (savedInstanceState.getString("all_terms") != null) {
            allTerms.setText(savedInstanceState.getString("all_terms"));
        }
    }
}
