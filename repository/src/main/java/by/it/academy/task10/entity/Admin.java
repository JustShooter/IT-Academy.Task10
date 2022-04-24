package by.it.academy.task10.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@DiscriminatorValue("A")
public class Admin extends User {

//    @OneToMany(mappedBy = "adminCourse", fetch = FetchType.LAZY)
//    private Set<Course> courses = new HashSet<Course>();
//
//    @OneToMany(mappedBy = "adminMentor", fetch = FetchType.LAZY)
//    private Set<Mentor> mentors = new HashSet<Mentor>();
}
