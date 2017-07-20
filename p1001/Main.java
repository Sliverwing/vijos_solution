/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sliverwing
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int member_count = sc.nextInt();
        sc.nextLine();
        ArrayList<student> students = new ArrayList<>();
        for (int i = 0; i < member_count; i ++ ){
            

            String raw_input = sc.nextLine();
            
            String[] student_info = raw_input.split(" ");
            
            
//            System.out.println("i: " + i + Arrays.toString(student_info));

            String _name = student_info[0];
            int _avg_score = Integer.parseInt(student_info[1]);
            int _comm_score = Integer.parseInt(student_info[2]);
            boolean _is_off = "Y".equals(student_info[3]);
            boolean _is_from_west = "Y".equals(student_info[4]);
            int _pagers = Integer.parseInt(student_info[5]);
            student _std = new student(_name, _avg_score, _comm_score, _is_off, _is_from_west, _pagers);
            System.out.println(i + ": " + _std.bonus);
            students.add(_std);
        }
        
        int max = 0;
        String name = "";
        int total = 0;
        for (student student : students) {
            if (student.bonus > max) {
                max = student.bonus;
                name = student.name;
            }
            total += student.bonus;
        }
        System.out.println(name);
        System.out.println(max);
        System.out.println(total);

    }
}

class student {
    
    String name;
    int avg_score;
    int comm_score;
    boolean is_off;
    boolean is_from_west;
    int pagers;
    
    int bonus = 0;
    
    final int ACA_GRADE = 8000;
    final int YON_GRADE = 4000;
    final int SCO_EXEC_GRADE = 2000;
    final int WEST_GRADE = 1000;
    final int COMM_GRADE = 850;
    
    public student(String name, int avg_score, int comm_score, boolean is_off, boolean is_from_west, int papers){
        this.name = name;
        this.avg_score = avg_score;
        this.comm_score = comm_score;
        this.is_off = is_off;
        this.is_from_west = is_from_west;
        this.pagers = papers;
        
        this.cal();
    }
    
    public void cal(){
        int total = 0;
        if(this.is_aca_grade()){
            total += this.ACA_GRADE;
        }
        if (this.is_yon_grade()) {
            total += this.YON_GRADE;
        }
        if (this.is_sco_exec_grade()) {
            total += this.SCO_EXEC_GRADE;
        }
        if (this.is_west_grade()) {
            total += this.WEST_GRADE;
        }
        if (this.is_comm_grade()) {
            total += this.COMM_GRADE;
        }
        this.bonus = total;
    }
    
    public boolean is_aca_grade(){
        return this.avg_score > 80 && this.pagers > 0;
    }
    
    public boolean is_yon_grade(){
        return this.avg_score > 85 && this.comm_score > 80; 
    }
    
    public boolean is_sco_exec_grade(){
        return this.avg_score > 90;
    }
    
    public boolean is_west_grade() {
        return this.is_from_west && this.avg_score > 85;
    }
    
    public boolean is_comm_grade(){
        return this.is_off && this.comm_score > 80;
    }
}
