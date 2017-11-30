package sg.nus.iss.example.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMP")//, schema="HR")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String name;
    private long salary;
    
    @OneToOne 
    @JoinColumn(name="PSPACE_ID") 
    private ParkingSpace parkingSpace;
    
    @ManyToOne
    private Department department;
    
    @ManyToMany 
    private Collection<Project> projects;

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
    
    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
    
    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public void addProject(Project project) {
        if (!getProjects().contains(project)) {
            getProjects().add(project);
        }
        if (!project.getEmployees().contains(this)) {
            project.getEmployees().add(this);
        }
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public String toString() {
        return "Employee id: " + getId() + " name: " + getName() + 
               " with " + getParkingSpace();
    }
}