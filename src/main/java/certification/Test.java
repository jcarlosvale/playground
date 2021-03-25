package certification;

import java.util.Arrays;
import java.util.List;

class Test {
     public static void main(String[] args) {
//         String[] s_arr = new String[1];
//         String s = "ABC";
//         s_arr[0] = s;
//         concatenate(s_arr, s);
//         System.out.println(s + s_arr[0]);
         List<String> vals = Arrays.asList("a", "b");
         String join = vals.parallelStream().reduce("_", (a, b)->a.concat(b));
         System.out.println(join);         System.out.println("FIME");
     }
     static void concatenate(String[] s_arr, String s) {
         s = s + s_arr[0];
         s_arr[0] = s;
         s_arr = new String[1];
         s_arr[0] = "";
     }
}
