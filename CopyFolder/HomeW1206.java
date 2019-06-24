package inout;

import java.io.*;
import java.util.Arrays;
import inout.StreamService;

public class HomeW1206 {
    //protected static String []arrSelCopy;
    public static void main(String[] args) throws IOException{

        File dir1 = new File (System.getProperty("user.dir") + "/src/inout/" + "dirA");
        File dir2 = new File (System.getProperty("user.dir") + "/src/inout/" + "dirB");
        //Только файлы с этими расширениями будут копироваться
        String []fileExt = {"txt","png"};

try {
    if (dir1.isDirectory()) {
         String[] arrFiles = dir1.list();//Список имен файлов (и папок), содержащихся в dirA
        //Инициализация пустого массива arrSel
        String[] arrSel = new String[arrFiles.length];
        //Инициализация счетчика этого массива:
        //будет использоваться для подсчета записанных имен файлов
        int cnt = 0;
        //Перебор имен файлов (папок) в dirA
        for (int i = 0; i < arrFiles.length; i++) {
            for (String ext : fileExt) {
                //Если расширение файла соответствует значениям из fileExt[]
if(arrFiles[i].endsWith("." + ext)){
    //Его имя помещается в массив arrSel
    arrSel[cnt] = arrFiles[i];
    cnt+= 1;//Обновление счетчика
    break;
}
            }
                  }

        arrSel = Arrays.copyOf(arrSel,cnt);//Копирование массива с отобранными файлами в массив меньшего размера – ячейки с null в "хвосте" отсекаются
        System.out.println(Arrays.toString(arrFiles));
        System.out.println(Arrays.toString(arrSel));

        if(!dir2.exists())dir2.mkdir();
        dirCopy(dir1,dir2,arrSel);
        arrFiles = null;
        arrSel = null;
        dir1 = null;
        dir2 = null;
        }
}catch (IOException e){
    throw e;
}
    }

    //Метод: копирование содержимого папок
    public static void dirCopy(File dir1, File dir2, String[] arrSelCopy) throws IOException{
    for(String fileName : arrSelCopy){
        copyFile(dir1,dir2,fileName);
    }
    }

    //Метод: копирование файла
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
