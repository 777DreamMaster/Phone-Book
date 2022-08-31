package search;

import TimeUtil.TimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch implements Search {

    private List<String> directory;
    private List<String> names;
    private long linearTime;

    public LinearSearch() {
    }

    public LinearSearch(List<String> directory, List<String> names) {
        this.directory = directory;
        this.names = names;
    }

    @Override
    public void search(List<String> directory, List<String> names) {
        this.directory = new ArrayList<>(directory);
        this.names = new ArrayList<>(names);

        System.out.println("Start searching (linear search)...");
        long start = System.currentTimeMillis();
        int count = search();
        long end = System.currentTimeMillis();
        System.out.printf("Found %d / %d entries. ", count, names.size());
        System.out.println(TimeFormatter.timeFormat(end - start) + "\n");
        linearTime = end - start;
    }

    public int search() {
        int count = 0;
        for (String name: names) {
            for (String line: directory) {
                if (name.equals(line)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public long getLinearTime() {
        return linearTime;
    }
}
