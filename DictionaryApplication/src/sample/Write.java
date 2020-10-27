package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Write {

    public void write(String path, List<String> a){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File(path);
            FileWriter fw = new FileWriter(f);
            //Bước 2: Ghi dữ liệu
            for(String i:a){
                fw.write(i+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
}

