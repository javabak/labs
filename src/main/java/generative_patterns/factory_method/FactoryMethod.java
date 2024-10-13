package generative_patterns.factory_method;

public class FactoryMethod {
    public static void main(String[] args) {
        Person person = Person.create();
        System.out.println(person);
    }
}


class Person {
    private Person() {}

    public static Person create() {
        return new Person();
    }
}

