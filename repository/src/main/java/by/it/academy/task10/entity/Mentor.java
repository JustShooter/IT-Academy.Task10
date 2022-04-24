package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@DiscriminatorValue("M")
public class Mentor extends User {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id")
    private Admin adminMentor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseMentor;

    @ManyToMany
    @JoinTable(name = "mentor_report",
            joinColumns =@JoinColumn(name = "mentor_id"), inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<MarkReport> reports = new HashSet<MarkReport>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Mentor mentor = (Mentor) o;
        return getId() != null && Objects.equals(getId(), mentor.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
