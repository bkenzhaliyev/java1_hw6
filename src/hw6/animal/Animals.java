package hw6.animal;

public class Animals {
    String name;
    int runLenght;
    int swimLenght;
    static int animalCount;

    public Animals(String name) {
        this.name = name;
        ++animalCount;
    }

    public Animals(String name, int runLenght, int swimLenght) {
        this.name = name;
        this.runLenght = runLenght;
        this.swimLenght = swimLenght;
        ++animalCount;
    }

    public Animals() {
        ++animalCount;
    }

    public void run() {
        System.out.println(this.name + " пробежал " + this.runLenght + " м.");
    }

    public void swim() {
        System.out.println(this.name + " проплыл " + this.swimLenght + " м.");
    }

    public static void animalCount() {
        System.out.println("Количество животных " + animalCount);
    }

}
