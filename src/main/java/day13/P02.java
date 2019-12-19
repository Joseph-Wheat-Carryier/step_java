package day13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        File file = new File("src/main/Destination/destP02.txt");
        try (FileOutputStream os = new FileOutputStream(file)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("输入字符串:");
            String str = scan.nextLine();
            byte[] getBytes = str.getBytes();
            int count = 1;
            for (int i = 0; i < getBytes.length; ) {
                if (count % 3 != 0) {
                    if (getBytes[i] < 0) {
                        os.write(getBytes[i]);
                        os.write(getBytes[i + 1]);
                        os.write(getBytes[i + 2]);
                        i += 3;
                    } else {
                        os.write(getBytes[i]);
                        i += 1;
                    }
                    count++;
                    System.out.print("1");
                } else if (count % 15 == 0) {
                    if (getBytes[i] < 0) {
                        os.write(getBytes[i]);
                        os.write(getBytes[i + 1]);
                        os.write(getBytes[i + 2]);
                        i += 3;
                    } else {
                        os.write(getBytes[i]);
                        i += 1;
                    }
                    count++;// 床前明月光疑是地上霜举头望明月低头思故乡
                    os.write('.');
                    os.write('\n');
                    System.out.print("5");
                } else {
                    if (getBytes[i] < 0) {
                        os.write(getBytes[i]);
                        os.write(getBytes[i + 1]);
                        os.write(getBytes[i + 2]);
                        i += 3;
                    } else {
                        os.write(getBytes[i]);
                        i += 1;
                    }
                    os.write(',');
                    System.out.print("3");
                    count++;
                }
                if ( (i > getBytes.length-2)&& (count-1)%15!=0) {
                    os.write('.');
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
