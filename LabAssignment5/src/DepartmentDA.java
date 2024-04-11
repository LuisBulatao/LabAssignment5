import java.io.FileReader;
import java.util.*;
import java.util.HashMap;
import java.text.*;
import java.io.FileNotFoundException;

public class DepartmentDA {
    private DepartmentDA(){
        departmentda();
    }
    private void departmentda() {
            try {
                Scanner departmentFile = new Scanner(new FileReader("src/dep.csv"));

                while (departmentFile.hasNextLine()){
                    String[] departmentLineData = departmentFile.nextLine().split(",",3);
                    Department department = new Department();

                    department.setDepCode(departmentLineData[0].trim());
                    department.setDepName(departmentLineData[1].trim());
                    readDeadEmp(department);
//                    printDepartment(department);
                }
            }
            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    private void readDeadEmp(Department department) {
            try {
                Scanner departmentEmployeeFile = new Scanner(new FileReader("src/deptemp.csv"));
                departmentEmployeeFile.hasNextLine();

                double totalSalary = 0.00;

                while(departmentEmployeeFile.hasNextLine()){
                    String[] departmentLineData = departmentEmployeeFile.nextLine().split(",",3);
                }


            }

            catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

}

