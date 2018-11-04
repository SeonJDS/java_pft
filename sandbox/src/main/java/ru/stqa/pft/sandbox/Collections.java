package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void  main(String[] args) {
        String[] langs = {"Jsva", "C#", "Python", "PHP"};

        List<String> languages = Arrays.asList("Jsva", "C#", "Python", "PHP");

        for (String l : languages) {
            System.out.println("Я хочу выучить " + l);
        }
    }
}
