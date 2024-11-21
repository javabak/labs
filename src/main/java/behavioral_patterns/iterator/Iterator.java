package behavioral_patterns.iterator;

public class Iterator {
    public static void main(String[] args) {
        // Создаем коллекцию имен
        String[] names = {"John", "Jane", "Jack", "Jill"};
        NameCollection nameCollection = new NameCollection(names);

        // Получаем итератор для коллекции
        IteratorInterface<String> iterator = nameCollection.createIterator();

        // Используем итератор для перебора коллекции
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Name: " + name);
        }
    }
}

interface IteratorInterface<T> {
    boolean hasNext(); // Проверка наличия следующего элемента
    T next();          // Получение следующего элемента
}

interface Iterable<T> {
    IteratorInterface<T> createIterator(); // Метод для создания итератора
}


// Коллекция строк, которая реализует интерфейс Iterable
class NameCollection implements Iterable<String> {
    private final String[] names;

    public NameCollection(String[] names) {
        this.names = names;
    }

    // Метод для создания итератора
    @Override
    public IteratorInterface<String> createIterator() {
        return new NameIterator();
    }

    // Внутренний класс итератора для этой коллекции
    private class NameIterator implements IteratorInterface<String> {
        private int index = 0;

        // Метод для проверки, есть ли еще элементы
        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        // Метод для получения следующего элемента
        @Override
        public String next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
