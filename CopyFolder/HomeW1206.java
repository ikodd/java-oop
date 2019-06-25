/*
 *   Копирование файлов с заданным расширением из одного каталога в другой
 */
package inout;

import java.io.*;
import java.util.Arrays;

public class HomeW1206 {

    public static void main(String[] args) throws IOException{

        File dir1 = new File (System.getProperty("user.dir") + "/src/inout/" + "dirA");
        File dir2 = new File (System.getProperty("user.dir") + "/src/inout/" + "dirB");
        //Только файлы с этими расширениями будут копироваться
        String []fileExt = {"txt","png"};

try {
    if (dir1.isDirectory()) {
         String[] arrFiles = dir1.list(); // Список имен файлов (и папок), содержащихся в dirA
         String[] arrSel = new String[arrFiles.length]; // Инициализация пустого массива arrSel
         int cnt = 0; // Инициализация счетчика: будет использоваться для подсчета записанных имен файлов

        //Перебор имен файлов (папок) в dirA
        for (int i = 0; i < arrFiles.length; i++) {
            for (String ext : fileExt) {
                // Если расширение файла соответствует значениям из fileExt[]
if(arrFiles[i].endsWith("." + ext)){
    arrSel[cnt] = arrFiles[i];// ...его имя помещается в массив arrSel
    cnt+= 1;// Обновление счетчика: количество имен файлов с заданным расширением
    break;
}
            }
                  }

        arrSel = Arrays.copyOf(arrSel,cnt);// Копирование массива с отобранными файлами в массив меньшего размера – ячейки с null в "хвосте" отсекаются

        if(!dir2.exists())dir2.mkdir();
        CopyDir.dirCopy(dir1,dir2,arrSel);

        }
}catch (IOException e){
    throw e;
}
    }
}
