package com.gomspace.infiniteGrid.data;

import com.gomspace.infiniteGrid.constants.Color;

import java.util.HashSet;
import java.util.Set;

public class BlackAndWhiteGrid {

    private Set<Cell> blackCells;

    private int minX;
    private int maxX;
    private int minY;
    private int maxY;


    public Set<Cell> getBlackCells() {
        if(blackCells == null) {
            blackCells = new HashSet<>();
        }
        return blackCells;
    }

    public void addCell(final Cell cell) {

        if (cell.getColor() == Color.WHITE) {
            this.getBlackCells().remove(cell);
        }else {
            this.getBlackCells().add(cell);
        }
    }

    public void calculateBounds(final Cell currentLocation) {
        this.getBlackCells().stream().forEach(c -> {

            if (c.getPosX() < this.minX){
                this.minX = c.getPosX();
            }
            if (c.getPosX() > this.maxX){
                this.maxX = c.getPosX();
            }
            if (c.getPosY() < this.minY){
                this.minY = c.getPosY();
            }
            if (c.getPosY() > this.maxY){
                this.maxY = c.getPosY();
            }
        });

        if (currentLocation.getPosX() < this.minX){
            this.minX = currentLocation.getPosX();
        }
        if (currentLocation.getPosX() > this.maxX){
            this.maxX = currentLocation.getPosX();
        }
        if (currentLocation.getPosY() < this.minY){
            this.minY = currentLocation.getPosY();
        }
        if (currentLocation.getPosY() > this.maxY){
            this.maxY = currentLocation.getPosY();
        }
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
