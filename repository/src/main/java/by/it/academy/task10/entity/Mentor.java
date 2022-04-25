package by.it.academy.task10.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("M")
public class Mentor extends User {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseMentor;

    @ManyToMany
    @JoinTable(name = "mentor_report",
            joinColumns =@JoinColumn(name = "mentor_id"), inverseJoinColumns = @JoinColumn(name = "report_id"))
    private Set<MarkReport> reports = new HashSet<MarkReport>();
}
