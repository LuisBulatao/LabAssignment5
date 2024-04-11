import java.io.FileReader;
import java.util.*;
import java.util.HashMap;
import java.text.*;
import java.io.FileNotFoundException;

public class DepartmentDA {
    public DepartmentDA() throws FileNotFoundException {
        departmentda();
    }

    private void departmentda() throws FileNotFoundException {
        Scanner departmentFile = new Scanner(new FileReader("src/dep.csv"));
        departmentFile.nextLine();

        while (departmentFile.hasNextLine()) {
            String[] departmentLineData = departmentFile.nextLine().split(",", 3);
            Department department = new Department();

            department.setDepCode(departmentLineData[0].trim());
            department.setDepName(departmentLineData[1].trim());
            readDeadEmp(department);
            printDepartment(department);
        }
    }

    private void readDeadEmp(Department department) throws FileNotFoundException {
        Scanner departmentEmployeeFile = new Scanner(new FileReader("src/deptemp.csv"));
        departmentEmployeeFile.hasNextLine();
        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        double totalSalary = 0.00;

        while (departmentEmployeeFile.hasNextLine()) {
            String[] departmentLineData = departmentEmployeeFile.nextLine().split(",", 3);

            if (department.getDepCode().trim().equalsIgnoreCase(departmentLineData[0].trim())) {
                String employeeNo = departmentLineData[1].trim();
                EmployeeDA empDa = new EmployeeDA(employeeNo);
                Employee employee = empDa.getEmployee();
                employee.setSalary(Double.parseDouble(departmentLineData[2].trim()));

                employeeHashMap.put(employeeNo, employee);
                totalSalary += employee.getSalary();
            }
        }
        department.setEmployeeMap(employeeHashMap);
        department.setDeptTotalSalary(totalSalary);
    }

    private void printDepartment(Department department) {
        DecimalFormat df = new DecimalFormat("#,###.00");

        System.out.println("Department Code: " + department.getDepCode());
        System.out.println("Department Name: " + department.getDepName());
        System.out.println("Department Total Salary: " + df.format(department.getDeptTotalSalary()));
        System.out.println("---------------------Details -------------------------");
        System.out.printf("%-10s %-20s %10s\n", "EmpNo", "EmployeeName", "Salary");

        for (Map.Entry<String, Employee> entryMap : department.getEmployeeMap().entrySet()) {
            Employee employee = entryMap.getValue();
            System.out.printf("%-10s %-20s %10s\n", entryMap.getKey(),
                    employee.getLastName() + ", " + employee.getFirstName(), df.format(employee.getSalary()));
        }
        System.out.println();
    }
    }




