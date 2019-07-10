package joop.collections;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

/*
*Метод для конвертации словаря
* из текстового файла в
* объект HashMap и его сохранение (сериализация)
*/

public class En2UkrServices implements Serializable {
    private static final long serialVersionUID = 1L;

       public static boolean txt2HmConv(File fDic, File fHm){
        try(BufferedReader br = new BufferedReader(new FileReader(fDic)); ObjectOutput oos = new ObjectOutputStream(new FileOutputStream(fHm))){
            String line = null;
            HashMap hm = new LinkedHashMap();
            while((line = br.readLine()) != null){
                String []arrWordline = line.split("\t"); // Разделение слов словаря на ключ-значение по \t (табулятор)
                if(arrWordline.length != 2)continue;
                hm.put(arrWordline[0],arrWordline[1]);
            }
            oos.writeObject(hm);
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
