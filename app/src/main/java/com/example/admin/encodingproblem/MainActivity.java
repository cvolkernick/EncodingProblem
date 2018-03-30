package com.example.admin.encodingproblem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText = findViewById(R.id.tvText);
        tvText.setText(f("Errors in strategy cannot be correct through tactical maneuvers"));

        TextView tvText2 = findViewById(R.id.tvText2);
        tvText2.setText(alphaCountString(g("Hello there! Apple!")));
    }

    private String alphaCountString(int[] countArray) {
        String countString = "{ \n";
        for (int i = 0; i < 26; i++) {
            countString = countString + "\t" + alpha.charAt(i) + ": " + countArray[i];

            if (i != 26) {
                countString = countString + ",";
            }

            countString = countString + "\n";
        }

        countString = countString + "}";

        return countString;
    }

    private String f(String unencoded){
        String alphaReversed = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String encoded = "";

        int position;
        char nextChar;
        for (char c : unencoded.toUpperCase().toCharArray()) {
            if (alpha.contains(c+"")) {
                position = alpha.indexOf(c);
                nextChar = alphaReversed.charAt(position);
            }
            else {
                nextChar = c;
            }

            encoded = encoded + nextChar;
        }

        return encoded;
    }

    private int[] g(String countedString) {
        int[] countArray = new int[26];

        for (int i = 0; i < 26; i++) {
            int currentCount = 0;
            for (int j = 0; j < countedString.length(); j++) {
                if (countedString.toUpperCase().charAt(j) == alpha.charAt(i)) {
                    currentCount++;
                }
            }

            countArray[i] = currentCount;
        }

        return countArray;
    }
}
