import java.io.*;
import java.util.Scanner;

public class Answer {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int total = 0;
        int current = 0;

        while(current <= a) {
            int _tmp = current;
            while (_tmp / 10.0 > 0) {
                if (_tmp % 10 == b) {
                    total++;
                }
                _tmp = _tmp / 10;
            }
            current ++;
        }
        System.out.println(total);
    }

}