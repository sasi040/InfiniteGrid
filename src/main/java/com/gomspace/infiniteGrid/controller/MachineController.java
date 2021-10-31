package com.gomspace.infiniteGrid.controller;


import com.gomspace.infiniteGrid.constants.Direction;
import com.gomspace.infiniteGrid.data.BlackAndWhiteGrid;
import com.gomspace.infiniteGrid.data.Cell;
import com.gomspace.infiniteGrid.data.Machine;
import com.gomspace.infiniteGrid.service.GridWriter;
import com.gomspace.infiniteGrid.service.NavigatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/navigate")
public class MachineController {

    @Autowired
    NavigatorService service;

    @Autowired
    GridWriter writer;

    @PutMapping(path = "/{steps}")
    public String play(@PathVariable int steps) {

        final Machine machine = new Machine();
        machine.setCurrentLocation(new Cell());
        machine.setCurrentDirection(Direction.RIGHT);

        final BlackAndWhiteGrid grid = new BlackAndWhiteGrid();

        for (int i=0; i<steps;i++) {

            service.move(machine, grid);
        }
        grid.addCell(machine.getCurrentLocation());

        grid.calculateBounds(machine.getCurrentLocation());

        writer.constructGrid(grid, machine);
        return writer.writeIntoFile();
    }
}
