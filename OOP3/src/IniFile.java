import java.io.*;
import java.util.Scanner;

class IniFile {
    private String line;
    private File file;
    private BufferedReader br;
    private Scanner scanner;

    IniFile(String _path) throws Exception {
        try {
            if (!(_path.matches(".+\\.ini"))) {
                throw new Exception("FileFormatException: just .ini files");
            }
            file = new File(_path);
            scanner = new Scanner(file);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    void show() {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    void showSections() {

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.matches("^\\[[A-Za-z0-9_]+]\\s?;?"))
                    System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }


    private <T extends Object> T Converter(Class<T> clazz, String line) throws ClassCastException {
        if (clazz.getSimpleName().equals("int"))
            return (T) (Integer) Integer.parseInt(line);
        else if (clazz.getSimpleName().equals("float"))
            return (T) (Float) Float.parseFloat(line);
        else if (clazz.getSimpleName().equals("String"))
            return clazz.cast(line);
        else throw new ClassCastException("type '" + clazz.getSimpleName() + "' is not supported");
    }


    <T extends Object> T getValueFromSection(Class<T> clazz, String section, String parameter) throws Exception {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.matches("^\\[[A-Za-z0-9_]+]\\s?;?.*") && line.contains(section)) {
                    System.out.println(line);
                    line = "";
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        if (line.matches("^\\[[A-Za-z0-9_]+]\\s?;?.*"))
                            break;
                        if (line.matches("^[A-Za-z0-9]+=.*") && line.contains(parameter)) {
                            line = line.replaceAll("\\s*;.*", "");
                            System.out.println(line);
                            String[] word = line.split("=");
                            System.out.println(word[0]);
                            System.out.println(word[1]);
                            return Converter(clazz, word[1]);
                        }

                    }
                    throw new Exception("'" + parameter + "' is not found in [" + section + "]");
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        } catch (ClassCastException ex) {
            System.out.println("ClassCastException: " + ex.getMessage());
        }
        throw new Exception("Section [" + section + "] not found");
    }
}


