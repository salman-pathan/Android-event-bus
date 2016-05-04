package com.codiodes.androideventbus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;

import rx.subscriptions.CompositeSubscription;


/**
 * A simple {@link Fragment} subclass.
 */
public class IncrementScoreFragment extends Fragment {

    private EventBus mBus;
    private Button mBtnIncrementScore;

    public IncrementScoreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_increment_score, container, false);
        mBtnIncrementScore = (Button) view.findViewById(R.id.btn_increment_score);
        mBtnIncrementScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TapEvent event = new TapEvent(IncrementScoreFragment.class.getSimpleName(), new Date());
                mBus.send(event);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBus = EventBusApplication.getEventBus();
    }

}
