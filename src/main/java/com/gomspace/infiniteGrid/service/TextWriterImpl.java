package com.gomspace.infiniteGrid.service;

import com.gomspace.infiniteGrid.constants.Color;
import com.gomspace.infiniteGrid.data.BlackAndWhiteGrid;
import com.gomspace.infiniteGrid.data.Cell;
import com.gomspace.infiniteGrid.data.Machine;
import com.gomspace.infiniteGrid.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.UUID;

@Service
public class TextWriterImpl implements GridWriter{

    public static final char WHITE_CELL = '_';
    public static final char BLACK_CELL = '#';
    public static final char MACHINE_POS = '@';
    private char [][] finiteGrid;

    private int rows;
    private int cols;

    @Value("${filesPath}")
    private Path fileDir;

    @Override
    public void constructGrid(final BlackAndWhiteGrid grid, final Machine machine) {

        this.rows = grid.getMaxX() - grid.getMinX()+1;
        this.cols = grid.getMaxY() - grid.getMinY()+1;

        this.finiteGrid = new char[rows][cols];

        for (int i =0;i<rows;i++) {

            for (int j =0;j<cols;j++) {
                finiteGrid[i][j] = WHITE_CELL;
            }
        }

        int offsetX = grid.getMinX();
        int offsetY = grid.getMinY();

        grid.getBlackCells().stream().filter(c -> c.getColor() == Color.BLACK)
                .forEach(c -> {
                    this.finiteGrid[c.getPosX() - offsetX]
                            [c.getPosY() - offsetY] = BLACK_CELL;
                });
        this.finiteGrid[machine.getCurrentLocation().getPosX() - offsetX]
                [machine.getCurrentLocation().getPosY() - offsetY] = machine.getSymbol();
    }

    @Override
    public String writeIntoFile() {

        // Arrange the grid to match with traversal of the machine.
        final StringBuilder sb = new StringBuilder();
        final char [] [] temp = new char[cols][rows];

        try {
            for (int j = cols-1,k=0;j>=0&&k<cols;j--,k++){

                for (int i=0,l=0;i<rows&&l<rows;i++,l++){
                    temp[k][l] = this.finiteGrid[i][j];
                }
            }

            for (int i=0; i<cols;i++) {

                for (int j=0; j < rows; j++) {
                    sb.append(temp[i][j] + " ");
                }
                sb.append("\n");
            }

            final Path filePath = fileDir.resolve(UUID.randomUUID()+".txt");
            Files.createFile(filePath);

            Files.write(filePath, Collections.singleton(sb.toString()), StandardOpenOption.WRITE);

            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ApplicationException("Exception while writing grid to a text file!");
        }
    }

}
