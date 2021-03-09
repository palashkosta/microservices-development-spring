package com.learning.microservices.limitservice.models;

public class Limits {

    private int maximun;
    private int minimum;

    public Limits() {

    }

    public Limits(int maximun, int minimum) {
        this.maximun = maximun;
        this.minimum = minimum;
    }
    
    public int getMaximun() {
        return maximun;
    }
    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }
    public int getMinimum() {
        return minimum;
    }
    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
    @Override
    public String toString() {
        return "Limits [maximun=" + maximun + ", minimum=" + minimum + "]";
    }

    
}
