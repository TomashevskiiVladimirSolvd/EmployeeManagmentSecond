import com.solvd.laba.parsers.JAXBParser;
import com.solvd.laba.parsers.JSONParser;
import com.solvd.laba.parsers.SaxParser;

import static com.solvd.laba.validator.XMLValidator.validateXMLAgainstXSD;

public class Main {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/EmployeeManagment.xml";
        String xsdFilePath = "src/main/resources/EmployeeManagmentSchema.xsd";
        String jsonFilePath = "src/main/resources/EmployeeManagment.json";

        System.out.println("Validator implementation:");
        System.out.println("XML is valid: " + validateXMLAgainstXSD(xmlFilePath, xsdFilePath));

        System.out.println("SAX Parser implementation:");
        SaxParser saxParser = new SaxParser();
        saxParser.parseSaxXML(xmlFilePath);

        System.out.println("JAXB Parser implementation:");
        JAXBParser jaxbParser = new JAXBParser();
        jaxbParser.parseXML(xmlFilePath);

        System.out.println("JSON Parser implementation:");
        JSONParser jsonParser = new JSONParser();
        jsonParser.parseJSON(jsonFilePath);

    }
}
