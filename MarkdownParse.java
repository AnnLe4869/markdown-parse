
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.*;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {

        ArrayList<String> toReturn = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<!!)\\[.+?\\]\\((\\S+?)\\)");
        Matcher matchers = pattern.matcher(markdown);
        for (int i = 0; matchers.find(); i++) {
            toReturn.add(matchers.group(i));
        }
        return toReturn;
    }

    public static String getContentFromFile(String filePath) throws Exception {
        Path fileName = Path.of(filePath);
        String contents = Files.readString(fileName);
        return contents;
    }

    public static void main(String[] args) throws IOException {
        try {
            String contents = getContentFromFile(args[0]);
            ArrayList<String> links = getLinks(contents);
            System.out.println(links);
        } catch (Exception ex) {

        }

    }
}