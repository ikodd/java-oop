package inout;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class HomeW1206_2 {
    public static void main(String[] args) throws IOException {
File f1 = new File(System.getProperty("user.dir") + "/src/inout/" + "text1.txt");
File f2 = new File(System.getProperty("user.dir") + "/src/inout/" + "text2.txt");
File f3 = new File(System.getProperty("user.dir") + "/src/inout/" + "text3.txt");
BufferedReader br1 = new BufferedReader(new FileReader(f1));
BufferedReader br2 = new BufferedReader(new FileReader(f2));

String[] arrText1 = bufferReader(br1);
Arrays.sort(arrText1);
arrText1 = uniqueStrings(arrText1);


String[] arrText2 = bufferReader(br2);
Arrays.sort(arrText2);
arrText2 = uniqueStrings(arrText2);

 if(arrText1.length >= arrText2.length){
     String[] arrText3 = equalWords(arrText1,arrText2);
 }

   String[] arrText3 = equalWords(arrText2, arrText1);

 //Запись одинаковых для первых двух файлов слов
 try{
     PrintWriter pw = new PrintWriter(f3);
     for(String word : arrText3){
        pw.print(word);
        pw.print(" ");//Разделение слов пробелом
     }
     pw.flush();
     pw.close();
 }catch (IOException e){
     throw e;
 }
        System.out.println(Arrays.toString(arrText1));
        System.out.println(Arrays.toString(arrText2));
        System.out.println("---");
        System.out.println(Arrays.toString(arrText3));
    }


//Метод: построчное чтение файла и занесение отдельных слов в массив
    public static String[] bufferReader(BufferedReader br) throws IOException{
        try{
            String[] arrText = new String[0];//Массив для слов первого файла
            String line = null;

            //Построчное чтение файла, слова из строки заносятся в words[]
            while((line = br.readLine()) != null){
                String[] words = line.split(" ");
                int lastCell = arrText.length;
//Создание копии arrText с переопределенными размерами (по количеству добавляемых строк)
                String[] arrTemp = Arrays.copyOf(arrText, arrText.length + words.length);
//Добавление слов строки в массив (копию)
                for(int i = 0;i < words.length;i++){
                    arrTemp[lastCell + i] = words[i];
                }
                arrText = arrTemp;
            }
            return arrText;

        }catch(IOException e){
            throw e;
        }
    }

    //Метод: поиск одинаковых слов в двух массивах и запись их в третий массив (на выходе)
   public static String[] equalWords(String[] arr1, String[] arr2){
        String[] arr3 = new String[arr1.length];
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0;i < arr1.length;i++){
            for(int j = cnt1;j < arr2.length;j++){
                if(arr1[i].equals(arr2[j])){
                    arr3[cnt2] = arr1[i];
                    cnt1 = j + 1;
                    cnt2 += 1;
                    break;
                }
            }
        }
        return Arrays.copyOf(arr3,cnt2);
   }

    //Метод: отбор уникальных значений
    public static String[] uniqueStrings(String[] arr){
        Set<String> temp = new LinkedHashSet<String>(Arrays.asList(arr));
        return temp.toArray(new String[temp.size()]);
    }
}
