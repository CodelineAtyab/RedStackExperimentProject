package org.example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAll() {
        return employeeList;
    }

    public Optional<Employee> findById(String id) {
        return employeeList.stream()
                .filter(e -> e.id().equals(id))
                .findFirst();
    }

    public Employee create(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Optional<Employee> update(String id, Employee incoming) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).id().equals(id)) {
                Employee updated = new Employee(id, incoming.name(), incoming.role());
                employeeList.set(i, updated);
                return Optional.of(updated);
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(String id) {
        Optional<Employee> match = findById(id);
        if (match.isEmpty()) {
            return false;
        }
        return employeeList.removeIf(e -> e.id().equals(id));
    }

    public void deleteAll() {
        employeeList.clear();
    }
}