package utils;

import java.io.*;

public class FileUtils {

    /**
     * Method used to open a file and read the first line of it based on a given directory.
     * @param filePath Directory or name where the file is located
     * @return String with the first line of the file OR null if problem ocurred
     */
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
