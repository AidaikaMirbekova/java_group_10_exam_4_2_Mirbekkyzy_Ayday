package com.company;

import java.util.List;
import java.util.Scanner;

public class PlayWithTheCat implements Event{
    public PlayWithTheCat(List<Animal> cats) {
    }

    @Override
    public void doEvent(List<Animal> cats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cat name: ");
        String choice = sc.nextLine();
        for (Animal cat : cats) {
            if (cat.getName().equalsIgnoreCase(choice)) {
                if (cat.getYear() <= 5) {
                    cat.setHealthLevel(cat.getHealthLevel() + 7);
                    cat.setMoodLevel(cat.getMoodLevel() + 7);
                    cat.setSatietyLevel(cat.getSatietyLevel()-3);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                } else if (cat.getYear() >= 6 & cat.getYear() <= 10) {
                    cat.setHealthLevel(cat.getHealthLevel() + 5);
                    cat.setMoodLevel(cat.getMoodLevel() + 5);
                    cat.setSatietyLevel(cat.getSatietyLevel()-5);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                } else {
                    cat.setSatietyLevel(cat.getSatietyLevel() + 4);
                    cat.setMoodLevel(cat.getMoodLevel() + 4);
                    cat.setSatietyLevel(cat.getSatietyLevel()-6);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                }
            }
        }
    }
}
