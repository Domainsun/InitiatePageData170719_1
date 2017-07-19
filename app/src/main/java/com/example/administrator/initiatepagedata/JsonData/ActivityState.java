package com.example.administrator.initiatepagedata.JsonData;

/**
 * Created by Administrator on 2017/5/4.
 */

public enum ActivityState {


    activated( 1 ), inactive( 2 ), ongoing( 3 ),saved(4),notapproved(5),submitted(6) {
        @Override
        public boolean isRest() {
            return true ;
        }
    };

    private int value;
    private ActivityState( int value) {
        this .value = value;
    }
    public int getValue() {
        return value;
    }
    public boolean isRest() {
        return false ;
    }
}
