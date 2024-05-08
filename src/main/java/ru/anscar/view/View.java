package ru.anscar.view;


import java.nio.file.Path;
import java.util.Map;

public interface View {

    Map<String, Path[]> getParametersForUser();
}
