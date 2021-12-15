package com.company;

import com.company.classes.*;

import java.util.HashMap;


/*
1. Система керування даними повинна дозволяти вводити, видаляти, редагувати і переглядати дані.
2. Функціонал, який реалізує вибір дії повинен знаходиться в функції main(). Дії, по видаленню, додаванню, редагування і перегляду даних повинні знаходиться в методах окремого класу Controller. Процеси безпосередньої роботи з файлом бази даних, повинні перебувати в методах окремого класу Model. Відображення результатів роботи методів контролера повинні проводитися через шаблони відображення, тобто методи окремого класу View, які містить необхідні текстові рядки, а також дозволяють здійснювати введення даних користувачеві, і повертати введені дані методу класу Controller.
3. Для реалізації додатку необхідно створити діаграму класів та варіантів.
4. Програма повинна мати графічний інтерфейс.
 */
/*
1. Створити базу даних, яка містить відомості про асортимент дитячих книг в магазині.
Структура запису:
назва книги, ціна, кількість, вікові обмеження(2-5),
функціонал:
a) знайти назви книг, які підходять дітям від Х до У років;
b) дізнатися вартість найбільш дешевої книги і її найменування;
c) знайти назви книг, які за вартістю не перевищують x грн. і підходять дитині віком від a до b років. Значення x, a, b ввести з терміналу.


 */
public class Main {

    public static void main(String[] args) {
        Controller controller =  new Controller();
        System.out.println(controller.findBooks(5,6,5.33));

//        System.out.println(controller.addBook("HUCK",23.33,33, 2,6));
//        System.out.println(controller.editBook("just", "HUK",3.33,3,5,7));
//        System.out.println(controller.deleleBook("HUCK"));
//        System.out.println(controller.findBook("HUK"));
//
//        System.out.println(controller.minCoastBook());
////
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
//        HashMap<Integer, Book> books = new HashMap<Integer, Book>();
//
//        DataBase dataBase = new DataBase(books);
//        dataBase.setBooksObjects(dataBase);
//
//        Book a = new Book("dsfsdas",232.32, 2,2,5);
//        a.addBook(dataBase);
//a.deleteBook("dsfsdas", dataBase);
//        System.out.println(a.viewBooks(dataBase));
//        System.out.println("==========");
//        dataBase.setBooks(books);
//        for(int i =0; i< dataBase.getBooks().size(); i++){
//            System.out.println(dataBase.getBooks().get(i).getName()+"\n");
//
//        }
//        System.out.println(a.viewBook("dsfsd", dataBase));
    }
}
