package com.school42.malaga.avaj;

import java.io.*;

public class SimulatorWriter implements AutoCloseable {
    private static final String filename  = "simulation.txt";
    private PrintStream file;
    public SimulatorWriter() throws FileNotFoundException {
        file = new PrintStream(new FileOutputStream(filename, false));
    }

    public PrintStream getStream(){
        return this.file;
    }

    @Override
    public void close() throws Exception {
        file.close();
    }
}
