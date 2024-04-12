import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class EmployeeDA {
    private Employee employee;
            public EmployeeDA(String empNo){
                try {
                   Scanner employeeFile = new Scanner(new FileReader("src/emp.csv"));


                   while (employeeFile.hasNextLine()){
                       String[] employeeLineData = employeeFile.nextLine().split(",", 4);

                       if(empNo.equals(employeeLineData[0].trim())){
                           employee = new Employee();
                           employee.setEmpNo(empNo);
                           employee.setLastName(employeeLineData[1].trim());
                           employee.setFirstName(employeeLineData[2].trim());
                           break;

                       }
                   }
                    employeeFile.close();
                }
                catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            public Employee getEmployee(){
                return employee;
            }
}
