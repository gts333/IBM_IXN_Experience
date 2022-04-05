package com.uclibm.ixn.service;

import java.util.Map;

public interface UserInputService {

    void addUserInput(String string);

    Map<String, Integer> getUserReport();
}
