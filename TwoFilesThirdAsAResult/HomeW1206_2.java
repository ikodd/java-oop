/*
 *   На вход подается два текстовых файла.
 *    В третий записываются одинаковые для двух первых файлов слова.
 *  Слова разделены одним пробелом
 */
package inout;

import java.io.*;
import java.util.Arrays;

public class HomeW1206_2 {
    public static void main(String[] args) throws IOException {
File f1 = new File(System.getProperty("user.dir") + "/src/inout/" + "text1.txt");
File f2 = new File(System.getProperty("user.dir") + "/src/inout/" + "text2.txt");
File f3 = new File(System.getProperty("user.dir") + "/src/inout/" + "text3.txt");
BufferedReader br1 = new BufferedReader(new FileReader(f1));
BufferedReader br2 = new BufferedReader(new FileReader(f2));

String[] arrText1 = BufferReader.bufferReader(br1);
Arrays.sort(arrText1);
arrText1 = ArrStrComparator.uniqueStrings(arrText1);


String[] arrText2 = BufferReader.bufferReader(br2);
Arrays.sort(arrText2);
arrText2 = ArrStrComparator.uniqueStrings(arrText2);

 if(arrText1.length >= arrText2.length){
     String[] arrText3 = ArrStrComparator.equalWords(arrText1,arrText2);
 }

   String[] arrText3 = ArrStrComparator.equalWords(arrText2, arrText1);

 // Запись одинаковых для первых двух файлов слов в третий файл
 try{
     PrintWriter pw = new PrintWriter(f3);
     for(String word : arrText3){
        pw.print(word);
        pw.print(" "); // Разделение слов пробелом
     }
     pw.flush();
     pw.close();
 }catch (IOException e){
     throw e;
 }

    }

}
