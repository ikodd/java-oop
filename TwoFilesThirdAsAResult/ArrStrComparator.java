package inout;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrStrComparator {
    /*
     *     Метод: поиск одинаковых слов
     *     в двух массивах и запись их
     *     в третий (на выходе)
     */
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

    /*
     *    Метод: отбор
     *    уникальных значений
     */
    public static String[] uniqueStrings(String[] arr){
        Set<String> temp = new LinkedHashSet<String>(Arrays.asList(arr));
        return temp.toArray(new String[temp.size()]);
    }
}
