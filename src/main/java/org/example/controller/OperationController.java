package org.example.controller;

import org.example.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class OperationController {
    private final HttpServletRequest request;
    private final OperationService operationService;

    public OperationController(HttpServletRequest request, OperationService operationService) {
        this.request = request;
        this.operationService = operationService;
    }

    @RequestMapping(value = "operation/{operationId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> handleOperation(
            @PathVariable String operationId,
            @RequestBody Map<String, String> params) {
        System.out.println(request.getAttribute("Attr"));

        String signature = operationService.operateRequest(params, operationId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("result", Collections.singletonMap("signature", signature));

        return ResponseEntity.ok(response);
    }
    @RequestMapping(value = "test/{operationId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> test(
            @PathVariable String operationId,
            @RequestBody Map<String, String> params) {
        System.out.println(request.getAttribute("Attr"));
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return ResponseEntity.ok(response);
    }
}
