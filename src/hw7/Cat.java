package hw7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        // проверка реализована на случай если еще раз попытаются покормить кошек
        if (this.full == true) {
            System.out.printf("%s сыт \n", this.name);
            return;
        }

        if (appetite <= 0) {
            System.out.println("Вы не правильно кормите кота!!!");
            return;
        }

        if (p.decreaseFood(appetite) == true) {
            System.out.printf("%s покушал \n", this.name);
            this.full = true;
//            return;
        } else {
            System.out.printf("%s остался голодным \n", this.name);
        }
    }

    public boolean isFull() {
        return full;
    }

    public String getName() {
        return name;
    }
}
