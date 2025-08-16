package entity;

public class room {
    private String name, email;

    public room(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + ", " + email;
    }
}
