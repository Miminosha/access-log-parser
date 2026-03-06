package ru.courses.parser;

public class UserAgent {

    private final String os;
    private final String browser;

    public UserAgent(String userAgent) {

        String lower = userAgent.toLowerCase();

        if (lower.contains("windows")) {
            os = "Windows";
        } else if (lower.contains("mac")) {
            os = "macOS";
        } else if (lower.contains("linux") || lower.contains("android")) {
            os = "Linux";
        } else {
            os = "Other";
        }

        if (lower.contains("edge")) {
            browser = "Edge";
        } else if (lower.contains("firefox")) {
            browser = "Firefox";
        } else if (lower.contains("chrome")) {
            browser = "Chrome";
        } else if (lower.contains("opera")) {
            browser = "Opera";
        } else {
            browser = "Other";
        }
    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }
}