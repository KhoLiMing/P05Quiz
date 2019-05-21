package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FlightDetails extends AppCompatActivity {

    TextView Trip;
    TextView Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        Trip=findViewById(R.id.textViewTrip);
        Price=findViewById(R.id.textViewPrice);

        Intent intentReceived = getIntent();
        String trip = intentReceived.getStringExtra("trip");
        Trip.setText("You have selected : " +  trip);

        int pax = intentReceived.getIntExtra("pax", 0);
        int price= pax * 200;
        Price.setText("Your air ticket costs " + price);
    }
}
