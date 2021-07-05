package hw6;
import hw6.animal.*;

    public class Main {
        public Main() {
        }

        public static void main(String[] args) {
            Cat[] cat = new Cat[]{new Cat("Барсик", 200, 5), new Cat("Мурка", 210, 0), new Cat("Васька", 189, 12)};
            Dog dog1 = new Dog("Жучка", 250, 12);
            Dog dog2 = new Dog("Шарик", 501, 25);

            for(int i = 0; i < cat.length; ++i) {
                cat[i].run();
                cat[i].swim();
            }

            dog1.run();
            dog1.swim();
            dog2.run();
            dog2.swim();
            Cat.catCount();
            Dog.dogCount();
            Animals.animalCount();
        }
    }

