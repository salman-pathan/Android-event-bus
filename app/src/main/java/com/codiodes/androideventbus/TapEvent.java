package com.codiodes.androideventbus;

import java.util.Date;

/**
 * Created by Salman Khan on 04/05/16.
 */
public class TapEvent {
    private String sender;
    private Date date;

    public TapEvent(String sender, Date date) {
        this.sender = sender;
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public Date getDate() {
        return date;
    }
}
