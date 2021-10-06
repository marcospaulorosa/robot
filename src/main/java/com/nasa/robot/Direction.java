package com.nasa.robot;

public enum Direction {

    NORTH("N", "North", 0),
    SOUTH("S", "South", 180),
    EAST("E", "East", 90),
    WEST("W", "West", 270);

    private String letter;
    private String description;
    private int degree;

    private Direction(String letter, String description, int degree) {
        this.setLetter(letter);
        this.setDescription(description);
        this.setDegree(degree);
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setDirection(int degree) {

    }

    public Direction getDirectionByDegree(int degree) {
        for (Direction direction : values()) {
            if (direction.getDegree() == degree) {
                return direction;
            }
        }
        return null;
    }

    public int getDegreeByDirection(Direction actualDirection) {
        for (Direction direction : values()) {
            if (direction == actualDirection) {
                return direction.getDegree();
            }
        }
        return -1;
    }

}
