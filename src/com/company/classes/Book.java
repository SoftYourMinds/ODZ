package com.company.classes;

import java.util.ArrayList;

public class Book {
    private String name;
    private Double coast;
    private int number;
    private int minold;
    private int maxold;

    public Book (String name, Double coast, int number, int minold, int maxold){
        this.name = name;
        this.coast = coast;
        this.number = number;
        this.minold = minold;
        this.maxold = maxold;
    }

//    public void addBook(DataBase dataBase){
//        int k;
//        if(dataBase.getBooks().size() == 0){
//            k=0;
//        } else {
//            k = dataBase.getBooks().size() + 1;
//        }
//        dataBase.getBooks().put(k, new Book(name, coast, number, minold, maxold));
//        dataBase.addToDataBase(dataBase);
//        dataBase.setBooks(dataBase.getBooks());
//    }
//
//
//
//    public String viewBooks(DataBase dataBase){
//        String output = "";
//        ArrayList<String> allbooks = new ArrayList<String>();
//        if(getErrors().chekDataBaseEmpty(dataBase)==true){
//            output = "Sorry, shop is empty, we haven't this book";
//        } else{
//            String[] data = dataBase.readDataBase().split("/");
//            for(int i = 0; i<data.length; i++){
//                String[] book = data[i].split(",");
//                allbooks.add(i,"Name = "+book[0]+" Coast - "+book[1]+" Number - "+book[2]+" Old: "+book[3]+"-"+book[4]);
//            }
//            for(int i = 0; i<allbooks.size(); i++){
//                output = output + allbooks.get(i)+"\n";
//            }
//        }
//        return output;
//    }
//
//    public String viewBook(String nameSearch,  DataBase dataBase){
//        String name;
//        String output = ":<)";
//        boolean pointer = false;
//        if(errors.chekCollectionObjectsBook(dataBase) == true){
//            output = "Sorry we haven't no books";
//        } else{
//            for (int i = 0; i < dataBase.getBooks().size(); i++) {
//                name = dataBase.getBooks().get(i).getName();
//                for (int j = 0; j < dataBase.getBooks().size(); j++) {
//                    if (name == nameSearch) {
//                        output = "Name - "+dataBase.getBooks().get(j).getName()+" Coast - "+dataBase.getBooks().get(j).getCoast()+" Number - "+dataBase.getBooks().get(j).getNumber()+" Old: "+dataBase.getBooks().get(j).getMinold()+"-"+dataBase.getBooks().get(j).getMaxold();
//                        pointer = true;
//                    }
//                }
//            }
//            if (pointer == false){
//                output = "\""+nameSearch+"\""+" Sorry we haven't this book";
//            }
//        }
//        return output;
//    }
//
//    public boolean deleteBook(String name, DataBase dataBase){
//        boolean output = false;
//        if(errors.chekCollectionObjectsBook(dataBase)!=false){
//            for (int i = 0; i < dataBase.getBooks().size(); i++) {
//                if(name == dataBase.getBooks().get(i).getName()) {
//                    dataBase.getBooks().remove(i);
//
//                    output = true;
//                }
//            }
//            dataBase.updateDataBase(dataBase.getBooks());
//            dataBase.setBooksObjects(dataBase);
//        }
//        return output;
//    }
// geters
    public String getName() {
        return name;
    }

    public Double getCoast() {
        return coast;
    }

    public int getNumber() {
        return number;
    }

    public int getMinold() {
        return minold;
    }

    public int getMaxold() {
        return maxold;
    }

//seters
public void setName(String name) {
    this.name = name;
}

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setMinold(int minold) {
        this.minold = minold;
    }

    public void setMaxold(int maxold) {
        this.maxold = maxold;
    }

}
