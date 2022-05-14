package by.it.academy.task10.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("M")
public class Mentor extends User {

    @Builder.Default
    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    private Set<Course> courses = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    private Set<MarkReport> markReports = new HashSet<MarkReport>();
}
