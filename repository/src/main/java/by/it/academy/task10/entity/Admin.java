package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@DiscriminatorValue("A")
public class Admin extends User {

    @ToString.Exclude
    @OneToMany(mappedBy = "adminCourse")
    private Set<Course> courses = new java.util.LinkedHashSet<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "adminMentor")
    private Set<Mentor> mentors = new java.util.LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Admin admin = (Admin) o;
        return getId() != null && Objects.equals(getId(), admin.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
