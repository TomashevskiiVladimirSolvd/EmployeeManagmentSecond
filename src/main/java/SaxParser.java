

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/EmployeeManagment.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            parser.parse(xmlFile, handler);
        } catch (Exception e) {
            System.out.println("Can't parse it");
        }
    }
}



