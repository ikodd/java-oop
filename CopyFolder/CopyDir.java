package inout;

import java.io.File;
import java.io.IOException;
/*
*    Методы:
*   1) копирование содержимого папки;
*   2) копирование файла
*   Используется класс StreamService
*/

public class CopyDir {
    // Метод: копирование содержимого папок
    public static void dirCopy(File dir1, File dir2, String[] arrSelCopy) throws IOException {
        for(String fileName : arrSelCopy){
            copyFile(dir1,dir2,fileName);
        }
    }

    // Метод: копирование файла
    public static void copyFile(File dir1, File dir2, String fileName) throws IOException{
        try{
            String filePath1 = dir1 + "/" + fileName;
            String filePath2 = dir2 + "/" + fileName;
            File fin = new File(filePath1);
            File fout = new File(filePath2);
            StreamService.fileCopy(fin,fout);
        }catch(IOException e){
            throw e;
        }
    }
}
