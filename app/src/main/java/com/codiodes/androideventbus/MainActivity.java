package com.codiodes.androideventbus;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            TotalScoreFragment totalScoreFragment = new TotalScoreFragment();
            IncrementScoreFragment incrementScoreFragment = new IncrementScoreFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.total_score_fragment_container, totalScoreFragment);
            fragmentTransaction.add(R.id.increment_score_fragment_container, incrementScoreFragment);
            fragmentTransaction.commit();
        }

    }
}
