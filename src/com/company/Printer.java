package com.company;

import java.util.List;

public class Printer {
    private static final void printHeader() {
        System.out.println(String.format("%1$10.10s + %1$10.10s + %1$-10.10s + %1$-10.10s + %1$10.10s + %1$15.15s +", "--------------"));
        System.out.println(String.format("%10.10s | %10.10s | %10.10s | %10.10s | %10.10s | %15.15s |", "Name", "Age", "Health", "Mood", "Satiety", "Average level"));
        System.out.println(String.format("%1$10.10s + %1$10.10s + %1$10.10s + %1$10.10s + %1$10.10s + %1$15.15s +", "--------------"));
    }

    private static final void printCat(Animal cat) {
        System.out.println(String.format("%10s | %10s | %10s | %10s | %10s | %15s |",cat.getName(),cat.getYear(), cat.getHealthLevel(), cat.getMoodLevel(), cat.getSatietyLevel(), cat.getAverageLevel()));
    }

    public static final void print(List<Animal> cats) {
        printHeader();
        cats.forEach(Printer::printCat);
        System.out.println();
    }
}
