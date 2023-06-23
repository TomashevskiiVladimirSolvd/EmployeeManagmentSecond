import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    public static boolean validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlFilePath)));
        } catch (SAXException | IOException e) {
            System.out.println("Exception" + e.getMessage());
            ;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/EmployeeManagment.xml";
        String xsdFilePath = "src/main/resources/EmployeeManagmentSchema.xsd";
        boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
        System.out.println("XML is valid: " + isValid);
    }
}
