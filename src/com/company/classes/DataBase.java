package com.company.classes;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DataBase {



    private HashMap<Integer, Book> books = new HashMap<Integer, Book>();
    private Errors errors = new Errors();

    public Errors getErrors() {
        return errors;
    }
    public void setBooks(HashMap<Integer, Book> books) {
        this.books = books;
    }

    public HashMap<Integer, Book> getBooks() {
        return books;
    }

    public String readDataBase() {
        try {
           File file = new File("C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            return line;
        }catch (FileNotFoundException e){
            return e.getMessage();

        }catch (IOException e){
            return e.getMessage();
        }
    }


//    public DataBase(HashMap<Integer, Book> books){
//        this.books = books;
//    }
//    public HashMap<Integer, Book> getBooks() {
//        return this.books;
//
//    }
//
//    public String readDataBase() {
//        try {
//            File file = new File("C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt");
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);
//            String line = reader.readLine();
//            return line;
//        }catch (FileNotFoundException e){
//            return e.getMessage();
//
//        }catch (IOException e){
//            return e.getMessage();
//        }
//    }
//
//    public void addToDataBase(DataBase dataBase){
//        dataBase.setBooksObjects(dataBase);
//        try {
//            Writer writer = new FileWriter("C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt",true);
//            for(int i = 0; i<dataBase.getBooks().size(); i++) {
//                writer.write(dataBase.getBooks().get(i).getName()+","+dataBase.getBooks().get(i).getCoast()+","+dataBase.getBooks().get(i).getNumber()+","+dataBase.getBooks().get(i).getMinold()+","+this.books.get(i).getMaxold()+"/");
//            }
//
//            writer.close();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void clearDataBase(){
//        try {
//            Writer writer = new FileWriter("C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt", false);
//            writer.write("");
//            writer.close();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void updateDataBase(HashMap<Integer, Book> booksUp){
//        clearDataBase();
//        try {
//            Writer writer = new FileWriter("C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt",true);
//            for(int i = 0; i<booksUp.size(); i++) {
//                writer.write(booksUp.get(i).getName()+","+booksUp.get(i).getCoast()+","+booksUp.get(i).getNumber()+","+booksUp.get(i).getMinold()+","+booksUp.get(i).getMaxold()+"/");
//            }
//            writer.close();
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void setBooksObjects(DataBase dataBase) {
//        if (errors.chekDataBaseEmpty(dataBase) == true) {
//            System.out.println("Shop is empty, please add books");
//        } else {
//            String[] data = dataBase.readDataBase().split("/");
//            for (int i = 0; i < data.length; i++) {
//                String[] book = data[i].split(",");
//                dataBase.getBooks().put(i, new Book(book[0], Double.parseDouble(book[1]), Integer.parseInt(book[2]), Integer.parseInt(book[3]), Integer.parseInt(book[4])));
//            }
//        }
//    }
}
