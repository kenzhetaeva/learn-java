package mutable_key_in_hashmap;

import java.util.Objects;

public class UserKey {
    private String id;

    public UserKey(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserKey userKey = (UserKey) o;
        return Objects.equals(id, userKey.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
