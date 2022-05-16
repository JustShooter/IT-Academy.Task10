package by.it.academy.task10.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@SuperBuilder
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@DiscriminatorValue("A")
public class Admin extends User {

}
