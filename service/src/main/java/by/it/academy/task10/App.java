package by.it.academy.task10;

public class App {
    public static void main(String[] args) {
        RepositoryService service = new RepositoryService();
        service.addStudent("John", "Weak");
        service.addCourse("Java");
        service.mapStudentToCourse("John", "Weak", "Java");

    }

}
