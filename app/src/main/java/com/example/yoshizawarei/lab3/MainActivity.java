package com.example.yoshizawarei.lab3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner movies_spinner = (Spinner)findViewById(R.id.movies_spinner);
        final TextView movies_text = (TextView)findViewById(R.id.movies_text);
        final ImageView movies_image = (ImageView)findViewById(R.id.movies_image);
        final String [] files = {"catch_me_if_you_can", "flight_club", "forrest_gump", "the_godfather", "good_will_hunting",
                           "pulp_fiction", "the_hangover", "the_shawshank_redemption", "titanic"};
        movies_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < position + 1; i++) {
                    int img = getResources().getIdentifier(files[i], "drawable", getPackageName());
                    int text = getResources().getIdentifier(files[i], "raw", getPackageName());
                    movies_image.setImageResource(img);

                    final Scanner scan = new Scanner(getResources().openRawResource(text)); // R.raw.
                    String allText = "";
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        allText += line;
                    }
                    movies_text.setText(allText);
                    scan.close();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
