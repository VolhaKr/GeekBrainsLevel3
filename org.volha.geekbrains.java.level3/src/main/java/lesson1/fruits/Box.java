package lesson1.fruits;

import java.util.ArrayList;


//    Не забываем про метод добавления фрукта в коробку.
public class Box<T extends Fruit> {
    private float weight;
    private ArrayList<T> fruits = new ArrayList<T>();

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public float getWeight() {
        weight = 0;
        for ( T fruit : fruits ) {
            weight = weight + fruit.getWEIGHT();
        }
        return weight;
    }

    void putFruitIntoBox(T fruit) {
        fruits.add(fruit);
    }

    //Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
    // true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
    public boolean compare(Box another) {
        if ((this == another) || (Math.abs(this.weight - another.getWeight()) < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }

    //    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
    //    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
    public void reloadTo(Box<T> another) {
        //подслушала в конце второго урока
        if (this == another){
            return;
        }
        for ( T fruit : fruits ) {
            another.putFruitIntoBox(fruit);
            //  this.fruits.remove(fruit);
        }
        this.fruits.clear();
    }

    public void printInfo() {
        System.out.println("Box ");
        System.out.println("Fruits in the box:");
        for ( T fruit : fruits ) {
            System.out.println(fruit + " weight " + fruit.WEIGHT);
        }
        System.out.println("Box weight " + this.getWeight());
    }
}
