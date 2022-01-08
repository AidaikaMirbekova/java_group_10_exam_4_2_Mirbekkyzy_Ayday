package com.company;

import java.util.List;
import java.util.Random;

public class NextDay implements Event{
    public NextDay(List<Animal> cats) {
    }

    @Override
    public void doEvent(List<Animal> cats) {
        Random rnd=new Random();
        System.out.println("New day has begun! ");
        for (Animal cat : cats) {
                    cat.setHealthLevel(cat.getHealthLevel() - rnd.nextInt(7)-3);
                    cat.setMoodLevel(cat.getMoodLevel() + rnd.nextInt(7)-3);
                    cat.setSatietyLevel(cat.getSatietyLevel()-rnd.nextInt(5)+1);
        }
    }
}
