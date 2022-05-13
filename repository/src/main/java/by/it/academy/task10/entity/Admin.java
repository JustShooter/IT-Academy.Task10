package by.it.academy.task10.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("A")
public class Admin extends User {


}
