package joop.collections;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AsciiArtService {
/*
*Метод: конвертер текстового файла с ASCII Art
* в HashMap с сериализацией
*/

    public static boolean txt2Hm(File fName, File fHmName){
        try(BufferedReader br = new BufferedReader(new FileReader(fName)); ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(fHmName))){
            String line = null;
            StringBuilder sb = new StringBuilder();
            int asciiFHeight = 6; // Высота ASCII Art буквы
            int counter = 0;
            Map<String,String> hm = new HashMap<>();
            while((line = br.readLine()) != null){
                counter+= 1;
                sb.append(line);
                sb.append("\r\n");
                if(counter%asciiFHeight == 0) {
                    String[] arrEntry = sb.toString().split("::");
                    if (arrEntry.length == 2) hm.put(arrEntry[0], arrEntry[1]);
                    sb.delete(0, sb.length());
                }
            }
            oos.writeObject(hm);
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }

    /*
    * Метод: "построчная" запись ASCII Art букв в
    * 
    с ключами 0::0, ...0::6 ... str.length::6
    */
    public static Map<String,String> hashMLineByLine(String []letter, int i){
     Map<String,String> hm = new HashMap<>();
     for(int j = 0;j < letter.length;j++){
         hm.put(i +"::" + j,letter[j]);
     }
     return hm;
    }

}
