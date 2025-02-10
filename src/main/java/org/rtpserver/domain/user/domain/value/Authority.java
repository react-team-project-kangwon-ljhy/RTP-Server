package org.rtpserver.domain.user.domain.value;

public enum Authority {
    USER("ROLE_USER"),
    STUDENT("ROLE_STUDENT");

    private final String value;

    Authority(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Authority fromValue(String value) {
        for (Authority role : Authority.values()) {
            if (role.name().equalsIgnoreCase(value) || role.getValue().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role value: " + value);
    }

}
