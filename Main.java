import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static StringBuilder log = new StringBuilder();
    public static void main(String[] args) throws IOException {
        final String gamesPath = "/Users/wisnap/Games";
        final String srcPath = "/Users/wisnap/Games/src";
        final String resPath = "/Users/wisnap/Games/res";
        final String mainPath = "/Users/wisnap/Games/src/main";
        final String tempPath = "/Users/wisnap/Games/temp";

        String[] gamesDirs = {"src", "res", "savegames", "temp"};
        String[] srcDirs = {"main", "test"};
        String[] resDirs = {"drawables", "vectors", "icons"};
        String[] mainFiles = {"Main.java", "Utils.java"};
        String[] tempFiles = {"temp.txt"};
        makeDirs(gamesDirs, gamesPath);
        makeDirs(srcDirs, srcPath);
        makeDirs(resDirs, resPath);
        makeFiles(mainFiles, mainPath);
        makeFiles(tempFiles, tempPath);
        File temp = new File(tempPath,"temp.txt");
        FileWriter writer = new FileWriter(temp);
        String text = String.valueOf(log);
        writer.write(text);
        writer.close();

        FileReader fr = new FileReader(temp);
        char [] a = new char[900];
        fr.read(a);
        for(char c : a)
            System.out.print(c);
        fr.close();

    }
    public static void makeDirs(String[] dirNames, String path) {
        for (String s : dirNames) {
            File newDir = new File(path, s);
            if (newDir.mkdir()) {
                log.append("Каталог " + s + " создан  \n");
            } else {
                log.append("Каталог " + s + " не создан  \n");
            }
        }
    }
    public static void makeFiles(String[] fileNames, String path) throws IOException {
        for (String s : fileNames) {
            File newFile = new File(path, s);
            try {
                newFile.createNewFile();
                log.append("Файл " + s + " был создан \n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
                log.append("Файл " + s + " не был создан \n");
            }
        }
    }
}
