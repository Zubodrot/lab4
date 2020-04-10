package com.company;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        String[] peopleinfo = new String[10];
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            int temp=0;
            String s="";
            while ((s = br.readLine()) != null) {
                peopleinfo[temp]=s;
                temp++;
            }
        }

        for(String temp:peopleinfo){
            System.out.println(temp);
        }

    }
}
