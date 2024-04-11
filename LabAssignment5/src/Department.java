import java.util.HashMap;
public class Department {
    private String depCode;
    private String depName;
    private Double deptTotalSalary = 0.00;
    private HashMap<String,Employee> employeeMap;

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setDeptTotalSalary(Double deptTotalSalary) {
        this.deptTotalSalary += deptTotalSalary;
    }

    public void setEmployeeMap(HashMap<String, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public Double getDeptTotalSalary() {
        return deptTotalSalary;
    }

    public HashMap<String, Employee> getEmployeeMap() {
        return employeeMap;
    }
}
