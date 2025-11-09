import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {

        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 178);
        Actor actor2 = new Actor("Мария", "Мариевна", Gender.FEMALE, 165);
        Actor actor3 = new Actor("Алексей", "Алексее", Gender.MALE, 182);


        Director director1 = new Director("Вацлав", "Рейзингер", Gender.MALE, 12);
        Director director2 = new Director("Густав", "Малер", Gender.MALE, 8);
        Director director3 = new Director("Константин", "Станиславский", Gender.MALE, 30);


        String musicAuthor = "Петр Чайковский";
        String choreographer = "Марис Лиепа";


        Show regularShow = new Show("Вишневый сад", 120, director3, new ArrayList<>());
        Opera opera = new Opera("Евгений Онегин", 150, director1, new ArrayList<>(), musicAuthor,
                "Либретто оперы 'Евгений Онегин' по одноименному роману А.С. Пушкина.", 30);
        Ballet ballet = new Ballet("Лебединое озеро", 135, director2, new ArrayList<>(), musicAuthor,
                "Либретто балета 'Лебединое озеро' по мотивам немецкой легенды о прекрасной принцессе Одетте.", choreographer);


        System.out.println("Добавляем актеров в спектакли:");
        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);


        System.out.println("\n=== СПИСКИ АКТЕРОВ ПО СПЕКТАКЛЯМ ===");
        System.out.println("Обычный спектакль:");
        regularShow.printActors();
        System.out.println("\nОпера:");
        opera.printActors();
        System.out.println("\nБалет:");
        ballet.printActors();


        System.out.println("\n=== ЗАМЕНА АКТЕРА ===");
        regularShow.replaceActor(actor3, "Петров"); // Заменяем актера с фамилией Петров на actor3


        System.out.println("Обычный спектакль после замены:");
        regularShow.printActors();


        System.out.println("\n=== ПРОБУЕМ ЗАМЕНИТЬ НЕСУЩЕСТВУЮЩЕГО АКТЕРА ===");
        ballet.replaceActor(actor1, "Несуществующий");


        System.out.println("\n=== ЛИБРЕТТО ОПЕРЫ ===");
        opera.printLibretto();
        System.out.println("\n=== ЛИБРЕТТО БАЛЕТА ===");
        ballet.printLibretto();
    }
}
