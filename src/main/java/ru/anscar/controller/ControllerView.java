package ru.anscar.controller;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.RequestUser;
import ru.anscar.entity.ConsoleReader;
import ru.anscar.view.ConsoleView;
import ru.anscar.view.GuiView;
import ru.anscar.view.View;

import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

public class ControllerView {
    public View getViewMode() {
        System.out.println(CommunicationWithUser.TYPE_VIEW);
        Scanner console = ConsoleReader.getInstance();
        try {
            String viewMode = console.nextLine();
            while (true) {
                if (viewMode.equalsIgnoreCase(RequestUser.REQUEST_YES)) {
                    return new ConsoleView();
                }
                if (viewMode.equalsIgnoreCase(RequestUser.REQUEST_NOT)) {
                    return new GuiView();
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT);
                viewMode = console.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, Path[]> getParametersEnterUserInView(View view) {
        return view.getParametersForUser();
    }
}
