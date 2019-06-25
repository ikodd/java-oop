package inout;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class BufferReader {
    /*
     *   Метод: построчное чтение файла
     *  и занесение отдельных слов в массив. Разделитель – один пробел
     */
    public static String[] bufferReader(BufferedReader br) throws IOException {
        try{
            String[] arrText = new String[0];//Массив для слов
            String line = null;

            // Построчное чтение файла, слова из строки заносятся в words[]
            while((line = br.readLine()) != null){
                String[] words = line.split(" "); // Отдельные слова строки определяются по наличию разделителя (одиночный пробел)
                int lastCell = arrText.length;

                String[] arrTemp = Arrays.copyOf(arrText, arrText.length + words.length); // Создание копии arrText с переопределенными размерами (по количеству добавляемых строк)
// Добавление слов строки в массив (копию)
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
}
