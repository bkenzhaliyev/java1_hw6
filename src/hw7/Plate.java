package hw7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if (food <= n) {
            System.out.println("Еды в тарелке не хватает. Положите еды в тарелку");
            return false;
        }

        if (food == 0) {
            System.out.println("Еда в тарелке закончилась");
            return false;
        }
        food -= n;
        return true;
    }
    public void info() {
        System.out.println("В тарелке осталось еды: " + food);
    }

    public void setFood(int food) {
        this.food += food;
        System.out.printf("В тарелку добавлено еды: %s. Теперь в тарелке %s еды \n", food, this.food);
    }

    public int getFood() {
        return food;
    }
}
