package com.nasa.robot;

import lombok.Data;

@Data
public class Robot {

    private int positionX;
    private int positionY;
    private Direction direction;

    public Robot() {
        this.positionX = 0;
        this.positionY = 0;
        this.direction = Direction.NORTH;
    }

    public void turn(int degree) {
        direction = direction.getDirectionByDegree(degree);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %s)", positionX, positionY, direction.getLetter());
    }

    /*
    public static void main(String[] args) {
        Robot r = new Robot();
        Direction d = r.getDirection();
        System.out.println(d);
        //turning
        int t = d.getDegreeByDirection(d);
        t = t + 270;
        System.out.println();
    
        d = d.getDirectionByDegree(t);
        System.out.println(d);
    }
    */

}
