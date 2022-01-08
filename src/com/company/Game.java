package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private static Event events;


    public  static void showSimulation(List<Animal> cats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the choice:" +
                "\n1 - Sorted by name of the cat." +
                "\n2 - Sorted by age of the cat." +
                "\n3 - Sorted by health level of the cat." +
                "\n4 - Sorted by mood level of the cat." +
                "\n5 - Sorted by satiety level of the cat." +
                "\n6 - Sorted by average level of the cat.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                sortedByName(cats);
                showAction(cats);
                break;
            case 2:
                sortedByAge(cats);
                showAction(cats);
                break;
            case 3:
                sortedByHealth(cats);
                showAction(cats);
                break;
            case 4:
                sortedByMood(cats);
                showAction(cats);
                break;
            case 5:
                sortedBySatiety(cats);
                showAction(cats);
                break;
            case 6:
                sortedByAverageLevel(cats);
                showAction(cats);
                break;
        }
        showSimulation(cats);
    }

    public  static void showAction(List<Animal> cats) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the choice:" +
                "\n1 - Add a new cat." +
                "\n2 - Feed the cat."+
                "\n3 - Play with the cat."+
                "\n4 - Treat the cat." +
                "\n5 - Next day.");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                enterCat(cats);
                break;
            case 2:
                selectEventFeedTheCat(cats);
                break;
            case 3:
                selectEventTreatTheCat(cats);
                break;
            case 4:
                selectEventPlayWithTheCat(cats);
                break;
            case 5:
                nextDay(cats);
                break;
        }
        showAction(cats);
    }

    public static void sortedByName(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getName).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);

    }

    public static void sortedByAge(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getYear).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void sortedByHealth(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getHealthLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void sortedByMood(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getMoodLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void sortedBySatiety(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getSatietyLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void sortedByAverageLevel(List<Animal> cats){
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void enterCat(List<Animal> cats){
        Scanner sc = new Scanner(System.in);
        cats.add(new Animal(sc));
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void selectEventFeedTheCat(List<Animal> cats){
        Random rnd=new Random();
        int rand= rnd.nextInt(10);
        if (rand<5) {
            events = new FeedTheCat(cats);
            events.doEvent(cats);
        }else {
            events = new Poisoning(cats);
            events.doEvent(cats);
        }
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
        cats.removeIf(cat-> cat.getYear() <= 0);
        Printer.print(cats);

    }

    public static void selectEventPlayWithTheCat(List<Animal> cats){
        Random rnd=new Random();
        int rand= rnd.nextInt(10);
        if (rand<5) {
        events = new PlayWithTheCat(cats);
        events.doEvent(cats);
        }else {
            events = new Trauma(cats);
            events.doEvent(cats);
        }
         var newSort =cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSort);


    }

    public static void selectEventTreatTheCat(List<Animal> cats){
        events = new TreatTheCat(cats);
        events.doEvent(cats);
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

    public static void nextDay(List<Animal> cats){
        events = new NextDay(cats);
        events.doEvent(cats);
        var newSortedCats = cats.stream()
                .sorted(Comparator.comparing(Animal::getAverageLevel).reversed())
                .collect(Collectors.toList());
        Printer.print(newSortedCats);
    }

}

