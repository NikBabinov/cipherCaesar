package ru.anscar.view;

import ru.anscar.entity.KeyParametersView;

import java.util.Map;

public interface View {

    Map<KeyParametersView,String> getParametersForUser();
}
