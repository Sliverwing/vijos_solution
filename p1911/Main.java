/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1911;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sliverwing
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        sc.nextLine();
        String s= sc.nextLine();
        int[] row = new int[total];
        int i = 0;
        for (String _num: s.split(" ")){
            row[i] = Integer.parseInt(_num);
            i++;
        }
        
        int[][] martix = {
            row,
            row,
            row
        };
        
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int matched_count = 0;
        int[] matched_number = new int[101];
        ArrayList<Integer> nums = new ArrayList<>();
        
        for (i=0;i<total;i++){
            p1 = martix[0][i];
            for (int j=0;j<total;j++) {
                p2 = martix[1][j];
                for (int k=0;k<total;k++){
                    sum = martix[2][k];
                    if (p1 != p2 && sum == (p1 + p2) && !nums.contains(sum)) {
                        matched_count ++;
                        nums.add(sum);
                    }
                }
            }
        }
        
        System.out.println(matched_count);
    }
}
