package com.gomspace.infiniteGrid.data;

import com.gomspace.infiniteGrid.constants.Direction;

public class Machine {

    private Cell currentLocation;

    private Direction currentDirection;

    public Cell getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Cell currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public char getSymbol(){

        switch (this.currentDirection) {
            case DOWN:
                return 0x2193;
            case UP:
                return 0x2191;
            case LEFT:
                return 0x2190;
            case RIGHT:
                return 0x2192;
            default:
                return ' ';
        }
    }
}
