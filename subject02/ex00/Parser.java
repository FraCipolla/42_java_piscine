package ex00;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Parser {
    private Map<String, String> _signatures = new HashMap<String, String>();
    Scanner input = new Scanner(System.in);
    
    public Parser(String path) throws FileNotFoundException, IOException {
        String data = "";
        try (FileInputStream fis = new FileInputStream(path)) {
        int i = 0;
        while ((i = fis.read()) != -1) {
            data += (char) i;  
        }
    }
        String[] fileArray = data.split("\n");
        
        for (int i = 0; i < fileArray.length; i++) {
            String[] toMap = fileArray[i].split(", ");
            String[] tmp = toMap[1].split(" ");
            toMap[1] = new String();
            for (int j = 0; j < tmp.length; j++) {
                toMap[1] += tmp[j];
            }
            this._signatures.put(toMap[0], toMap[1]);
        }
    }

    public void printMap() {
        for(Map.Entry mp: this._signatures.entrySet()){  
            System.out.println(mp.getKey() + "->" + mp.getValue());  
            }
    }

    private String readFile(String path) throws FileNotFoundException, IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            byte[] data = new byte[20];
            String dataToString = new String();
            fis.read(data);
            for (int i = 0; i < 20; i++) {
                dataToString += String.format("%x", data[i]).toUpperCase();
            }
            return dataToString;
        }
    }

    public String findSignature(String path) throws FileNotFoundException, IOException {
        final String search = this.readFile(path);

        for(Map.Entry mp: this._signatures.entrySet()) {
            if (search.contains((String)mp.getValue())) {
                return ((String)mp.getKey());
            }            
        }
        return "UNDEFINED";
    }

    public void loop() throws FileNotFoundException, IOException {
        byte[] nl = new byte[1];
        nl[0] = '\n';
        try (FileOutputStream fis = new FileOutputStream("ex00/result.txt")) {
            while (true) {
                System.out.print("-> ");
                String file = input.nextLine();
                if (file.equals("42")) {
                    break ;
                }
                String res = findSignature(file);
                fis.write(res.getBytes());
                fis.write(nl);
                System.out.println("PROCESSED");
            }
        }
    }

}
