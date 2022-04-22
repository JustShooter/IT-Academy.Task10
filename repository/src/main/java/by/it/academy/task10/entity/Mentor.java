package by.it.academy.task10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
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
}
