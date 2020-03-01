package com.guardians.peace.service;

import java.util.Map;

public interface PeaceService {

    String getOpenDefects(Map<String, String> requestedInputParams);

    String createIssue(Map<String, String> requestedInputParams);

    String updateIssue(Map<String, String> requestedInputParams);

}
