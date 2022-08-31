import search.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class Finder {
    private static final String DIRECTORY = System.getProperty("user.dir") + "/src/main/directory.txt";
    private static final String FIND = System.getProperty("user.dir") + "/src/main/find.txt";

    private static final Searcher searcher = new Searcher();

    public static void find() throws IOException {
        List<String> directory = Files.readAllLines(Path.of(DIRECTORY))
                .stream()
                .map(e -> e.split(" ", 2)[1])
                .collect(Collectors.toList());
        List<String> names = Files.readAllLines(Path.of(FIND));

        LinearSearch ls = new LinearSearch();
        searcher.setSearch(ls);
        searcher.search(directory, names);

        searcher.setSearch(new JumpSearch(ls.getLinearTime()));
        searcher.search(directory, names);

        searcher.setSearch(new BinarySearch(ls.getLinearTime()));
        searcher.search(directory, names);

        searcher.setSearch(new InstantSearch());
        searcher.search(directory, names);
    }
}
