package search;

import TimeUtil.TimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch implements Search {

    private List<String> directory;
    private List<String> names;
    private final long linearTime;
    private long startSort;
    private boolean overLimit = false;

    public BinarySearch(long linearTime) {
        this.linearTime = linearTime;
    }
    @Override
    public void search(List<String> directory, List<String> names) {
        this.directory = new ArrayList<>(directory);
        this.names = new ArrayList<>(names);
        int count;

        System.out.println("Start searching (quick sort + binary search)...");
        long sortTime = quickSort();

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

    public long quickSort() {
        startSort = System.currentTimeMillis();

        quickSort(0, directory.size() - 1);

        long endSort = System.currentTimeMillis();
        return endSort - startSort;
    }

    public void quickSort(int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(begin, end);
            if (partitionIndex == -1) return;
            quickSort(begin, partitionIndex - 1);
            quickSort(partitionIndex + 1, end);
        }
    }

    private int partition(int begin, int end) {
        String pivot = directory.get(end);
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (System.currentTimeMillis() - startSort > 10 * linearTime) {
                overLimit = true;
                return -1;
            }
            if (directory.get(j).compareTo(pivot) <= 0) {
                i++;

                String temp = directory.get(i);
                directory.set(i, directory.get(j));
                directory.set(j, temp);
            }
        }

        String temp = directory.get(i + 1);
        directory.set(i + 1, directory.get(end));
        directory.set(end, temp);

        return i + 1;
    }

    private int search() {
        return (int) names.stream()
                .map(this::searchOne)
                .filter(e -> e)
                .count();
    }

    public boolean searchOne(String name) {
        int left = 0;
        int right = directory.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (directory.get(mid).equals(name)) return true;

            if (directory.get(mid).compareTo(name) > 0) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
