package org.example.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ControllerTest {
    Controller controller = new Controller();

    @Test
    public void generateHMACSHA256_shouldGenerate() {
        String result = controller.generateHMACSHA256("name1=value1&name2=value2", "operationId");
        Assertions.assertEquals("0a11548b134dcc00817029205ff5e4eac86bff6c83fe7b32489c1687e1c7a8b0", result);
    }

}