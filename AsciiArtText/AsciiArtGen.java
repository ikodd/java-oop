package joop.collections;
/*
* Текст ASCII Art
*
**/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AsciiArtGen {
    private File fAsciiFont; // Файл с символами ASCII Art, пары: символ (текст) – ASCII Art. Разделитель ::
    private File fAsciiHm; // Файл с объектом HashMap: символ (ключ) и значение (ASCII Art)

    public AsciiArtGen() {
        super();
    }

    public AsciiArtGen(File fAsciiFont, File fAsciiHm) {
        super();
        this.fAsciiFont = fAsciiFont;
        this.fAsciiHm = fAsciiHm;
    }

    public AsciiArtGen(String fAsciiFont, String fAsciiHm) {
        super();
        this.fAsciiFont = new File(fAsciiFont);
        this.fAsciiFont = new File(fAsciiHm);
    }

    public File getfAsciiFont() {
        return fAsciiFont;
    }

    public void setfAsciiFont(File fAsciiFont) {
        this.fAsciiFont = fAsciiFont;
    }

    public File getfAsciiHm() {
        return fAsciiHm;
    }

    public void setfAsciiHm(File fAsciiHm) {
        this.fAsciiHm = fAsciiHm;
    }
/*
* Метод: вывод текста ASCII Art в виде String
*/
    public String asciiFPrint(String str){
        //if(!getfAsciiHm().exists()||getfAsciiHm().length() < getfAsciiFont().length())AsciiArtService.txt2Hm(getfAsciiFont(),getfAsciiHm());
        AsciiArtService.txt2Hm(getfAsciiFont(),getfAsciiHm()); // Сериализация
        try(ObjectInput ois = new ObjectInputStream(new FileInputStream(getfAsciiHm()))){
            Map<String,String> hm = (HashMap<String,String>)ois.readObject();
            int asciiFHeight = 0;
            StringBuilder sb = new StringBuilder();
            Map<String,String> hmStr = new HashMap<>();

            for(int i = 0;i < str.length();i++){
                String []asciiLetter = (hm.get(Character.toString(str.charAt(i)).toUpperCase()) == null) ? hm.get(" ").split("\r\n") : hm.get(Character.toString(str.charAt(i)).toUpperCase()).split("\r\n"); // Текст в виде ASC Art заносится в массив
            hmStr.putAll(AsciiArtService.hashMLineByLine(asciiLetter,i)); // Буква ASCII Art состоит из 6 строк, в каждой 7-8 символов. Буквы последовательно слева-направо, сверху-вниз заносятся в HashMap. Ключи для первой буквы 0::0, 0::2 ... 0::6 и т.д.
            asciiFHeight = asciiLetter.length;
            }
                for(int j = 0;j < asciiFHeight;j++){
                    for(int i = 0;i < str.length();i++){
                        sb.append(hmStr.get(i + "::" + j)); // Построчная печать из HashMap
                    }
                    sb.append("\r\n");
                }
                return sb.toString();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}


