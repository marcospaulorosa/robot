package com.nasa.robot;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RobotController {

    Robot robot;

    public RobotController() {
        robot = new Robot();
    }

    @RequestMapping(value = "/robot/action/{actions}", method = RequestMethod.POST)
    public String welcomepage(@PathVariable String actions) {
        processAction(actions);
        return "Actual position: " + robot.toString();
    }

    private String processAction(String actions) {
        validateCommands(actions);
        return null;
    }

    private void validateCommands(String actions) {
        String[] commands = actions.split("");
        for (String command : commands) {
            switch (command.toUpperCase()) {
                case "M":
                    move();
                    break;
                case "L":
                    turn(Action.LEFT);
                    break;
                case "R":
                    turn(Action.RIGHT);
                    break;
                default:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
    }

    private void turn(Action action) {
        int newDegree = 0;
        int actualDegree = robot.getDirection().getDegree();
        if (action == Action.LEFT) {
            actualDegree = actualDegree == 0 ? 360 : actualDegree;
            newDegree = (actualDegree - action.getDegree());
        } else if (action == Action.RIGHT) {
            newDegree = actualDegree + action.getDegree();
            if (newDegree == 360) {
                newDegree = 0;
            }
        }
        robot.turn(newDegree);
    }

    private void move() {
        if (canMove()) {
            switch (robot.getDirection()) {
                case NORTH:
                    robot.setPositionY(robot.getPositionY() + 1);
                    break;
                case SOUTH:
                    robot.setPositionY(robot.getPositionY() - 1);
                    break;
                case EAST:
                    robot.setPositionX(robot.getPositionX() + 1);
                    break;
                case WEST:
                    robot.setPositionX(robot.getPositionX() - 1);
                    break;
                default:
                    break;
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public boolean canMove() {
        return (robot.getDirection() == Direction.NORTH && robot.getPositionY() != 4) //
               || (robot.getDirection() == Direction.SOUTH && robot.getPositionY() != 0) //
               || (robot.getDirection() == Direction.EAST && robot.getPositionX() != 4) //
               || (robot.getDirection() == Direction.WEST && robot.getPositionX() != 0); //
    }

}
