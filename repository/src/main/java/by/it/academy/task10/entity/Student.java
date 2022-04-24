package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("S")
public class Student extends User {

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<Course>();

//    @ManyToMany
//    @JoinTable(name = "student_task",
//            joinColumns =@JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
//    private Set<Task> tasks = new HashSet<Task>();

    @ManyToMany
    @JoinTable(name = "student_report",
            joinColumns =@JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<MarkReport> reports = new HashSet<MarkReport>();

}
