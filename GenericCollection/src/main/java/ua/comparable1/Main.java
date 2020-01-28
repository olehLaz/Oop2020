package ua.comparable1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {


    Employee[] employees = new Employee[]{
            new Employee("John", 25, 3000.0, 9922001),
            new Employee("Ace", 45, 2000.0, 5924001),
            new Employee("Jake", 25, 3000.0, 9922001),
            new Employee("Jake", 34, 3500.0, 9972891),
            new Employee("Keith", 35, 4000.0, 3924401),
            new Employee("null", 0, 0, 0),
    //        new Employee()
    };



    thenSortedByName(employees);
        for (int i = 0; i < employees.length; i++) {
        System.out.println(employees[i]);



    }
        System.out.println();
       thenSortedByNameDesc(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        System.out.println();
        thenSortedByNameAge(employees);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

        System.out.println("-------------------------");
        logger.info(" logger  ");
        System.out.println();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
        Arrays.sort(employees,Comparator.comparing(
                Employee::getMobile,
                (a, b) -> {
                    return CheckedNullforEmployee.checkedNullforEmployee(a, b) != CheckedNullforEmployee.NOT_NULL ? CheckedNullforEmployee.checkedNullforEmployee(a, b)
                            : a.compareTo(b);
                })
        );
        System.out.println("------------Employee::getMobile-------------------");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }




    public static void thenSortedByName(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> naturalOrder();

        Arrays.sort(employees, employeeNameComparator);

    }
    public void whenComparingWithComparator__thenSortedByNameDesc(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(
                Employee::getName, (s1, s2) -> {
                    return s2.compareTo(s1);
                });

        Arrays.sort(employees, employeeNameComparator);
    }

    public static void thenSortedByNameDesc(Employee[] employees) {
        Comparator<Employee> employeeNameComparator
                = Comparator.<Employee> reverseOrder();

        Arrays.sort(employees, employeeNameComparator);

    }
    public static void thenSortedByNameAge(Employee[] employees) {
        Comparator<Employee> employee__Name__Age__Comparator
                = Comparator.comparing(Employee::getName)
                .thenComparingInt(Employee::getAge);

        Arrays.sort(employees, employee__Name__Age__Comparator);


    }

    public static void whenComparingLong__thenSortedByMobile(Employee[] employees) {
        Comparator<Employee> employeeMobileComparator
                = Comparator.comparingLong(Employee::getMobile);

        Arrays.sort(employees, employeeMobileComparator);

    }

    public static void whenComparingDouble__thenSortedBySalary(Employee[] employees) {
        Comparator<Employee> employeeSalaryComparator
                = Comparator.comparingDouble(Employee::getSalary);

        Arrays.sort(employees, employeeSalaryComparator);


    }

    public static void thenSortedByNameWithNullsFirst(Employee[] employeesArrayWithNulls) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparator__nullFirst
                = Comparator.nullsFirst(employeeNameComparator);

        Arrays.sort(employeesArrayWithNulls,
                employeeNameComparator__nullFirst);


    }
    public static void whenNullsLast__thenSortedByNameWithNullsLast(Employee[] employeesArrayWithNulls) {
        Comparator<Employee> employeeNameComparator
                = Comparator.comparing(Employee::getName);
        Comparator<Employee> employeeNameComparator__nullLast
                = Comparator.nullsLast(employeeNameComparator);

        Arrays.sort(employeesArrayWithNulls, employeeNameComparator__nullLast);
    }

    }
