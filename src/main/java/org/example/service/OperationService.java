package org.example.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OperationService {
    private final Encrypting encrypting;

    public OperationService(Encrypting encrypting) {
        this.encrypting = encrypting;
    }

    public String operateRequest(Map<String, String> params, String key) {
        String adaptedRequestParams = RequestAdapter.adaptRequest(params);
        return encrypting.encrypt(adaptedRequestParams, key);
    }
}
