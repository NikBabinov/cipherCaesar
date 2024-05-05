package ru.anscar.app;

import ru.anscar.controller.ControllerView;
import ru.anscar.view.View;

public class Application {
    public Application(ControllerView controllerView) {
        View controller = controllerView.getViewMode();
    }
}
