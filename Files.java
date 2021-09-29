package FileOperations;

import java.io.*;
import java.util.*;

public class Files {

    public static void createFile(String fileName) {
        try {
            File f0 = new File(fileName);
            if (f0.createNewFile()) {
                System.out.println("\nFile " + f0.getName() + " is created successfully.\n");
            } else {
                System.out.println("\nFile is already exist in the directory.\n");
            }
        } catch (IOException exception) {
            System.out.println("\nAn unexpected error is occurred.\n");
            exception.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String dataToBeWritten) throws IOException {
        try {
            FileWriter fwrite = new FileWriter(fileName);
            fwrite.write(dataToBeWritten);
            fwrite.close();
            System.out.println("\nContent has been successfully written to the file!\n");
        } catch (IOException exception) {
            System.out.println("\nUnexpected error occurred\n");
            exception.printStackTrace();
        }
    }

    public static void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void appendToFile(String fileName, String data) throws IOException {
        try {
            File file = new File(fileName);
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(data);
            br.close();
            fr.close();
        } catch (IOException exception) {
            System.out.println("\nUnexpected error occurred\n");
            exception.printStackTrace();
        }
    }

    public static void copyFile(String fileToBeCopied, String newFile) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(fileToBeCopied);
            fos = new FileOutputStream(newFile);
            int c;
            while ((c = fis.read()) != -1) {
                fos.write(c);
            }
            System.out.println("\nCopied the file successfully!\n");
        }

        finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    public static void removeSpecialCharactersAndTrimSpaces(String fileName) throws IOException {
        String dataToBeWritten = "";
        try {
            File f1 = new File(fileName);
            Scanner dataReader = new Scanner(f1);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                fileData = fileData.replaceAll("[^a-zA-Z0-9]", " ");
                fileData = fileData.replaceAll("\\s{2,}", " ");
                dataToBeWritten += fileData;
            }

            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("\nUnexcpected error occurred!\n");
            exception.printStackTrace();
        }

        try {
            FileWriter fwrite = new FileWriter(fileName);
            fwrite.write(dataToBeWritten);
            fwrite.close();
            System.out.println("\nFile has been formatted!!\n");
        } catch (IOException exception) {
            System.out.println("\nUnexpected error occurred\n");
            exception.printStackTrace();
        }
    }
}
