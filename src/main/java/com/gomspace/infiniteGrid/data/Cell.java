package com.gomspace.infiniteGrid.data;

import com.gomspace.infiniteGrid.constants.Color;

public class Cell {

    private int posX;
    private int posY;
    private Color color;

    public Cell() {
        this.color = Color.WHITE;
        this.posX = 0;
        this.posY = 0;
    }

    public Cell(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.color = Color.WHITE;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void toggleColor(){
        if (this.color == Color.BLACK)
            this.color = Color.WHITE;
        else
            this.color = Color.BLACK;
    }

    @Override
    public int hashCode(){
        return this.posX * 31 + this.posY * 29;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }

        if (!( o instanceof Cell)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        final Cell other = (Cell)o;

        return this.posX == other.posX && this.posY == other.posY;
    }

    @Override
    public String toString(){

        return new StringBuilder().append("Position x: ").append(this.posX)
                .append("---Position y: ").append(this.posY)
                .append("---Color: ").append(this.color).toString();
    }
}
