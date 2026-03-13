package ru.courses.parser;

public class UserAgent {

    private final String os;
    private final String browser;
    private final boolean isBot;

    public UserAgent(String userAgent) {

        if (userAgent == null || userAgent.equals("-")) {
            os = "Other";
            browser = "Other";
            isBot = false;
            return;
        }

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

        isBot = lower.contains("bot");
    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }

    public boolean isBot() {
        return isBot;
    }
}