package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox OneWay;
    CheckBox RoundTrip;
    Button Plus;
    Button Minus;
    Button Submit;
    TextView Pax;
    int pax = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OneWay=findViewById(R.id.checkBoxOneWay);
        RoundTrip=findViewById(R.id.checkBoxRoundTrip);
        Plus=findViewById(R.id.buttonPlus);
        Minus=findViewById(R.id.buttonMinus);
        Pax=findViewById(R.id.textViewPax);
        Submit=findViewById(R.id.buttonSubmit);



        Intent intent = new Intent(getBaseContext(), FlightDetails.class);
        intent.putExtra("pax", pax);

        String People = Integer.toString(pax);
        Pax.setText(People);

        if(OneWay.isChecked()&& RoundTrip.isChecked()){
            Toast.makeText(MainActivity.this,"Only select either One Way or Round Trip",
                    Toast.LENGTH_SHORT).show();
        }
        if(pax <0){
            Toast.makeText(MainActivity.this,"Amount of people cannot be less than 0",
                    Toast.LENGTH_SHORT).show();
        }

        OneWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FlightDetails.class);
                intent.putExtra("trip", "One Way Trip");
            }
        });

        RoundTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FlightDetails.class);
                intent.putExtra("trip", "Round Trip");
            }
        });
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pax= pax +1;
            }
        });

        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pax= pax -1;
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), FlightDetails.class);
                startActivity(intent);
            }
        });







    }

}
