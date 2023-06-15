import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/main/resources/EmployeeManagment.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            Element rootElement = document.getDocumentElement();
            processElement(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processElement(Element element) {
        String elementName = element.getNodeName();
        System.out.println("Element: " + elementName);

        if (element.hasAttributes()) {
            System.out.println("Attributes:");
            for (int i = 0; i < element.getAttributes().getLength(); i++) {
                Node attribute = element.getAttributes().item(i);
                String attributeName = attribute.getNodeName();
                String attributeValue = attribute.getNodeValue();
                System.out.println(attributeName + ": " + attributeValue);
            }
        }

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);

            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) childNode;
                processElement(childElement);
            }
        }
    }
}
