package com.example.diceroller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    @SuppressLint("SetTextI18n")
    public void on_button_click(View view) {
        TextView tv = this.findViewById(R.id.textView);
        Random r = new Random();
        int number = r.nextInt(7 - 1) + 1;

        tv.setText(Integer.toString(number));

        TextView congrat = this.findViewById(R.id.congrat);
        TextView userNum = this.findViewById(R.id.userNum);

        int n = Integer.parseInt(userNum.getText().toString());

        if (n < 1 || n > 6) {
            Toast.makeText(this, "Invalid Input Number", Toast.LENGTH_SHORT).show();

        } else if (n == number) {


            Toast.makeText(this, "Congratulations, You guessed the number", Toast.LENGTH_SHORT).show();
            this.counter++;
            TextView scoreCard = this.findViewById(R.id.userScore);
            scoreCard.setText("Your Score:" + counter);
        }

    }

    public void on_click_button_2(View view) {

        ArrayList<String> questions = new ArrayList<>();
        {
            questions.add("If you could go anywhere in the world, where would you go?");
            questions.add("If you were stranded on a desert island, what three things would you want to take with you?");
            questions.add("If you could eat only one food for the rest of your life, what would that be?");
            questions.add("If you won a million dollars, what is the first thing you would buy?");
            questions.add("If you could spaned the day with one fictional character, who would it be?");
            questions.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");


            TextView diceView = this.findViewById(R.id.randomElement);
            Random rand = new Random();
            int randomIndex = rand.nextInt(questions.size());


            int numberOfElements = questions.size();

            {
                for (int i = 1; i <= numberOfElements; i++) {

                    if (i == randomIndex) {
                       String value = questions.get(randomIndex);
                        diceView.setText(value);
                    }

                }
            }
        }
    }
}




