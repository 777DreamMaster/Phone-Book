package search;

import java.util.ArrayList;
import java.util.List;
import TimeUtil.TimeFormatter;

public class JumpSearch implements Search {

    private List<String> directory;
    private List<String> names;

    private final long linearTime;
    private boolean overLimit = false;

    public JumpSearch(long linearTime) {
        this.linearTime = linearTime;
    }

    @Override
    public void search(List<String> directory, List<String> names) {
        this.directory = new ArrayList<>(directory);
        this.names = new ArrayList<>(names);
        int count;

        System.out.println("Start searching (bubble sort + jump search)...");
        long sortTime = bubbleSort();

        long start = System.currentTimeMillis();
        if (!overLimit) count = search();
        else count = new LinearSearch(directory, names).search();
        long end = System.currentTimeMillis();

        System.out.printf("Found %d / %d entries. ", count, names.size());
        System.out.println(TimeFormatter.timeFormat(end - start + sortTime));
        System.out.printf("Sorting time: %s%s%n", TimeFormatter.timeFormat(sortTime),
                overLimit ? " - STOPPED, moved to linear search" : "");
        System.out.printf("Searching time: %s%n%n", TimeFormatter.timeFormat(end - start));
    }

    public long bubbleSort() {
        long startSort = System.currentTimeMillis();
        for (int i = 0; i < directory.size(); i++) {
            if (System.currentTimeMillis() - startSort > linearTime * 10) {
                overLimit = true;
                return System.currentTimeMillis() - startSort;
            }
            for (int j = 1; j < directory.size() - i; j++) {
                if (directory.get(j - 1).compareTo(directory.get(j)) > 0) {
                    String temp = directory.get(j - 1);
                    directory.set(j - 1, directory.get(j));
                    directory.set(j, temp);
                }
            }
        }
        long endSort = System.currentTimeMillis();
        return endSort - startSort;
    }

    private int search() {
        return (int) names.stream()
                .map(this::searchOne)
                .filter(e -> e)
                .count();
    }

    private boolean searchOne(String name) {
        int n = directory.size();
        int step = (int) Math.floor(Math.sqrt(n));
        int curr = 0;
        int prev = 0;

        while (directory.get(curr).compareTo(name) < 0) {
            if (curr == n - 1) return false;
            prev = curr;
            curr = Math.min(curr + step, n - 1);
        }

        while (directory.get(curr).compareTo(name) > 0) {
            curr = curr - 1;
            if (curr <= prev) return false;
        }

        return directory.get(curr).equals(name);
    }
}
