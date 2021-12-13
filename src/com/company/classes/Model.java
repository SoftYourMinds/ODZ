package com.company.classes;

import java.io.*;
import java.util.ArrayList;

public class Model {
    private static String path = "C:\\Users\\Max\\IdeaProjects\\ODZ\\src\\com\\company\\data\\books.txt";
    public String readDataBase() {
        String output = "";
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            output = reader.readLine();
        }catch (FileNotFoundException e){
            output = "false";
        }catch (IOException e){
            output =  "false";
        }
        return output;
    }

    public String writeDataBase(String data){
        String chek = "true";

        try  {
            Writer writer = new FileWriter(path,true);
            writer.write(data+"/");
            writer.close();
        } catch (IOException e){
            chek = e.getMessage();
        }
        return chek;
    }

    public String clearDataBase(){
        String out = "true";
        try {
            Writer writer = new FileWriter(path, false);
            writer.write("");
            writer.close();
        } catch (IOException e){
            out = e.getMessage();
        }
        return out;
    }


}
