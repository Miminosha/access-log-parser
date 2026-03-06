package ru.courses.statistics;

import ru.courses.parser.LogEntry;

import java.time.Duration;
import java.time.LocalDateTime;

public class Statistics {

    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;

    public Statistics() {
        totalTraffic = 0;
    }

    public void addEntry(LogEntry entry) {

        totalTraffic += entry.getDataSize();

        LocalDateTime time = entry.getTime();

        if (minTime == null || time.isBefore(minTime)) {
            minTime = time;
        }

        if (maxTime == null || time.isAfter(maxTime)) {
            maxTime = time;
        }
    }

    public double getTrafficRate() {

        if (minTime == null || maxTime == null) {
            return 0;
        }

        long hours = Duration.between(minTime, maxTime).toHours();

        if (hours == 0) {
            hours = 1;
        }

        return (double) totalTraffic / hours;
    }
}