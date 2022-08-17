package pro.Sky.ListsHomeWork.Service;

import org.springframework.stereotype.Service;
import pro.Sky.ListsHomeWork.Exception.EmployeeAlreadyAddedException;
import pro.Sky.ListsHomeWork.Exception.EmployeeNotFoundException;
import pro.Sky.ListsHomeWork.Model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.add(employee);
        }
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> printList() {
        return employees;
    }
}
