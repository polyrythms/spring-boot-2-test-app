package org.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RequestAdapter {
    static String adaptRequest(Map<String, String> params) {
        List<String> sortedParams = params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());

        return String.join("&", sortedParams);
    }
}
