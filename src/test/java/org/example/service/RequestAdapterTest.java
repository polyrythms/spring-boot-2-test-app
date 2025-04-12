package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class RequestAdapterTest {
    private final Map<String, String> requestParams = Map.ofEntries(
            Map.entry("name1", "value1"),
            Map.entry("name2", "value2"));
    private final String expectedResult = "name1=value1&name2=value2";


    @Test
    void adaptRequest_shouldReturnExpectedResult_whileRequestIsCorrect() {
        String result = RequestAdapter.adaptRequest(requestParams);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void adaptRequest_shouldReturnUnExpectedResult_whileRequestIsNotCorrect() {
        var unexpectedMap = new HashMap<>(requestParams);
        unexpectedMap.put("AA", "BB");
        String result = RequestAdapter.adaptRequest(unexpectedMap);
        Assertions.assertNotEquals(expectedResult, result);
    }

    @Test
    void adaptRequest_shouldReturnEmptyString_whileRequestIsEmptyMap() {
        var emptyMap = new HashMap<String, String>();
        String result = RequestAdapter.adaptRequest(emptyMap);
        Assertions.assertEquals("", result);
    }
}