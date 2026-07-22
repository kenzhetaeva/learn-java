package equals_n_hashcode;

import java.util.Objects;

public class User {
    String id;

    User(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
