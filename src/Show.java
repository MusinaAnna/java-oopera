import java.util.ArrayList;

public class Show {
    String title;
    int duration;
    Director director;
    ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public void printDirectorInfo() {
        System.out.println(director);
    }

    public void printActors(){
        for (Actor actor : listOfActors) {
            System.out.println(actor);
        }
    }

    public void addActor(Actor newActor) {
        if (listOfActors.contains(newActor)) {
            System.out.println("Этот актер уже участвует в спектакле!");
        } else {
            listOfActors.add(newActor);
            System.out.println("Новый актер добавлен");
        }
    }

    public void replaceActor(Actor newActor, String lastNameToReplace) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).lastName.equals(lastNameToReplace)) {
                listOfActors.set(i, newActor);
                found = true;
                System.out.println("Замена актера прошла успешно");
                break;
            }
        }
        if (!found) {
            System.out.println("Актер с фамилией " + lastNameToReplace + " не найден!");
        }
    }
}
