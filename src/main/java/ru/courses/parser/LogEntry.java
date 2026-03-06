package ru.courses.parser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {

    private final String ip;
    private final LocalDateTime time;
    private final HttpMethod method;
    private final String path;
    private final int responseCode;
    private final int dataSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String line) {

        try {

            String[] parts = line.split("\"");

            String left = parts[0];
            String request = parts[1];
            String middle = parts[2];
            String referer = parts.length > 3 ? parts[3] : "-";
            String userAgentStr = parts.length > 5 ? parts[5] : "-";

            String[] leftParts = left.split(" ");

            ip = leftParts[0];

            String timeString = left.substring(
                    left.indexOf("[") + 1,
                    left.indexOf("]")
            );

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);

            time = LocalDateTime.parse(timeString, formatter);

            String[] requestParts = request.split(" ");

            method = HttpMethod.valueOf(requestParts[0]);
            path = requestParts[1];

            String[] middleParts = middle.trim().split(" ");

            responseCode = Integer.parseInt(middleParts[0]);

            if (middleParts[1].equals("-")) {
                dataSize = 0;
            } else {
                dataSize = Integer.parseInt(middleParts[1]);
            }

            this.referer = referer;
            this.userAgent = new UserAgent(userAgentStr);

        } catch (Exception ex) {
            throw new RuntimeException("Ошибка парсинга строки лога: " + line);
        }
    }

    public String getIp() {
        return ip;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getDataSize() {
        return dataSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}