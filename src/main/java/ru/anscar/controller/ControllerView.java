package ru.anscar.controller;

import ru.anscar.constants.CommunicationWithUser;
import ru.anscar.constants.ValueParameters;
import ru.anscar.entity.ConsoleReader;
import ru.anscar.view.ConsoleView;
import ru.anscar.view.GuiView;
import ru.anscar.view.View;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ControllerView {
    public View getViewMode() {
        System.out.println(CommunicationWithUser.TYPE_VIEW);
        Scanner console = ConsoleReader.getInstance();
        try {
            String viewMode = console.nextLine();
            while (true) {
                if (viewMode.equalsIgnoreCase(ValueParameters.TERMINAL_WORK)) {
                    return new ConsoleView();
                }
                if (viewMode.equalsIgnoreCase(ValueParameters.GUI_WORK)) {
                    return new GuiView();
                }
                System.out.println(CommunicationWithUser.REPEAT_INPUT);
                viewMode = console.nextLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Map<String, String[]>> getParametersEnterUserInView(View view) {
        return view.getParametersForUser();
    }
}
