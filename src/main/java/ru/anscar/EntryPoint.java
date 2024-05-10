package ru.anscar;
import ru.anscar.app.Application;
import ru.anscar.controller.ControllerFunction;
import ru.anscar.controller.ControllerView;

public class EntryPoint {
    public static void main(String[] args) {
        ControllerView controllerView = new ControllerView();
        ControllerFunction controllerFunction = new ControllerFunction();
        Application app = new Application(controllerView,controllerFunction);
        app.run();
    }
}