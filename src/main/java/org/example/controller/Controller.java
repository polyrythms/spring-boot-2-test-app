package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/operation/{operationId}")
    public ResponseEntity<Map<String, Object>> handleOperation(
            @PathVariable String operationId,
            @RequestBody Map<String, String> params) {

        // Сортируем параметры по имени
        List<String> sortedParams = params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());

        // Формируем строку для хеширования
        String dataToHash = String.join("&", sortedParams);

        // Генерируем HMAC SHA256
        String signature = generateHMACSHA256(dataToHash, operationId);

        // Формируем ответ
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("result", Collections.singletonList(Collections.singletonMap("signature", signature)));

        return ResponseEntity.ok(response);
    }

    public String generateHMACSHA256(String data, String key) {
        try {
            Mac sha256_HMAC = Mac.getInstance("");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] hash = sha256_HMAC.doFinal(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC SHA256", e);
        }
    }

}
