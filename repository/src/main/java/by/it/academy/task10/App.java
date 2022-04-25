package by.it.academy.task10;

import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;
import by.it.academy.task10.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManager manager = HibernateUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(Student.builder()
                .name("John")
                .surname("Weak")
                .role("Student")
                .build());
        manager.persist(Student.builder()
                .name("John")
                .surname("Smith")
                .role("Student")
                .build());
        manager.persist(Student.builder()
                .name("Peter")
                .surname("Parker")
                .role("Student")
                .build());
        manager.persist(Student.builder()
                .name("Jonny")
                .surname("Silverhand")
                .role("Student")
                .build());
        manager.persist(Mentor.builder()
                .name("Gena")
                .surname("Vlasik")
                .role("Mentor")
                .build());
        manager.getTransaction().commit();
        List<Student> studentList = manager.createQuery("from " + Student.class.getName()).getResultList();
        Student std = studentList.stream()
                .filter(student -> student.getName().equals("Gena")
                        && student.getSurname().equals("Vlasik"))
                .findFirst().orElse(null);
        Integer id = null;
        if (std != null) {
            id = std.getId();
        }
        System.out.println(id);

        manager.close();
        HibernateUtil.close();

    }
}
