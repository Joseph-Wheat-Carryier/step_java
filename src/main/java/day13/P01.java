package day13;

import java.io.*;

public class P01 {
    static void read_write(File filesrc, File filedest) {
        if (!filesrc.isDirectory()) {
            if (filesrc.getName().endsWith(".java")) {
                int[] arr = new int[(int) filesrc.length()];
                try (FileReader fr = new FileReader(filesrc); BufferedReader bf = new BufferedReader(fr)) {
                    for (int i = 0; i < arr.length; i++) {
                        int temp = bf.read();
                        if (temp != -1) {
                            arr[i] = temp;
                        } else {
                            arr[i] = -1;
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (FileWriter fw = new FileWriter(filedest,true); BufferedWriter bw = new BufferedWriter(fw)) {
                    for (int value : arr) {
                        if (value != -1) {
                            bw.write(value);
                        }else {
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
            File []files = filesrc.listFiles();
            for(File file:files){
                read_write(file,filedest);
            }
        }
    }

    public static void main(String[] args) {
        File filesrc = new File("/Users/captain_cat/project/understand_java");
        File filedest = new File("src/main/Destination/destP01.txt");
        read_write(filesrc, filedest);
    }
}
