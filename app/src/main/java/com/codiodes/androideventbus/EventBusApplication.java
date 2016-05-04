package com.codiodes.androideventbus;

import android.app.Application;

/**
 * Created by Salman Khan on 04/05/16.
 */
public class EventBusApplication extends Application {

    private static EventBus mBus;

    /**
     * Singleton instance of Event Bus.
     * @return Event Bus
     */
    public static EventBus getEventBus() {
        if (mBus == null) {
            mBus = new EventBus();
        }
        return mBus;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
