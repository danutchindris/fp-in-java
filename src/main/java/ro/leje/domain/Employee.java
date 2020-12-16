package ro.leje.domain;

import java.math.BigDecimal;

public class Employee {

    // TODO make fields final and remove the accessors
    private String name;
    private BigDecimal salary;

    public Employee(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
