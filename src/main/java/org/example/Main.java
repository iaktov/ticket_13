package org.example;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        final int countShelves = 5;


        //Создание листа с наименованием книг
        List<String> books = new ArrayList<>();
        books.add("Война и мир");
        books.add("Маленькие трагедии");
        books.add("Анна Каренина");
        books.add("Золотая цепь");
        books.add("Мертвые души");

        System.out.println(books);
        System.out.println(books.size());
        getShelvesOfBooks(books, countShelves);
    }


    //метод для сортировки книг и их последующий вывод в виде списка книг распределенных по полкам
    public static List<ArrayList<String>> getShelvesOfBooks(List<String> books, int countShelves) {

        //Сортируем книги
        books = books.stream()
                .sorted()
                .collect(Collectors.toList());

        //Создаем лист с полками, которые состоят из листов в виде строк
        List<ArrayList<String>> shelves = new ArrayList<>();

        //создание листа с полками
        for (int i = 0; i < countShelves; i++) {
            ArrayList<String> shelf = new ArrayList<>();
            shelves.add(shelf);
        }

        //создаем 2 переменные с нулевым значением
        int index = 0;
        int shelfIndex = 0;

        //пока индекс меньше размера листа с книгами
        while (index < books.size()) {
            //создаем переменную, которая вызывает метод getBooksPerShelf(принимает кол-во оставшихся книг и оставшихся свободных полок)
            int perShelf = getBooksPerShelf(books.size() - index, shelves.size() - shelfIndex);
            //цикл который запрашивает определенный лист полки и добавляет в нее книгу
            for (int i = 0; i < perShelf; i++) {
                shelves.get(shelfIndex).add(books.get(index));
                index++;
            }
            shelfIndex++;
        }
        System.out.println(shelves);

        return shelves;
    }

    //метод, который считает сколько книг помещается на полку
    static int getBooksPerShelf(int books, int shelves) {
        return books / shelves;
    }

}