public class Main {
    public static void main() {
        AnimalCare animalCare = new AnimalCare();

        Dog myDog = new Dog();
        Cat myCat = new Cat();

        animalCare.checkSound(myDog);
        animalCare.checkSound(myCat);

        }
    }
}