package lesson1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    //    Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static <E> E[] replaceElements(E[] initArray, int i, int j) {
        E tempElement;
        tempElement = initArray[i];
        initArray[i] = initArray[j];
        initArray[j] = tempElement;
        return initArray;
    }

    //    Написать метод, который преобразует массив в ArrayList;
    public static <E> List<E> ConvertArrayToList(E[] initArray) {
        return new ArrayList<E>(Arrays.asList(initArray));
    }

    public static void main(String[] args) {
        String[] strArray = {"asd", "qwe", "zxc", "kkk", "lll"};
        System.out.println("after replacement ");
        for ( String a : strArray ) {
            System.out.println(a);
        }
    }
}
