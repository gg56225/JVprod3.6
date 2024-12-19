package org.example;

public class Main {
    public static void main(String[] args) {
        int totalGames = 1000;
        MontyHallSimulation simulation = new MontyHallSimulation(totalGames);
        simulation.runSimulation();
        simulation.printStatistics();
    }
}
