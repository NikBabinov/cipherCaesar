package ru.anscar.controller;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.RequestUser;
import ru.anscar.view.ConsoleView;
import ru.anscar.view.GuiView;
import ru.anscar.view.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ControllerView {
    public View getViewMode() {
        System.out.println(CommunicationWithUser.TYPE_VIEW);
        try(Scanner console = new Scanner(System.in)){
           String viewMode = console.nextLine();
           while (true){
               if (viewMode.equalsIgnoreCase(RequestUser.REQUEST_YES)){
                   return new ConsoleView();
               }
               if (viewMode.equalsIgnoreCase(RequestUser.REQUEST_NOT)){
                   return new GuiView();
               }
               System.out.println(CommunicationWithUser.REPEAT_INPUT);
               viewMode = console.nextLine();
           }
        }
    }
}
