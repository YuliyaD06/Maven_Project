package classWork.rest;

import java.util.Objects;

public class Search {

    public String user;
    boolean strict;

    public Search(String user, boolean strict) {
        this.user = user;
        this.strict = strict;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, strict);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Search search = (Search) o;
        return strict == search.strict && Objects.equals(user, search.user);
    }

    @Override
    public String toString() {
        return "Search{" +
                "user='" + user + '\'' +
                ", strict=" + strict +
                '}';
    }
}
