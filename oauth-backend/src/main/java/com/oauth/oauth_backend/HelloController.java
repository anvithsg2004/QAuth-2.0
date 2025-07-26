package com.oauth.oauth_backend;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from GitHub OAuth-secured backend!";
    }

    @GetMapping("/userinfo")
    public Map<String, Object> userInfo(@AuthenticationPrincipal OAuth2User principal) {
        return Map.of(
                "email", principal.getAttribute("email"),
                "name", principal.getAttribute("name"),
                "picture", principal.getAttribute("picture")
        );
    }

}
