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
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "course_title")
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin adminCourse;

    @OneToOne(mappedBy = "courseMentor")
    private Mentor mentorCourse;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
