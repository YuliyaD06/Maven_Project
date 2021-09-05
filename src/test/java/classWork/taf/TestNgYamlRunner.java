package classWork.taf;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestNgYamlRunner {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        final TestNG testNg = new TestNG(true);
        final Parser parser = new Parser("src/test/resources/testng.yaml");
        final List<XmlSuite> suites = parser.parseToList();
        testNg.setXmlSuites(suites);
        testNg.run();
    }
}
