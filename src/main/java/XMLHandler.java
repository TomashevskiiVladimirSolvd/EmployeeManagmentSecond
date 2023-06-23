import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class XMLHandler extends DefaultHandler {
    private StringBuilder content;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        content = new StringBuilder();
        System.out.println("Element: " + qName);

        if (attributes.getLength() > 0) {
            System.out.println("Attributes:");
            for (int i = 0; i < attributes.getLength(); i++) {
                String attributeName = attributes.getQName(i);
                String attributeValue = attributes.getValue(i);
                System.out.println(attributeName + ": " + attributeValue);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!content.toString().trim().isEmpty()) {
            System.out.println(currentElement + ": " + content.toString().trim());
        }
        currentElement = null;
    }
}