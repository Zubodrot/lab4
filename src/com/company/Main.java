package com.company;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        String[] peopleInfo = new String[10];
        int personCounter = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {

            int temp=0;
            String s="";
            while ((s = br.readLine()) != null) {
                peopleInfo[temp]=s;
                temp++;
                personCounter = temp;
            }
        }

        System.out.println(personCounter);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))){
            for(int i=0;i<personCounter;i++) {
                    bw.write(stringWorker(peopleInfo[i]));
                    bw.newLine();
            }
        }


    }

    public static String stringWorker(String personInfo){
        String temp = personInfo;

        temp = temp.replaceAll("\\s",""); //убираем пробелы
        temp = temp.replaceAll("[|][+7]", "|+7(");
        temp = temp.replaceAll("[|][8]", "|+7("); //меняем 8 на +7
        StringBuffer temp2 = new StringBuffer(temp);
        temp2.insert((temp.indexOf("(")+4), ")");
        temp = temp2.toString(); //добавляем скобки к номеру телефона
        temp = temp.replaceAll("(@){2}","@"); //убираем излишние @
        temp = temp.replaceAll("[.]{2}","."); //убираем излишние .




        return temp;
    }
}
