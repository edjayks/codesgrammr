package demo.codesgrammr.optional;

import java.util.Optional;

public class School {

    private String name;

    private boolean isOpen;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
