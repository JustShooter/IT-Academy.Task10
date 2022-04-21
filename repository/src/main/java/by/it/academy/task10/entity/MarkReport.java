package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report")
public class MarkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "feedback")
    private String feedback;

    @ManyToMany
    @JoinTable(name = "student_report",
            joinColumns =@JoinColumn(name = "report_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> reports = new HashSet<Student>();

    @ManyToMany
    @JoinTable(name = "task_report",
            joinColumns =@JoinColumn(name = "report_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Set<Task> tasks = new HashSet<Task>();

    @ManyToMany
    @JoinTable(name = "mentor_report",
            joinColumns =@JoinColumn(name = "report_id"), inverseJoinColumns = @JoinColumn(name = "mentor_id"))
    private Set<Mentor> mentors = new HashSet<Mentor>();
}
