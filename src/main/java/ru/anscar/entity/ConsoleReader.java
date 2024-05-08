package ru.anscar.entity;

import java.io.Serializable;
import java.util.Scanner;

public class ConsoleReader implements Serializable {
    private static Scanner INSTANCE;

    public synchronized static Scanner getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Scanner(System.in);
        }
        return INSTANCE;
    }

    public static void closeConsole(){
        INSTANCE.close();
    }
}
