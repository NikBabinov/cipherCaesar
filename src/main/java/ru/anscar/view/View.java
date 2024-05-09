package ru.anscar.view;

import java.util.List;
import java.util.Map;

public interface View {

    List<Map<String, String[]>> getParametersForUser();
}
