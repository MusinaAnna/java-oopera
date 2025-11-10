import java.util.ArrayList;
import java.util.Scanner;

public class TheatreDemo {
    private static final ArrayList<Show> allShows = new ArrayList<>();
    private static final ArrayList<MusicalShow> musicalShows = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        createShow();

        int cmd = 0;

        while (cmd != 6) {
            printMenu();

            if (scanner.hasNextInt()) {
                cmd = scanner.nextInt();
                scanner.nextLine();

                switch (cmd) {
                    case 1:
                        printLibretto(scanner);
                        break;
                    case 2:
                        printAllInfoForShow(scanner);
                        break;
                    case 3:
                        printActorsForAllShows();
                        break;
                    case 4:
                        addNewActor(scanner);
                        break;
                    case 5:
                        replaceActorSelected(scanner);
                        break;
                    case 6:
                        System.out.println("Завершение программы");
                        break;
                    default:
                        System.out.println("Нет такой команды. Введите номер команды от 1 до 6");
                }
                if (cmd != 6) {
                    System.out.println();
                }
            } else {
                System.out.println("Ошибка: введите целое число от 1 до 6");
                scanner.next();
                System.out.println();
            }
        }
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Введите номер желаемой команды: ");
        System.out.println("1. Распечатать текст либретто");
        System.out.println("2. Распечатать информацию о спектакле");
        System.out.println("3. Распечатать список всех актёров, участвующих в спектаклях");
        System.out.println("4. Добавить нового актёра в спектакль");
        System.out.println("5. Заменить одного актёра в спектакле на другого");
        System.out.println("6. Выход");
    }

    private static void createShow() {
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 178);
        Actor actor2 = new Actor("Мария", "Мариевна", Gender.FEMALE, 165);
        Actor actor3 = new Actor("Алексей", "Алексеев", Gender.MALE, 182);
        Actor actor4 = new Actor("Ольга", "Ольгина", Gender.FEMALE, 170);
        Actor actor5 = new Actor("Дмитрий", "Дмитриев", Gender.MALE, 175);

        Director director1 = new Director("Вацлав", "Рейзингер", Gender.MALE, 12);
        Director director2 = new Director("Густав", "Малер", Gender.MALE, 8);
        Director director3 = new Director("Константин", "Станиславский", Gender.MALE, 30);

        ArrayList<Actor> actorsForShow = new ArrayList<>();
        actorsForShow.add(actor1);
        actorsForShow.add(actor2);

        Show regularShow = new Show("Вишневый сад", 120, director3, actorsForShow);
        allShows.add(regularShow);

        ArrayList<Actor> actorsForOpera = new ArrayList<>();
        actorsForOpera.add(actor3);
        actorsForOpera.add(actor4);
        actorsForOpera.add(actor5);

        Opera opera = new Opera("Евгений Онегин", 150, director2, actorsForOpera,
                "Петр Чайковский",
                "Либретто оперы 'Евгений Онегин' по одноименному роману А.С. Пушкина.",
                30);
        allShows.add(opera);
        musicalShows.add(opera);

        ArrayList<Actor> actorsForBallet = new ArrayList<>();
        actorsForBallet.add(actor1);
        actorsForBallet.add(actor4);
        actorsForBallet.add(actor5);

        Ballet ballet = new Ballet(
                "Лебединое озеро", 135, director1, actorsForBallet, "Петр Чайковский",
                "Либретто балета 'Лебединое озеро' по мотивам немецкой легенды о прекрасной принцессе Одетте.",
                "Марис Лиепа");
        allShows.add(ballet);
        musicalShows.add(ballet);
    }

    private static void printLibretto(Scanner scanner) {
        System.out.println("Выберите спектакль для вывода либретто:");

        for (int i = 0; i < musicalShows.size(); i++) {
            MusicalShow show = musicalShows.get(i);
            System.out.println((i + 1) + ". " + show.title);
        }

        if (musicalShows.isEmpty()) {
            System.out.println("Нет спектаклей с либретто");
            return;
        }

        System.out.print("Введите номер спектакля: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= musicalShows.size()) {
                MusicalShow selectedShow = musicalShows.get(choice - 1);
                System.out.println("\n=== ЛИБРЕТТО: " + selectedShow.title + " ===");
                selectedShow.printLibretto();
                System.out.println("================================\n");
            } else {
                System.out.println("Неверный выбор");
            }
        } else {
            System.out.println("Ошибка: введите число");
            scanner.next();
        }
    }

    private static void printAllInfoForShow(Scanner scanner) {
        System.out.println("Выберите спектакль для вывода информации о спектакле:");

        for (int i = 0; i < allShows.size(); i++) {
            Show show = allShows.get(i);
            System.out.println((i + 1) + ". " + show.title);
        }

        if (allShows.isEmpty()) {
            System.out.println("Нет спектаклей");
            return;
        }

        System.out.print("Введите номер спектакля: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= allShows.size()) {
                Show selectedShow = allShows.get(choice - 1);
                System.out.println("\n=== ИНФОРМАЦИЯ О СПЕКТАКЛЕ: " + selectedShow.title + " ===");

                System.out.print("Режиссёр: ");
                selectedShow.printDirectorInfo();

                if (musicalShows.contains(selectedShow)) {
                    MusicalShow musicalShow = (MusicalShow) selectedShow;
                    System.out.println("Автор музыки: " + musicalShow.getMusicAuthor());

                    if (selectedShow instanceof Ballet) {
                        Ballet ballet = (Ballet) selectedShow;
                        System.out.println("Хореограф: " + ballet.getChoreographer());
                    }

                    if (selectedShow instanceof Opera) {
                        Opera opera = (Opera) selectedShow;
                        System.out.println("Размер хора: " + opera.getChoirSize());
                    }
                }

                System.out.println("================================\n");
            } else {
                System.out.println("Неверный выбор");
            }
        } else {
            System.out.println("Ошибка: введите число");
            scanner.next();
        }
    }

    private static void printActorsForAllShows() {
        System.out.println("=== АКТЁРЫ ПО СПЕКТАКЛЯМ ===\n");

        if (allShows.isEmpty()) {
            System.out.println("Нет спектаклей");
            return;
        }

        for (Show show : allShows) {
            System.out.println("СПЕКТАКЛЬ: " + show.title);
            System.out.println("Актёры:");
            show.printActors();
            System.out.println("-------------------\n");
        }

        System.out.println("=============================");
    }

    private static Actor inputActor(Scanner scanner) {
        System.out.println("Введите данные актера:");
        System.out.print("Имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Фамилия: ");
        String lastName = scanner.nextLine();

        Gender gender;
        while (true) {
            System.out.print("Пол (м/ж или M/F): ");
            String genderInput = scanner.nextLine();

            if (genderInput.equals("M") || genderInput.equals("m") ||
                    genderInput.equals("М") || genderInput.equals("м")) {
                gender = Gender.MALE;
                break;
            } else if (genderInput.equals("F") || genderInput.equals("f") ||
                    genderInput.equals("Ж") || genderInput.equals("ж")) {
                gender = Gender.FEMALE;
                break;
            } else {
                System.out.println("Неверный ввод пола. Пожалуйста, введите M/m для мужского или Ж/F для женского.");
            }
        }

        System.out.print("Рост: ");
        int height = scanner.nextInt();
        scanner.nextLine();

        return new Actor(firstName, lastName, gender, height);
    }

    private static void addNewActor(Scanner scanner) {
        System.out.println("=== ДОБАВЛЕНИЕ НОВОГО АКТЁРА ===\n");

        System.out.println("Выберите спектакль для добавления актера:");
        for (int i = 0; i < allShows.size(); i++) {
            Show show = allShows.get(i);
            System.out.println((i + 1) + ". " + show.title);
        }

        System.out.print("Введите номер спектакля: ");
        int showIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (showIndex < 0 || showIndex >= allShows.size()) {
            System.out.println("Неверный выбор спектакля");
            return;
        }

        Show selectedShow = allShows.get(showIndex);

        Actor newActor = inputActor(scanner);
        selectedShow.addActor(newActor);
        System.out.println("Новый актер " + newActor + " добавлен в спектакль '" + selectedShow.title + "'");
    }

    private static void replaceActorSelected(Scanner scanner) {
        System.out.println("=== ЗАМЕНА АКТЁРА В СПЕКТАКЛЕ ===\n");

        if (allShows.isEmpty()) {
            System.out.println("Нет спектаклей");
            return;
        }

        System.out.println("Выберите спектакль, в котором нужно заменить актера:");
        for (int i = 0; i < allShows.size(); i++) {
            Show show = allShows.get(i);
            System.out.println((i + 1) + ". " + show.title);
        }

        System.out.print("Введите номер спектакля: ");
        int showIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (showIndex < 0 || showIndex >= allShows.size()) {
            System.out.println("Неверный выбор спектакля");
            return;
        }

        Show selectedShow = allShows.get(showIndex);

        System.out.println("\nВыберите способ поиска актера для замены:");
        System.out.println("1. По фамилии");
        System.out.println("2. По имени и фамилии");
        System.out.print("Введите номер способа: ");

        int searchType = scanner.nextInt();
        scanner.nextLine();

        Actor newActor = inputActor(scanner);

        if (searchType == 1) {
            System.out.print("Введите фамилию актера, которого нужно заменить: ");
            String lastName = scanner.nextLine();
            selectedShow.replaceActor(newActor, lastName);
        } else if (searchType == 2) {
            System.out.print("Введите имя актера, которого нужно заменить: ");
            String firstName = scanner.nextLine();
            System.out.print("Введите фамилию актера, которого нужно заменить: ");
            String lastName = scanner.nextLine();
            selectedShow.replaceActor(newActor, firstName, lastName);
        } else {
            System.out.println("Неверный выбор способа поиска.");
        }
    }
}