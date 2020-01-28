package ua.genericcollection;

import java.util.Arrays;
import java.util.Comparator;

public class MainEmployee {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
                new Employee("John", 25, 3000.0, 9922001),
                new Employee("Ace", 22, 2000.0, 5924001),
                new Employee("Keith", 35, 4000.0, 3924401)};

        thenSortedByName(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }
        thenSortedByNameDesc(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);

        }


    }

    public static void thenSortedByName(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);

        Arrays.sort(employees, employeeNameComparator);

       // assertTrue(Arrays.equals(employees, sortedEmployeesByName));
    }

    public static  void thenSortedByNameDesc(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(
                Employee::getName, (s1, s2) -> {
                    return s2.compareTo(s1);
                });

        Arrays.sort(employees, employeeNameComparator);

      //  assertTrue(Arrays.equals(employees, sortedEmployeesByNameDesc));
    }
    public static  void thenSortedByNameReversedDesc(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparatorReversed
                = employeeNameComparator.reversed();
        Arrays.sort(employees, employeeNameComparatorReversed);
        //assertTrue(Arrays.equals(employees, sortedEmployeesByNameDesc));
    }

    public static void thenSortedByAge(Employee[] employees) {
        Comparator<Employee> employeeAgeComparator
                = Comparator.comparingInt(Employee::getAge);

        Arrays.sort(employees, employeeAgeComparator);

       // assertTrue(Arrays.equals(employees, sortedEmployeesByAge));
    }

    public static  void thenSortedByMobile(Employee[] employees) {
        Comparator<Employee> employeeMobileComparator
                = Comparator.comparingLong(Employee::getMobile);

        Arrays.sort(employees, employeeMobileComparator);

      //  assertTrue(Arrays.equals(employees, sortedEmployeesByMobile));
    }
    public static  void thenSortedBySalary(Employee[] employees) {
        Comparator<Employee> employeeSalaryComparator
                = Comparator.comparingDouble(Employee::getSalary);

        Arrays.sort(employees, employeeSalaryComparator);

      //  assertTrue(Arrays.equals(employees, sortedEmployeesBySalary));
    }
}
