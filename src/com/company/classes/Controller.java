package com.company.classes;

import java.util.ArrayList;

public class Controller { // методи додавання редагування видалення перегляду

    Model model = new Model();

    public String addBook(String name, Double coast, int number, int minOld, int maxOld){
        String result = "New book successfully add to database...";

        ArrayList<String> books = new ArrayList<String>();
        String dataCheked = model.readDataBase();
        if(dataCheked == "") { // проверка на наличие данных в бд
            String[] booksSplit = dataCheked.split("/");

            for (int i = 0; i < booksSplit.length; i++) {
                books.add(i, booksSplit[i]);
            }

            for (int i = 0; i < books.size(); i++) {
                String[] bookZoom = books.get(i).split("~");
                String nameSearch = bookZoom[0];
                if (name.equals(nameSearch) == true) {
                    return "This book already exist in database";
                }
            }
        }
        else {
            String data = name+"~"+coast+"~"+number+"~"+minOld+"~"+maxOld;
            String chek = model.writeDataBase(data);
            if(chek != "true"){
                result = "Sorry, add to database is failed";
            }
            return result;
        }
        String data = name+"~"+coast+"~"+number+"~"+minOld+"~"+maxOld;
        String chek = model.writeDataBase(data);
        if(chek != "true"){
            result = "Sorry, add to database is failed";
        }
        return result;
   }

    public String editBook(String oldName, String newName,  Double newCoast, int newNumber, int newMinOld, int newMaxOld ){
        String result = "Book edit is successfully done...";
        ArrayList<String> books = new ArrayList<String>();
        String data = model.readDataBase();
        int chekTrueOldName = 0;
        String chekingRepeats = "norepeats";
        if(data != ""){ // проверка на наличие данных в бд
            String[] booksSplit = data.split("/");

            for(int i = 0; i < booksSplit.length; i++){
               books.add(i, booksSplit[i]);
            }

            for (int i = 0; i< books.size(); i++){
                String[] bookZoom = books.get(i).split("~");
                String name = bookZoom[0];
                if (name.equals(oldName) == true) {
                     books.set(i, newName + "~" + newCoast + "~" + newNumber + "~" + newMaxOld + "~" + newMaxOld);
                     chekTrueOldName = 1;
                }
                if(name.equals(newName) == true){
                    return  "Edit name already exist in database";
                }
            }

            if(chekTrueOldName == 1) { // проверка на наличие такой книги в бд
                String clean = model.clearDataBase();
                if (clean == "true") { // проверка очистилась ли бд перед записью обновлением бд
                    for (int i = 0; i < books.size(); i++) {

                        chekingRepeats = model.writeDataBase(books.get(i));
                        if(chekingRepeats != "true"){ //Проверка на запись новой книги в бд
                            result = "Edit book is failed sometimes go wrong...";
                            model.writeDataBase(data); // и вместо новых данных записываем старые
                            break;
                        }
                    }
                } else {
                    result = "Something go wrong, database clean failed";
                }
            }
            else{
                result = "Database haven't this book...";
            }
        } else{
            result = "Edit book is failed, pleas add books to dataBase";
        }
        return result;
    }

    public String deleleBook(String name){
        String result = "Book succesfully deleted";

        ArrayList<String> books = new ArrayList<String>();
        int removed = 0;
        String dataCheked = model.readDataBase();
        if(dataCheked != "") { // проверка на наличие данных в бд
            String[] booksSplit = dataCheked.split("/");
            for (int i = 0; i < booksSplit.length; i++) {
                books.add(i, booksSplit[i]);
            }
            for (int i = 0; i < books.size(); i++) {
                String[] bookZoom = books.get(i).split("~");
                String nameSearch = bookZoom[0];

                if (name.equals(nameSearch) == true) {
                    books.remove(i);
                    removed = 1;
                }
            }
        }

        String chekingRepeats = "norepeats";
        if(removed == 1){
            String clean = model.clearDataBase();
            if (clean == "true") { // проверка очистилась ли бд перед записью обновлением бд
                for (int i = 0; i < books.size(); i++) {

                    chekingRepeats = model.writeDataBase(books.get(i));
                    if(chekingRepeats != "true"){ //Проверка на запись новой книги в бд
                        result = "Delete book is failed sometimes go wrong...";
                        model.writeDataBase(dataCheked); // и вместо новых данных записываем старые
                        break;
                    }
                }
            } else {
                result = "Something go wrong, database clean failed";
            }
        } else{
            result = "Delete book is empty in database";
        }
        return result;
    }

    public String getBook(String name){
        ArrayList<String> books = new ArrayList<String>();
        String result = "true";
        int getNameDone = 0;
        String dataCheked = model.readDataBase();
        if(dataCheked != "") { // проверка на наличие данных в бд
            String[] booksSplit = dataCheked.split("/");
            for (int i = 0; i < booksSplit.length; i++) {
                books.add(i, booksSplit[i]);
            }
            for (int i = 0; i < books.size(); i++) {
                String[] bookZoom = books.get(i).split("~");
                String nameSearch = bookZoom[0];

                if (name.equals(nameSearch) == true) {
                    result = bookZoom[0]+"~"+bookZoom[1]+"~"+bookZoom[2]+"~"+bookZoom[3]+"~"+bookZoom[4];
                    getNameDone = 1;
                }
            }
        } else {
            result = "DataBase is empty, please add new books";//или бд пустая
        }
        if(getNameDone == 0){
            result = "Sorry we haven't this book";// или там нет такой книги
        }
        return result;
    }





}
