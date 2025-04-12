package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncryptingImplementationTest {
    private final EncryptingImplementation encryptingImplementation = new EncryptingImplementation();
    private final String data = "name1=value1&name2=value2";
    private final String key = "operationId";
    private final String encryptedResult = "0a11548b134dcc00817029205ff5e4eac86bff6c83fe7b32489c1687e1c7a8b0";

    @Test
    void encrypt_shouldReturnExpectedResult_whileArgumentsAreCorrect() {
        String result = encryptingImplementation.encrypt(data, key);
        Assertions.assertEquals(encryptedResult, result);
    }

    @Test
    void encrypt_shouldReturnExpectedResult_whileArgumentsAreInCorrect() {
        String result = encryptingImplementation.encrypt(data + "A", key + "B");
        Assertions.assertNotEquals(encryptedResult, result);
    }

    @Test
    void encrypt_shouldNotThrowEx_whileDataIsEmpty() {
        Assertions.assertDoesNotThrow(() -> encryptingImplementation.encrypt("", key + "B"));
    }
}