import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void setListOfActors(ArrayList<Actor> listOfActors) {
        this.listOfActors = listOfActors;
    }

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public void printDirectorInfo() {
        System.out.println(director);
    }

    public void printActors() {
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
        int count = 0;
        Actor replacedActor = null;
        ArrayList<Actor> foundActors = new ArrayList<>();

        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);
            if (currentActor.getLastName().equals(lastNameToReplace)) {
                foundActors.add(currentActor);
                if (count == 0) {
                    replacedActor = currentActor;
                    listOfActors.set(i, newActor);
                    found = true;
                }
                count++;
            }
        }

        if (!found) {
            System.out.println("Актер с фамилией '" + lastNameToReplace + "' не найден!");
        } else if (count == 1) {
            System.out.println("Актер " + replacedActor.getFirstName() + " " + replacedActor.getLastName() + " заменен успешно");
        } else {
            System.out.println("Найдено " + count + " актера с фамилией '" + lastNameToReplace + "':");
            for (Actor actor : foundActors) {
                System.out.println("  - " + actor.getFirstName() + " " + actor.getLastName());
            }
            System.out.println("Заменен первый из них: " + replacedActor.getFirstName() + " " + replacedActor.getLastName());
        }
    }


    // Перегрузка метода. Имя одинаковое, в зависимости от переданных параметров вызывается тот или иной метод,

    public void replaceActor(Actor newActor, String firstNameToReplace, String lastNameToReplace) {
        boolean found = false;
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor currentActor = listOfActors.get(i);
            if (currentActor.getFirstName().equals(firstNameToReplace) &&
                    currentActor.getLastName().equals(lastNameToReplace)) {
                listOfActors.set(i, newActor);
                found = true;
                System.out.println("Актер " + firstNameToReplace + " " + lastNameToReplace + " заменен успешно");
                break;
            }
        }
        if (!found) {
            System.out.println("Актер " + firstNameToReplace + " " + lastNameToReplace + " не найден!");
        }
    }
}
