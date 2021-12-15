package com.company.classes;

import java.util.ArrayList;

public class Controller { // методи додавання редагування видалення перегляду

    Model model = new Model();
    View view = new View();

    public String addBook(String name, Double coast, int number, int minOld, int maxOld){
        String result = "<html><font color ='green'>New book successfully add to database...</font></html>";


        ArrayList<String> books = new ArrayList<String>();
        String dataCheked = model.readDataBase();
        if((dataCheked == "")&&(name =="")) { // проверка на наличие данных в бд и на то что б имя не было пустым
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
        if((data != "")&&(oldName!="")&&(newName!="")){ // проверка на наличие данных в бд
            String[] booksSplit = data.split("/");

            for(int i = 0; i < booksSplit.length; i++){
               books.add(i, booksSplit[i]);
            }

            for (int i = 0; i< books.size(); i++){
                String[] bookZoom = books.get(i).split("~");
                String name = bookZoom[0];
                if (name.equals(oldName) == true) {
                     books.set(i, newName + "~" + newCoast + "~" + newNumber + "~" + newMinOld + "~" + newMaxOld);
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

    public String findBook(String name){
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
            result = "false"; // database is empty
        }
        if(getNameDone == 0){
            result = "false";// или там нет такой книги
        }
        return view.viewBook(result);
    }


    public String findBooks(int a, int b, double c){
        String output = "";
        ArrayList<String> books = new ArrayList<String>();
        ArrayList<String> searchesBooks = new ArrayList<String>();

        String dataCheked = model.readDataBase();
        if(dataCheked != "") { // проверка на наличие данных в бд
            String[] booksSplit = dataCheked.split("/");
            for (int i = 0; i < booksSplit.length; i++) {
                books.add(i, booksSplit[i]);
            }
            for (int i = 0; i < books.size(); i++) {
                String[] bookZoom = books.get(i).split("~");
                double c1 = (Double.valueOf(bookZoom[1]));
                int b1 = Integer.parseInt(bookZoom[4]);
                int a1 = Integer.parseInt(bookZoom[3]);

                if ((a <= a1)&&(b >= b1)&&(c >= c1)) {
                    searchesBooks.add(books.get(i));
                }
            }
            if(searchesBooks.size() > 0) {
                for (int i = 0; i < searchesBooks.size(); i++) {
                    output = output + searchesBooks.get(i) + "/";
                }

            }
            else{
                output = "false";
            }
        }
        else{
            output = "false";
        }
        return view.viewBooks(output);
    }

    public String minCoastBook(){
        String output = "";
        ArrayList<String> books = new ArrayList<String>();
        ArrayList<String> searchesBooks = new ArrayList<String>();

        String dataCheked = model.readDataBase();
        if(dataCheked != "") { // проверка на наличие данных в бд
            String[] booksSplit = dataCheked.split("/");
            for (int i = 0; i < booksSplit.length; i++) {
                books.add(i, booksSplit[i]);
            }
            Double[] coasts = new Double[books.size()];
            for (int i = 0; i < books.size(); i++) {
                String[] bookZoom = books.get(i).split("~");
                coasts[i]=Double.valueOf(bookZoom[1]);
            }
            double min = coasts[0];
            for(int i = 0; i<books.size(); i++) {
                if(coasts[i] < min) min = coasts[i];
            }
            int index =0;
            for(int i = 0; i<books.size(); i++) {
                if(coasts[i] == min) index = i;
            }
            output = view.viewBook(books.get(index));
        }
        else{
            output = "false";
        }
        return output;
    }


}
