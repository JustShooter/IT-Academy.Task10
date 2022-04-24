package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;



@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@DiscriminatorValue("S")
public class Student extends User {

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Course> courses = new java.util.LinkedHashSet<>();

//    @ManyToMany
//    @JoinTable(name = "student_task",
//            joinColumns =@JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
//    private Set<Task> tasks = new HashSet<Task>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "student_report",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"))
    private Set<MarkReport> reports = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
