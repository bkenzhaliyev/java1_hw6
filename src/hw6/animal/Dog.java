package hw6.animal;

public class Dog extends Animals{
    final int runLenght = 500;
    static int dogCount;

    public Dog(String name, int runLenght, int swimLenght) {
        super(name, runLenght, swimLenght);
        ++dogCount;
    }

    public Dog() {
        ++dogCount;
    }

    public void run() {
        this.getClass();
        if (500 <= 500) {
            super.run();
        } else {
            System.out.println("Собака не можете бегать на такое расстояние.");
        }

    }

    public static void dogCount() {
        System.out.println("количество собак " + dogCount);
    }
}
