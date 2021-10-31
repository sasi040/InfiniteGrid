package com.gomspace.infiniteGrid.service;

import com.gomspace.infiniteGrid.constants.Direction;
import com.gomspace.infiniteGrid.data.Cell;
import com.gomspace.infiniteGrid.data.BlackAndWhiteGrid;
import com.gomspace.infiniteGrid.data.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NavigatorService {

    private RulesEngine engine;

    @Autowired
    public NavigatorService( final RulesEngine engine) {
        this.engine = engine;
    }

    public void move(final Machine machine, final BlackAndWhiteGrid grid) {

        final Direction direction = engine.getNextDirection(machine.getCurrentLocation().getColor(), machine.getCurrentDirection());

        final Cell nextCell = engine.getNextCell(direction, machine.getCurrentLocation());

        machine.setCurrentDirection(direction);

        machine.getCurrentLocation().toggleColor();
        grid.addCell(machine.getCurrentLocation());

        grid.getBlackCells().stream().filter(nextCell::equals).findFirst()
                .ifPresentOrElse(machine::setCurrentLocation, () -> machine.setCurrentLocation(nextCell));
    }
}
