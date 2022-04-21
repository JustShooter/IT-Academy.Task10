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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "admin_name")
    private String name;

    @Column(name = "admin_surname")
    private String surname;

    @OneToMany(mappedBy = "adminCourse", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<Course>();

    @OneToMany(mappedBy = "adminMentor", fetch = FetchType.LAZY)
    private Set<Mentor> mentors = new HashSet<Mentor>();
}
