
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class XMLValidator {

    public static boolean validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeManagementType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);

            EmployeeManagementType employeeManagement = (EmployeeManagementType) unmarshaller.unmarshal(new File(xmlFilePath));
            validator.validate((Source) unmarshaller.getUnmarshallerHandler().getResult());

            return true;
        } catch (JAXBException | SAXException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/EmployeeManagment.xml";
        String xsdFilePath = "src/main/resources/EmployeeManagmentSchema.xsd";
        boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
        System.out.println("XML is valid: " + isValid);
    }
}
