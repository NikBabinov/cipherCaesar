package ru.anscar;
import ru.anscar.app.Application;
import ru.anscar.controller.ControllerView;

public class EntryPoint {
    public static void main(String[] args) {
        ControllerView controllerView = new ControllerView();
        Application app = new Application(controllerView);
        app.run();
    }
}