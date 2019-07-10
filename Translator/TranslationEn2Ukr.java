/*
*Перевод текста: English.in – текстовый файл с переводимым текстом
* На выходе Ukrainian.out с переводом
* Словарь – dictionaryEn2Ukr.txt
*/
package joop.collections;


import java.io.*;
import java.util.*;


public class TranslationEn2Ukr implements Serializable {
    private static final long serialVersionUID = 1L;
    private File fDic; // Файл словаря
    private File fHmDic; // Файл словаря в виде объекта HashMap
    private File fIn; // Файл с текстом для перевода
    private File fOut; // Файл с переведенным текстом

    public TranslationEn2Ukr(File fDic, File fHmDic, File fIn, File fOut) {
        super();
        this.fDic = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fDic);
        this.fHmDic = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fHmDic);
        this.fIn = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fIn);
        this.fOut = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fOut);
    }
    public TranslationEn2Ukr(String fDic, String fHmDic, String fIn, String fOut) {
        super();
        this.fDic = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fDic);
        this.fHmDic = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fHmDic);
        this.fIn = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fIn);
        this.fOut = new File(System.getProperty("user.dir") + "/src/joop/collections/" + fOut);
    }
    public TranslationEn2Ukr() {
        super();
    }

    public File getfDic() {
        return fDic;
    }

    public void setfDic(File fDic) {
        this.fDic = fDic;
    }

    public File getfHmDic() {
        return fHmDic;
    }

    public void setfHmDic(File fHmDic) {
        this.fHmDic = fHmDic;
    }

    public File getfIn() {
        return fIn;
    }

    public void setfIn(File fIn) {
        this.fIn = fIn;
    }

    public File getfOut() {
        return fOut;
    }

    public void setfOut(File fOut) {
        this.fOut = fOut;
    }


public void translate(){
    if(getfHmDic() == null)En2UkrServices.txt2HmConv(getfDic(),getfHmDic()); // Сохранение текстового словаря в виде объекта HashMap (сериализация)
    StringBuilder sb = new StringBuilder();
    try(ObjectInput ois = new ObjectInputStream(new FileInputStream(getfHmDic()));BufferedReader br = new BufferedReader(new FileReader(getfIn())); PrintWriter pr = new PrintWriter(new FileWriter(getfOut()))){
        HashMap hm = (HashMap)ois.readObject();
        String line = null;
        List<String> ll = new LinkedList();
     while((line = br.readLine()) != null){
         ll = Arrays.asList(line.toLowerCase().split(" "));
         for(String word : ll){
            if(hm.containsKey(word)){
                pr.write(hm.get(word) + " ");
            }else{
                pr.write(word + " ");
            }
         }
         pr.write("\n");
     }
    }catch(IOException e){
        e.printStackTrace();
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }
    }
}
