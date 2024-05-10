package ru.anscar.app;

import ru.anscar.controller.ControllerFunction;
import ru.anscar.controller.ControllerView;
import ru.anscar.function.Function;
import ru.anscar.view.View;

import java.util.List;
import java.util.Map;

public class Application {
    private final ControllerView controllerView;
    private final ControllerFunction controllerFunction;

    public Application(ControllerView controllerView,ControllerFunction controllerFunction){
        this.controllerView = controllerView;
        this.controllerFunction = controllerFunction;
    }
    public void run() {
        View controller = controllerView.getViewMode();
        List<Map<String, String[]>> selectUserParameters = controllerView.getParametersEnterUserInView(controller);
        Function function = controllerFunction.getFunction(selectUserParameters);
        controllerFunction.getResultFunction(function);
    }
}
