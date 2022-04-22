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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "task_title")
    private String title;

//    @ManyToMany
//    @JoinTable(name = "student_task",
//            joinColumns =@JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
//    private Set<Student> tasks = new HashSet<Student>();

    @ManyToMany
    @JoinTable(name = "report_task",
            joinColumns =@JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<MarkReport> reports = new HashSet<MarkReport>();
}
