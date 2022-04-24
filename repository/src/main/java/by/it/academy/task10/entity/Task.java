package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
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

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "report_task",
            joinColumns =@JoinColumn(name = "task_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "report_id", referencedColumnName = "id"))
    private Set<MarkReport> reports = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Task task = (Task) o;
        return id != null && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
