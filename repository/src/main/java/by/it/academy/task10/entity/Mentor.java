package by.it.academy.task10.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("M")
public class Mentor extends User {

    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MarkReport> markReports = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mentor mentor = (Mentor) o;
        return getId() != null
                && Objects.equals(getId(), mentor.getId())
                && Objects.equals(getName(), mentor.getName())
                && Objects.equals(getSurname(), mentor.getSurname());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
