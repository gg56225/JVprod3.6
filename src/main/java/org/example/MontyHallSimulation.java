package org.example;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Data
public class MontyHallSimulation {
    private int totalGames;
    private int switchWins;
    private int stayWins;
    private Map<Integer, Boolean> results;

    public MontyHallSimulation(int totalGames) {
        this.totalGames = totalGames;
        this.switchWins = 0;
        this.stayWins = 0;
        this.results = new HashMap<>();
    }

    public void runSimulation() {
        Random random = new Random();
        for (int i = 1; i <= totalGames; i++) {
            int winningDoor = random.nextInt(3);
            int chosenDoor = random.nextInt(3);

            // Host opens a door that is not the winning door and not the chosen door
            int openedDoor;
            do {
                openedDoor = random.nextInt(3);
            } while (openedDoor == winningDoor || openedDoor == chosenDoor);

            // Simulate switching
            int switchedDoor = 3 - chosenDoor - openedDoor;
            if (switchedDoor == winningDoor) {
                switchWins++;
                results.put(i, true);
            } else {
                stayWins++;
                results.put(i, false);
            }
        }
    }

    public void printStatistics() {
        System.out.println("Total games: " + totalGames);
        System.out.println("Switch wins: " + switchWins);
        System.out.println("Stay wins: " + stayWins);
        System.out.println("Switch win percentage: " + (switchWins * 100.0 / totalGames) + "%");
        System.out.println("Stay win percentage: " + (stayWins * 100.0 / totalGames) + "%");
    }
}
