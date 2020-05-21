package zakuto.tehilimtr;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonthlyOrder {
    private static ArrayMap<String, Object> MonthlyOrderMap = new ArrayMap<String, Object>();
//    List<Map<String, String>> MonthlyOrderMap = new ArrayList<Map<String, String>>();

    public MonthlyOrder() {
        MonthlyOrderMap.put("1",1);
        MonthlyOrderMap.put("1",2);
        MonthlyOrderMap.put("1",3);
        //MonthlyOrderMap.put("Book1", 1,23,4,5);
    }
    public static int[] getMonthlyOrder(String bookNumber) {
        return (int[]) MonthlyOrderMap.get(bookNumber);
    }
}