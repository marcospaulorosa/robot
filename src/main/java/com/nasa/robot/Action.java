package com.nasa.robot;

public enum Action {

    LEFT("L", 90),
    RIGHT("R", 90),
    MOVE("M", 0);

    private String desctiption;
    private int degree;

    private Action(String decription, int degree) {
        this.setDesctiption(decription);
        this.setDegree(degree);
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

}
