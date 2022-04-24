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
@Table(name = "report")
public class MarkReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "feedback")
    private String feedback;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "student_report",
            joinColumns =@JoinColumn(name = "report_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> reports = new java.util.LinkedHashSet<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "task_report",
            joinColumns =@JoinColumn(name = "report_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"))
    private Set<Task> tasks = new java.util.LinkedHashSet<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "mentor_report",
            joinColumns =@JoinColumn(name = "report_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "mentor_id", referencedColumnName = "id"))
    private Set<Mentor> mentors = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MarkReport that = (MarkReport) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
