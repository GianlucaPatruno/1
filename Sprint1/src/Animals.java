public class Animal {
    public void sound() {
        System.out.println("L'animale fa un suono")
    }
}

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println("il cane abbaia")
    }
}

public class Cat extends Animal {

    @Override
    public void sound() {
        System.out.println("il gatto miagola")
    }
}