/*
* Печать текста ASCII Art
* Файлы:
* AsciiArtGen.java
* AsciiArtService.java – сервисные методы
* asciiabc.txt – ASCII Art алфавит
* asciiAbcHm – HashMap
 */
package joop.collections;

import java.io.File;

public class HomeW03074 {
    public static void main(String[] args) {
        String folder = System.getProperty("user.dir") + "/src/joop/collections/";
        File fAbc = new File(folder + "asciiabc.txt");
        File fHm = new File(folder + "asciiAbcHm");
AsciiArtGen asciiTxt = new AsciiArtGen(fAbc,fHm);
        System.out.println(asciiTxt.asciiFPrint("Java OOP"));;
    }
}
