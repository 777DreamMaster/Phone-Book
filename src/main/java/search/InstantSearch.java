package search;

import TimeUtil.TimeFormatter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstantSearch implements Search {

    private final Set<String> set = new HashSet<>();
    @Override
    public void search(List<String> directory, List<String> names) {
        int count = 0;
        System.out.println("Start searching (hash table)...");

        long startPrep = System.currentTimeMillis();
        set.addAll(directory);
        long endPrep = System.currentTimeMillis();

        long start = System.currentTimeMillis();
        for (String name: names) {
            if (set.contains(name)) count++;
        }
        long end = System.currentTimeMillis();

        System.out.printf("Found %d / %d entries. ", count, names.size());
        System.out.println(TimeFormatter.timeFormat(end - start + endPrep - startPrep));
        System.out.printf("Creating time: %s%n", TimeFormatter.timeFormat(endPrep - startPrep));
        System.out.printf("Searching time: %s%n", TimeFormatter.timeFormat(end - start));
    }
}
