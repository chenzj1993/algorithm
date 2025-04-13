package util;

import java.util.ArrayList;

public class GetTypeArrayFromArrayList {
    public static int[] getArray(ArrayList arrayList) {
        int[] result = arrayList.stream().mapToInt(i -> (int) i).toArray();
        return result;
    }

    public static void main(String[] args) {
        ArrayList arrayList = GetRandomArray.getRandomArrayList(10, 50, 0);
        var cls = new GetTypeArrayFromArrayList();
        var result = cls.getArray(arrayList);
        for (int i =0;i<arrayList.size();i++){
            System.out.println(result[i]);
        }
    }
}
