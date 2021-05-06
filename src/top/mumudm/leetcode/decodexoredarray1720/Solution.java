package top.mumudm.leetcode.decodexoredarray1720;

import java.util.Arrays;

/**
 * @author mumu
 * @date 2021-5-6 15:45
 */
public class Solution {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        int[] arr = new int[n];
        arr[0] = first;
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
    

    /**
     * 【a^b = c ， a^b^b = a， 即 c^b=a 同理 c^a =b】
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] decode = solution.decode(new int[]{1, 2, 3}, 1);
        System.out.println(Arrays.toString(decode));
        decode = solution.decode(new int[]{6, 2, 7, 3}, 4);
        System.out.println(Arrays.toString(decode));
        
        // System.out.println(1 ^ 2);
        // System.out.println(3 ^ 2);
        //
        int[] arr = {1, 2, 3};
        int[] encoded = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int encode = arr[i] ^ arr[i + 1];
            System.out.println(encode);
            arr[i] = encode;
            encoded[i] = encode;
        }

        System.out.println(Arrays.toString(encoded));
    }
}
