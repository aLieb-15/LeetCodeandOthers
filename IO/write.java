package IO;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class write {

    public static void main(String[] args) {
        try (Writer output = new FileWriter("D:\\java learning\\IO\\tmp.txt");) {
            output.append("你好，我是乱码。");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("D:\\java learning\\IO\\tmp.txt");
        // OutputStreamWriter osw = new OutputStreamWriter(fos, "utf8");
        // BufferedOutputStream bos = new BufferedOutputStream(fos)
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "utf8"))){
            // osw.append("你好乱码");
            bw.write("hahahahah额 ");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        try (FileOutputStream fos = new FileOutputStream("D:\\java learning\\IO\\tmp.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "utf8"))){
            bw.write("hahahahah额 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}