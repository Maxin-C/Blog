package mywebfinal.demo.service.impl;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class test {
    public static void main(String[] args) throws IOException {
        String jsonStr = "";
        File file = new File("C:\\Users\\86954\\Downloads\\clinical.cases_selection.2021-03-10.json");
        FileReader fileReader = new FileReader(file);
        Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);

        int ch;
        StringBuilder sb = new StringBuilder();
        while ((ch = reader.read())!=-1){
            sb.append((char)ch);
        }
        fileReader.close();
        reader.close();
        jsonStr = sb.toString();
        

    }
}
