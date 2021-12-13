package com.company.classes;

public abstract class CinderBookShop {
     public abstract void addBook(DataBase dataBase);
     public abstract String viewBooks(DataBase dataBase);
     public abstract String viewBook(String name, DataBase dataBase);
     public abstract boolean deleteBook(String name,DataBase dataBase);
}
