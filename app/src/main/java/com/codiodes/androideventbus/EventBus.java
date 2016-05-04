package com.codiodes.androideventbus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Salman Khan on 04/05/16.
 */
public class EventBus {

    private final Subject<Object, Object> mBus = new SerializedSubject<>(PublishSubject.create());

    /**
     * Sends event.
     * @param object Object to be emitted.
     */
    public void send(Object object) {
        mBus.onNext(object);
    }


    public Observable<Object> toObservable() {
        return mBus;
    }

    /**
     * Checks if there is any active observer or not.
     * @return Returns true if there is active observer and false otherwise.
     */
    public boolean hasObservers() {
        return mBus.hasObservers();
    }

}
