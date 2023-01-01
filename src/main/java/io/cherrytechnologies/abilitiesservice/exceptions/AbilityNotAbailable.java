package io.cherrytechnologies.abilitiesservice.exceptions;

public class AbilityNotAbailable extends RuntimeException {
    public AbilityNotAbailable() {
        super();
    }

    public AbilityNotAbailable(String message) {
        super(message);
    }

    public AbilityNotAbailable(String message, Throwable cause) {
        super(message, cause);
    }

    public AbilityNotAbailable(Throwable cause) {
        super(cause);
    }
}
