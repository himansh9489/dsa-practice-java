
/**
 * ThreeSum
 */
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        Integer arr[] = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        HashSet<ArrayList<Integer>> st = new HashSet<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                Integer third = -(arr[i] + arr[j]);
                if (mp.containsKey(third)) {
                    ArrayList<Integer> ls = new ArrayList<Integer>();
                    ls.add(arr[i]);
                    ls.add(arr[j]);
                    ls.add(third);
                    Collections.sort(ls);
                    st.add(ls);
                }
                mp.put(arr[j], i);
            }
        }
        ans.addAll(st);
        for (ArrayList<Integer> it : ans) {
            System.out.println(it.toString());
        }
    }
}