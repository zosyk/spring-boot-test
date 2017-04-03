package spring.boot.model;

/**
 * Created by alex on 03.04.17.
 */
public enum UserField {
    USER_NAME("username");

    private final String field;

    UserField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
