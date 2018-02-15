package utils;

import java.io.*;

public class FileUtils {

    public static String getStringFileContent(String filePath){
        File file = new File(filePath);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            return reader.readLine();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.out.println(e.toString());
        } catch (IOException e) {
            System.out.println("An error ocurred when try to open the file");
            System.out.println(e.toString());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error ocurred when try to close the file");
                System.out.println(e.toString());
            }
        }
        return null;
    }
}
