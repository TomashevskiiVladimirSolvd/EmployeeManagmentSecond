import com.solvd.laba.model.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "database")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatabaseType {

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;

    @XmlElementWrapper(name = "credentials")
    @XmlElement(name = "credential")
    private List<Credential> credentials;

    @XmlElementWrapper(name = "contacts")
    @XmlElement(name = "contact")
    private List<Contact> contacts;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    private List<Project> projects;

    @XmlElementWrapper(name = "tasks")
    @XmlElement(name = "task")
    private List<Task> tasks;

    @XmlElementWrapper(name = "employees_tasks")
    @XmlElement(name = "employees_task")
    private List<EmployeeTask> employeesTasks;


}
