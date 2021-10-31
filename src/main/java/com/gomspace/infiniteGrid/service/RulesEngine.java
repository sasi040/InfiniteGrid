package com.gomspace.infiniteGrid.service;

import com.gomspace.infiniteGrid.constants.Color;
import com.gomspace.infiniteGrid.constants.Direction;
import com.gomspace.infiniteGrid.data.Cell;

public interface RulesEngine {

    Direction getNextDirection(final Color color, final Direction direction);

    Cell getNextCell(final Direction direction, final Cell currentCell);
}
