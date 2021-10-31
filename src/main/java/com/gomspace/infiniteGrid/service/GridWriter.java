package com.gomspace.infiniteGrid.service;

import com.gomspace.infiniteGrid.data.BlackAndWhiteGrid;
import com.gomspace.infiniteGrid.data.Machine;

public interface GridWriter {

    void constructGrid(final BlackAndWhiteGrid grid, final Machine machine);

    String writeIntoFile();

}
