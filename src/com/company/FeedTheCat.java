package com.company;

import java.util.List;
import java.util.Scanner;

public class FeedTheCat implements Event {

    public FeedTheCat(List<Animal> cats) {
    }

    @Override
    public void doEvent(List<Animal> cats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cat name: ");
        String choice = sc.nextLine();
        for (Animal cat : cats) {
            if (cat.getName().equalsIgnoreCase(choice)) {
                if (cat.getYear() <= 5) {
                    cat.setSatietyLevel(cat.getSatietyLevel() + 7);
                    cat.setMoodLevel(cat.getMoodLevel() + 7);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                } else if (cat.getYear() >= 6 & cat.getYear() <= 10) {
                    cat.setSatietyLevel(cat.getSatietyLevel() + 5);
                    cat.setMoodLevel(cat.getMoodLevel() + 5);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                } else {
                    cat.setSatietyLevel(cat.getSatietyLevel() + 4);
                    cat.setMoodLevel(cat.getMoodLevel() + 4);
                    System.out.printf("You played with the cat %s, %s years old \n", cat.getName(), cat.getYear());
                }
            }
        }
    }
}
