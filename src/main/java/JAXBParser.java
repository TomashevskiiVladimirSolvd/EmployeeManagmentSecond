import com.solvd.laba.model.Contact;
import com.solvd.laba.model.Credential;
import com.solvd.laba.model.Department;
import com.solvd.laba.model.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBParser {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Department.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            File xmlFile = new File("src/main/resources/EmployeeManagment.xml");

            Department department = (Department) unmarshaller.unmarshal(xmlFile);

            Long id = department.getId();
            String name = department.getName();
            List<Employee> employees = department.getEmployees();

            System.out.println("Department ID: " + id);
            System.out.println("Department Name: " + name);

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
                System.out.println("--------");
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}







