package hw7;

public class Main {
    public static void main(String[] args) {
        Cat[] cat = {new Cat("Барсик", 5),
                new Cat("Васька", 10),
                new Cat("Мурка", 8),
                new Cat("Тигрёнок", 13),
                new Cat("Рыжик", 7),
                new Cat("Симба", 11),
                new Cat("Пушок", 0),
        };
        Plate plate = new Plate(20);
        System.out.println("В тарелке " + plate.getFood() + " еды");

        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            plate.info();
            if (cat[i].isFull() == false) {
                plate.setFood(10);
            }
        }

        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isFull() == true) {
                System.out.println(cat[i].getName() + " сыт");
            } else {
                System.out.println(cat[i].getName() + " голодный");
            }

        }
    }
}
