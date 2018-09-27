/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;


/**
 *
 * @author mkonda
 */
@Entity
public class Employee {
    @Id
    @Column(name="ID", nullable = false, unique=true)
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator="empSeqGen")
    @SequenceGenerator(name = "empSeqGen", sequenceName = "EmployeeSequence", allocationSize = 1, initialValue= 1)
    private int empoyeeId =0;

    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(int empoyeeId) {
        this.empoyeeId = empoyeeId;
    }

    private String name = null;

    public Employee() {
    }

    public Employee(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
