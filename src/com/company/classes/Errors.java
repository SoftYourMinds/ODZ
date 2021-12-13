package com.company.classes;

import java.util.HashMap;
import java.util.Map;

public class Errors {
    public boolean chekRepeatBooks(HashMap<Integer, Book> books) {
        String name;
        boolean chekResult = false;
        for (int i = 0; i < books.size(); i++) {
            name = books.get(i).getName();
            for (int j = 0; j < books.size(); j++) {
                if (books.get(j).getName() == name) {
                    chekResult =  true;
                }
            }
        }
        return chekResult;
    }

    public boolean chekDataBaseEmpty(DataBase dataBase){
        boolean resultChek = false;
        if (dataBase.readDataBase() == "" || dataBase.readDataBase() == null){
            resultChek = true;
        }
        return resultChek;
    }

    public boolean chekCollectionObjectsBook(DataBase dataBase){
        boolean resultChek = true; // есть данные
        if(dataBase.getBooks().size() == 0){
            resultChek = false; // нет данных
        }
        return resultChek;
    }


}
