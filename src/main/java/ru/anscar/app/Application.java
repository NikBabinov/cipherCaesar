package ru.anscar.app;

import ru.anscar.controller.ControllerView;
import ru.anscar.view.View;

public class Application {
    private final ControllerView controllerView;

    public Application(ControllerView controllerView){
        this.controllerView = controllerView;
    }
    public void run() {
        View controller = controllerView.getViewMode();
        controllerView.getParametersEnterUserInView(controller);
    }
}
