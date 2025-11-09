public class Director extends Person{

    int numberOfShows;

    public Director(String firstName, String lastName, Gender gender, int numberOfShows) {
        super(firstName, lastName, gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
