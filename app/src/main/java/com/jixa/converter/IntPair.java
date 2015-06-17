package com.jixa.converter;


public class IntPair {
    private int firstVal;
    private int socondVal;

    public IntPair(int firstVal, int socondVal) {
        this.firstVal = firstVal;
        this.socondVal = socondVal;
    }

    public int getFirstVal() {
        return firstVal;
    }

    public void setFirstVal(int firstVal) {
        this.firstVal = firstVal;
    }

    public int getSocondVal() {
        return socondVal;
    }

    public void setSocondVal(int socondVal) {
        this.socondVal = socondVal;
    }

    @Override
    public String toString(){
        return "VALUES: " +firstVal + "  --  " + socondVal;
    }
}
