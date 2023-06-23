import com.solvd.laba.model.Contact;
import com.solvd.laba.model.Credential;
import com.solvd.laba.model.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

class XMLHandler extends DefaultHandler {
    private StringBuilder content;
    private String currentElement;
    private List<Employee> employees;
    private Employee currentEmployee;
    private Contact currentContact;
    private Credential currentCredential;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        content = new StringBuilder();

        if ("employees".equals(qName)) {
            employees = new ArrayList<>();
        } else if ("employee".equals(qName)) {
            currentEmployee = new Employee();
        } else if ("contact".equals(qName)) {
            currentContact = new Contact();
        } else if ("credential".equals(qName)) {
            currentCredential = new Credential();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("id".equals(qName)) {
            Long id = Long.parseLong(content.toString().trim());
            if (currentEmployee != null) {
                currentEmployee.setId(id);
            } else if (currentContact != null) {
                currentContact.setId(id);
            } else if (currentCredential != null) {
                currentCredential.setId(id);
            }
        } else if ("name".equals(qName)) {
            String name = content.toString().trim();
            if (currentEmployee != null) {
                currentEmployee.setName(name);
            }
        } else if ("position".equals(qName)) {
            String position = content.toString().trim();
            if (currentEmployee != null) {
                currentEmployee.setPosition(position);
            }
        } else if ("email".equals(qName)) {
            String email = content.toString().trim();
            if (currentContact != null) {
                currentContact.setEmail(email);
            }
        } else if ("phone".equals(qName)) {
            String phone = content.toString().trim();
            if (currentContact != null) {
                currentContact.setPhone(phone);
            }
        } else if ("login".equals(qName)) {
            String login = content.toString().trim();
            if (currentCredential != null) {
                currentCredential.setLogin(login);
            }
        } else if ("password".equals(qName)) {
            String password = content.toString().trim();
            if (currentCredential != null) {
                currentCredential.setPassword(password);
            }
        } else if ("employee".equals(qName)) {
            employees.add(currentEmployee);
            currentEmployee = null;
        } else if ("contact".equals(qName)) {
            currentEmployee.setContact(currentContact);
            currentContact = null;
        } else if ("credential".equals(qName)) {
            currentEmployee.setCredential(currentCredential);
            currentCredential = null;
        } else if ("department".equals(qName)) {
            for (Employee employee : employees) {
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Position: " + employee.getPosition());

                Contact contact = employee.getContact();
                System.out.println("Contact ID: " + contact.getId());
                System.out.println("Contact Email: " + contact.getEmail());
                System.out.println("Contact Phone: " + contact.getPhone());

                Credential credential = employee.getCredential();
                System.out.println("Credential ID: " + credential.getId());
                System.out.println("Credential Login: " + credential.getLogin());
                System.out.println("Credential Password: " + credential.getPassword());

                System.out.println("--------");
            }
        }

    }
}