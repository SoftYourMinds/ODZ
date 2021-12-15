package com.company.classes;
import java.util.Scanner;


public class View {
    public String viewBooks(String output){
        String findBooks = "";
        if(output != "false") {
            String[] bookses = output.split("/");
            for(int i = 0; i< bookses.length; i++){
                String[] book =  bookses[i].split("~");
                findBooks = findBooks + "<html><font color: 'green'>Name: </font>" +book[0]+ " <font color: 'green'>amount:</font> "+book[2]+"</html>\n";
            }
        } else{
            findBooks = "<html><font color:'red'>We don't have anyone books this type...</font></html>";
        }
        return findBooks;
    }
    public String viewBook(String book){
        if((book != "false")&&(book != "")){
            String[] unboxing = book.split("~");
            return "Name: "+unboxing[0] +" Coast: "+ unboxing[1]+" Amount: "+ unboxing[2]+" OLd: "+unboxing[3]+" - "+unboxing[4];
        }
        else{
            return "<html><font color = 'red'>We don't have this book<font></html>";
        }
    }
}
