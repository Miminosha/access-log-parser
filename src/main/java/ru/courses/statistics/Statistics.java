package ru.courses.statistics;

import ru.courses.parser.LogEntry;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Statistics {

    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private final Set<String> existingPages;
    private final Set<String> unexistingPages;
    private final Map<String, Integer> osStatistics;
    private final Map<String, Integer> browserStatistics;
    private int realVisits;
    private int errorRequests;
    private final HashSet<String> userIps;

    public Statistics() {
        totalTraffic = 0;
        existingPages = new HashSet<>();
        unexistingPages = new HashSet<>();
        osStatistics = new HashMap<>();
        browserStatistics = new HashMap<>();
        realVisits = 0;
        errorRequests = 0;
        userIps = new HashSet<>();
    }

    public void addEntry(LogEntry entry) {

        totalTraffic += entry.getDataSize();

        if (entry.getResponseCode() == 200) {
            existingPages.add(entry.getPath());
        }

        if (entry.getResponseCode() == 404) {
            unexistingPages.add(entry.getPath());
        }

        LocalDateTime time = entry.getTime();

        if (minTime == null || time.isBefore(minTime)) {
            minTime = time;
        }

        if (maxTime == null || time.isAfter(maxTime)) {
            maxTime = time;
        }

        String os = entry.getUserAgent().getOs();

        if (!osStatistics.containsKey(os)) {
            osStatistics.put(os, 1);
        } else {
            osStatistics.put(os, osStatistics.get(os) + 1);
        }

        String browser = entry.getUserAgent().getBrowser();

        if (!browserStatistics.containsKey(browser)) {
            browserStatistics.put(browser, 1);
        } else {
            browserStatistics.put(browser, browserStatistics.get(browser) + 1);
        }

        // проверка на ботов
        boolean isBot = entry.getUserAgent().isBot();

        if (!isBot) {
            realVisits++;
            userIps.add(entry.getIp());
        }

        // ошибочные запросы
        int code = entry.getResponseCode();

        if (code >= 400 && code < 600) {
            errorRequests++;
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

    public Set<String> getListOfExistingPages() {
        return existingPages;
    }

    public Set<String> getListOfUnexistingPages() {
        return unexistingPages;
    }

    public Map<String, Double> getOsStatistics() {
        HashMap<String, Double> result = new HashMap<>();

        int total = osStatistics.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return osStatistics.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> (double) e.getValue() / total));
    }

    public Map<String, Double> getBrowserStatistics() {
        HashMap<String, Double> result = new HashMap<>();

        int total = browserStatistics.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return browserStatistics.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (double) e.getValue() / total));
    }

    private double getHoursPeriod() {
        if (minTime == null || maxTime == null) {
            return 1;
        }
        long seconds = java.time.Duration.between(minTime, maxTime).getSeconds();
        double hours = seconds / 3600.0;

        return hours == 0 ? 1 : hours;
    }

    public double getAverageVisitsPerHour() {
        return realVisits / getHoursPeriod();
    }

    public double getAverageErrorsPerHour() {
        return errorRequests / getHoursPeriod();
    }

    public double getAverageVisitsPerUser() {
        if (userIps.isEmpty()) {
            return 0;
        }
        return (double) realVisits / userIps.size();
    }
}