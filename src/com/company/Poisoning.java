package com.company;

import java.util.List;
import java.util.Scanner;

public class Poisoning implements Event {
    public Poisoning(List<Animal> cats) {
    }

    @Override
    public void doEvent(List<Animal> cats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the cat name: ");
        String choice = sc.nextLine();
        for (Animal cat : cats) {
            if (cat.getName().equalsIgnoreCase(choice)) {
                cat.setHealthLevel(cat.getHealthLevel() - 20);
                cat.setMoodLevel(cat.getMoodLevel() - 30);
            }
        }
        System.out.println("Sad=( Cat poisoned!!!");
    }
}
