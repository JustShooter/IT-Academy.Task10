package by.it.academy.task10.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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

    @Builder.Default
    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Course> courses = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MarkReport> markReports = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mentor mentor = (Mentor) o;
        return courses.equals(mentor.courses) && markReports.equals(mentor.markReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses, markReports);
    }
}
