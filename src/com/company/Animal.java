package com.company;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Animal {
    private static final Random rnd=new Random();
    private static final List<String> names = List.of("Peach", "Ginger", "Toby", "Seth", "Tibbles", "Tabby", "Poppy", "Millie", "Daisy", "Jasper", "Misty", "Minka");
    private final String name;
    private int year;
    private  int satietyLevel;
    private  int moodLevel;
    private  int healthLevel;
    private  int averageLevel;

    public Animal() {
        this.name = names.get(rnd.nextInt(names.size()));
        this.year = rnd.nextInt(18)+1;
        this.satietyLevel = rnd.nextInt(100)+1;
        this.moodLevel = rnd.nextInt(100)+1;
        this.healthLevel = rnd.nextInt(100)+1;
        this.averageLevel=(healthLevel+moodLevel+satietyLevel)/3;
    }

    public Animal(Scanner sc){
        System.out.println("Enter the name: ");
        this.name = sc.nextLine();
        System.out.println("Enter the age: ");
        this.year = sc.nextInt();
        this.satietyLevel = rnd.nextInt(61)+20;
        this.moodLevel = rnd.nextInt(61)+20;
        this.healthLevel = rnd.nextInt(61)+20;
        this.averageLevel=(healthLevel+moodLevel+satietyLevel)/3;

    }

    public static final List<Animal> makeCats(int amount) {
        return Stream.generate(Animal::new)
                .limit(amount)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getSatietyLevel() {
        return satietyLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public int getAverageLevel() {
        return averageLevel;
    }


    public void setSatietyLevel(int satietyLevel) {
        this.satietyLevel = satietyLevel;
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = moodLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public void setAverageLevel(int averageLevel) {
        this.averageLevel = averageLevel;
    }

}
