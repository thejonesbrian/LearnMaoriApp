package com.brian.learnmaoriapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView cardNumbers = (CardView) findViewById(R.id.card_learn_numbers);
        cardNumbers.setOnClickListener(CardNumbersHandler);
        CardView cardFamily = (CardView) findViewById(R.id.card_family_names);
        cardFamily.setOnClickListener(CardFamilyHandler);
        CardView cardColour = (CardView) findViewById(R.id.card_learn_colours);
        cardColour.setOnClickListener(CardColourHandler);

        Toast.makeText(getBaseContext(),"Welcome: choose an option",Toast.LENGTH_LONG).show();

    }
    View.OnClickListener CardNumbersHandler = new View.OnClickListener(){
        public void onClick(View view){
            Intent numbersActivity = new Intent(getBaseContext(),NumbersActivity.class).putExtra(Intent.EXTRA_TEXT,"Play for Māori translations of numbers.");
            startActivity(numbersActivity);
        }
    };
    View.OnClickListener CardFamilyHandler = new View.OnClickListener(){
        public void onClick(View view){
            Intent familyActivity = new Intent(getBaseContext(),FamilyMembersActivity.class).putExtra(Intent.EXTRA_TEXT,"Play for Māori translation of family members.");
            startActivity(familyActivity);
        }
    };
    View.OnClickListener CardColourHandler = new View.OnClickListener(){
        public void onClick(View view){
            Intent coloursActivity = new Intent(getBaseContext(),ColoursActivity.class).putExtra(Intent.EXTRA_TEXT,"Play to hear Māori translation of colors.");
            startActivity(coloursActivity);
        }
    };

    public void ShowNumbersActivity(View view){
        Intent numbersActivity = new Intent(this, NumbersActivity.class);
        startActivity(numbersActivity);
    }
}
