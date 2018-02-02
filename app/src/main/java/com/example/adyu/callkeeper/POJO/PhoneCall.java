package com.example.adyu.callkeeper.POJO;

import java.util.Date;



public class PhoneCall {
    private String type, number;
    private Date start, end;



    public PhoneCall(String type, String number, Date start, Date end) {
        this.type = type;
        this.number = number;
        this.start = start;
        this.end = end;
    }
    @Override
    public String toString() {
        return "PhoneCall{" +
                "type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
