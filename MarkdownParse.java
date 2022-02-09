
// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.*;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {

        ArrayList<String> toReturn = new ArrayList<>();
        Pattern pattern = Pattern.compile("(?<!!)\\[\\w+\\]\\((\\w+)\\)");
        Matcher matchers = pattern.matcher(markdown);
        for (int i = 1; matchers.find(); i++) {
            toReturn.add(matchers.group(i));
        }
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        String file = "test-file.md";
        Path fileName = Path.of(file);
        String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}