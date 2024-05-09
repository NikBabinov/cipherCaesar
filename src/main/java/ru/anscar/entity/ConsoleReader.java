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

// --Commented out by Inspection START (09.05.2024 23:56):
//    public static void closeConsole(){
//        INSTANCE.close();
//    }
// --Commented out by Inspection STOP (09.05.2024 23:56)
}
