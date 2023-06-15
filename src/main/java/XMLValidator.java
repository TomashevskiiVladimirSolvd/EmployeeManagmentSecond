import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.solvd.laba.model.Employee;
import org.xml.sax.SAXException;

import java.io.File;

public class XMLValidator {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/EmployeeManagment.xml";
        String xsdFilePath = "src/main/resources/EmployeeManagmentSchema.xsd";
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            JAXBContext jaxbContext = JAXBContext.newInstance(DatabaseType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            DatabaseType database = (DatabaseType) unmarshaller.unmarshal(new File(xmlFilePath));
            System.out.println("XML is valid.");
        } catch (SAXException e) {
            System.out.println("XML is invalid. Reason: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
