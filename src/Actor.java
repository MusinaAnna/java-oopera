import java.util.Objects;

public class Actor extends Person {

    int height;


    public Actor(String firstName, String lastName, Gender gender, int height) {
        super(firstName, lastName, gender);
        this.height = height;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Actor actor = (Actor) obj;
        return height == actor.height && Objects.equals(firstName, actor.firstName) &&
                Objects.equals(lastName, actor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, height);
    }

    @Override
    public String toString() {
        return super.toString() + " (" + height + ", " + gender +")";
    }
}

