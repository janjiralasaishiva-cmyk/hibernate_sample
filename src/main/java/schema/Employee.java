package schema;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@Table(name = "ModifiedTable") // To change the table name
public class Employee {
    @Id
//    @Column(name = "student_id")
    private int sId;
//    @Column(name = "student_name")
    private String name;
//    @Column(name = "course_name")
    private String course;
//    @Transient // to do not add this particular column in the database
    private String tech;
    // One to One Relationship
    @OneToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;


    public Employee() {
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "SchemaModification{" +
                "sId=" + sId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", tech='" + tech + '\'' +
                ", laptop=" + laptop +
                '}';
    }

}
