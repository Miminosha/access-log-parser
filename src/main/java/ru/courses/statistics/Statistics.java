package ru.courses.statistics;

import ru.courses.parser.LogEntry;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Statistics {

    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private final Set<String> existingPages;
    private final Set<String> unexistingPages;
    private final Map<String, Integer> osStatistics;
    private final Map<String, Integer> browserStatistics;

    public Statistics() {
        totalTraffic = 0;
        existingPages = new HashSet<>();
        unexistingPages = new HashSet<>();
        osStatistics = new HashMap<>();
        browserStatistics = new HashMap<>();
    }

    public void addEntry(LogEntry entry) {

        totalTraffic += entry.getDataSize();

        if (entry.getResponseCode() == 200) {
            String path = entry.getPath();
            int index = path.indexOf("?");

            if (index != -1) {
                path = path.substring(0, index);
            }
            existingPages.add(path);
        } else if (entry.getResponseCode() == 404) {
            String path = entry.getPath();
            int index = path.indexOf("?");

            if (index != -1) {
                path = path.substring(0, index);
            }
            unexistingPages.add(path);
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

    public Set<String> getListOfExistingPages(){
        return existingPages;
    }

    public Set<String> getListOfUnexistingPages(){
        return unexistingPages;
    }

    public Map<String, Double> getOsStatistics() {
        HashMap<String, Double> result = new HashMap<>();

        int total = 0;

        for (int count : osStatistics.values()) {
            total += count;
        }

        for (String os : osStatistics.keySet()) {
            int count = osStatistics.get(os);
            double share = (double) count / total;
            result.put(os, share);
        }
        return result;
    }

    public Map<String, Double> getBrowserStatistics() {
        HashMap<String, Double> result = new HashMap<>();

        int total = 0;

        for (int count : browserStatistics.values()) {
            total += count;
        }

        for (String browser : browserStatistics.keySet()) {
            int count = browserStatistics.get(browser);
            double share = (double) count / total;
            result.put(browser, share);
        }
        return result;
    }
}