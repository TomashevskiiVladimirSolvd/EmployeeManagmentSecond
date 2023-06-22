import com.solvd.laba.model.*;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "EmployeeManagement")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeManagementType {

    @XmlElement(name = "department")
    private Department department;

    @XmlElementWrapper(name = "employee")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    @XmlElementWrapper(name = "contact")
    @XmlElement(name = "contact")
    private List<Contact> contacts;

    @XmlElementWrapper(name = "credential")
    @XmlElement(name = "credential")
    private List<Credential> credentials;

    @XmlElementWrapper(name = "task")
    @XmlElement(name = "task")
    private List<Task> tasks;

}

