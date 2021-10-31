package com.gomspace.infiniteGrid.service;

import com.gomspace.infiniteGrid.constants.Color;
import com.gomspace.infiniteGrid.constants.Direction;
import com.gomspace.infiniteGrid.data.Cell;
import org.springframework.stereotype.Service;

@Service
public class InfiniteGridRulesEngineImpl implements RulesEngine {

    @Override
    public Direction getNextDirection(final Color color, final Direction direction) {

        if (color == Color.WHITE) {

            switch(direction) {
                case RIGHT:
                    return Direction.DOWN;
                case DOWN:
                    return Direction.LEFT;
                case UP:
                    return Direction.RIGHT;
                case LEFT:
                    return Direction.UP;
            }

        }else if (color == Color.BLACK){
            switch(direction) {
                case RIGHT:
                    return Direction.UP;
                case DOWN:
                    return Direction.RIGHT;
                case UP:
                    return Direction.LEFT;
                case LEFT:
                    return Direction.DOWN;
            }
        }
        throw new IllegalArgumentException("Illegal Color received!");
    }

    @Override
    public Cell getNextCell(final Direction direction, final Cell currentCell){

        switch(direction) {
            case UP:
                return new Cell(currentCell.getPosX(), currentCell.getPosY()+1);
            case DOWN:
                return new Cell(currentCell.getPosX(), currentCell.getPosY()-1);
            case RIGHT:
                return new Cell(currentCell.getPosX()+1, currentCell.getPosY());
            case LEFT:
                return new Cell(currentCell.getPosX()-1, currentCell.getPosY());
            default:
                throw new IllegalArgumentException("Illegal Direction received!");
        }

    }
}
