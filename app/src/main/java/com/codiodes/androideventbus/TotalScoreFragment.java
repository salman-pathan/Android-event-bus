package com.codiodes.androideventbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

public class TotalScoreFragment extends Fragment {

    private EventBus mBus;
    private CompositeSubscription mSubscription;
    private static int mScore;
    private TextView mTxtScore;

    public TotalScoreFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_total_score, container, false);
        mTxtScore = (TextView) view.findViewById(R.id.total_score);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBus = EventBusApplication.getEventBus();
        mSubscription = new CompositeSubscription();
        mSubscription.add(
                mBus.toObservable()
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        if (o instanceof TapEvent) {
                            mScore++;
                            mTxtScore.setText(String.valueOf(mScore));
                        }
                    }
                })
        );
    }
}
