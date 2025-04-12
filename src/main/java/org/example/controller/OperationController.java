package org.example.controller;

import org.example.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @RequestMapping(value = "/{operationId}", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Map<String, Object>> handleOperation(
            @PathVariable String operationId,
            @RequestBody Map<String, String> params) {

        String signature = operationService.operateRequest(params, operationId);
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("result", Collections.singletonMap("signature", signature));

        return ResponseEntity.ok(response);
    }
}
