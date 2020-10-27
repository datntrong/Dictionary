package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Write {

    public void write(String path, List<String> a){
        try {

            File f = new File(path);
            FileWriter fw = new FileWriter(f);

            for(String i:a){
                fw.write(i+"\n");
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }

    public void writeData(String path, Map<String, Word> a){
        try {
            //Bước 1: Tạo đối tượng luồng và liên kết nguồn dữ liệu
            File f = new File(path);
            FileWriter fw = new FileWriter(f,true);
            //Bước 2: Ghi dữ liệu
            int j = 0;
            for(String i : a.keySet()){
                fw.write(i + "" + a.get(i).getWord_explain());
//                System.out.println(i + a.get(i).getWord_explain());
                if (j++ == 4) break;
            }
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi ghi file: " + ex);
        }
    }
}

