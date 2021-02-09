package lesson1.fruits;

//    Задача:
//    Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//    Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//    Для хранения фруктов внутри коробки можно использовать ArrayList;
//    Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//
public class MainFruitsApp {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<Apple>();
        Box<Apple> appleBox2 = new Box<Apple>();
        Box<Orange> orangeBox1 = new Box<Orange>();
        Box<Orange> orangeBox2 = new Box<Orange>();
        for ( int i = 0; i < 6; i++ ) {
            appleBox1.putFruitIntoBox(new Apple());
        }
        for ( int i = 0; i < 15; i++ ) {
            appleBox2.putFruitIntoBox(new Apple());
        }
        appleBox2.putFruitIntoBox(new Apple());

        for ( int i = 0; i < 2; i++ ) {
            orangeBox1.putFruitIntoBox(new Orange());
        }

        for ( int i = 0; i < 4; i++ ) {
            orangeBox2.putFruitIntoBox(new Orange());
        }

        appleBox1.printInfo();
        appleBox2.printInfo();
        orangeBox1.printInfo();
        orangeBox2.printInfo();

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(orangeBox2));
        appleBox1.reloadTo(appleBox2);
        System.out.println("After reload from 1 to 2");
        appleBox1.printInfo();
        appleBox2.printInfo();
        appleBox2.reloadTo(appleBox2);
        System.out.println("After reload from 2 to 2");
        appleBox2.printInfo();
    }
}
