package search;

import java.util.List;

public class Searcher {
    private Search search;

    public void setSearch(Search search) {
        this.search = search;
    }

    public void search(List<String> directory, List<String> names) {
        search.search(directory, names);
    }
}
