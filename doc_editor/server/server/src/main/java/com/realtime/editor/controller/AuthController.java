package com.realtime.editor.controller;

import com.realtime.editor.service.GoogleVerifierService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private GoogleVerifierService googleVerifierService;

    @PostMapping("/google")
    public String googleLogin(@RequestBody String token) {
        try {
            Payload payload = googleVerifierService.verifyToken(token);

            if (payload != null) {
                String email = payload.getEmail();
                String name = (String) payload.get("name");

                System.out.println("Verified User: " + name + " (" + email + ")");

                // You can save user to MongoDB here later

                return "Verified user: " + name + " (" + email + ")";
            } else {
                return "Invalid token";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Token verification failed";
        }
    }
}
