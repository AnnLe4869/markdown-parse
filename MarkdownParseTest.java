import java.io.IOException;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(3, 1 + 1);
    }

    public static String getContentFromFile(String filePath) throws Exception {
        Path fileName = Path.of(filePath);

        String contents = Files.readString(fileName);


        return contents;
    }

    @Test
    public void testGetLinks1() throws IOException {
        try {
            String contents = getContentFromFile("test-file.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            List<String> linksTest =
                    List.of("https://something.com", "some-page.html");
            assertEquals(linksTest, links);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetLinks2() throws IOException {
        try {
            String contents = getContentFromFile("test-file2.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);

            assertEquals(null, links);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetLinks3() throws IOException {
        try {
            String contents = getContentFromFile("test-file3.md");
            ArrayList<String> links = MarkdownParse.getLinks(contents);
            assertEquals(null, links);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        assertEquals(null, links);
    }

    @Test
    public void testGetLinks5() throws IOException {
        Path fileName = Path.of("test-file5.md");
        String contents = Files.readString(fileName);
        List<String> links = MarkdownParse.getLinks(contents);
        assertEquals(null, links);
    }

}