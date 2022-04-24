package by.it.academy.task10;


import by.it.academy.task10.dao.Dao;
import by.it.academy.task10.entity.Course;
import by.it.academy.task10.entity.Mentor;
import by.it.academy.task10.entity.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class RepositoryService {
    private final Dao<Student> studentDao = new Dao<>(Student.class);
    private final Dao<Course> courseDao = new Dao<>(Course.class);
    private final Dao<Mentor> mentorDao = new Dao<>(Mentor.class);

    /**
     * Adding new student by full name to database if not existed.
     *
     * @param studentName    Student name
     * @param studentSurname Student surname
     * @return True if operation was successful
     */
    public boolean addStudent(String studentName, String studentSurname) {
        if (getStudentIdByFullName(studentName, studentSurname) == null) {
            Student std = studentDao.create(Student.builder()
                    .name(studentName)
                    .surname(studentSurname)
                    .role("Student")
                    .build());
            return (std != null);
        } else {
            //TODO Add throw of some exception.
            System.out.println("Student already exist!");
        }
        return false;
    }

    /**
     * Adding new mentor by full name to database if not existed.
     *
     * @param mentorName    Mentor name
     * @param mentorSurname Mentro surname
     * @return True if operation was successful
     */
    public boolean addMentor(String mentorName, String mentorSurname) {
        if (getMentorIdByFullName(mentorName, mentorSurname) == null) {
            Mentor mntr = mentorDao.create(Mentor.builder()
                    .name(mentorName)
                    .surname(mentorSurname)
                    .role("Mentor")
                    .build());
            return (mntr != null);
        } else {
            //TODO Add throw of some exception.
            System.out.println("Mentor is already exist!");
        }
        return false;
    }

    /**
     * Adding new course by its title to database if not existed.
     *
     * @param courseTitle Course title
     * @return True if operation was successful
     */
    public boolean addCourse(String courseTitle) {
        if (getCourceIdByTitle(courseTitle) == null) {
            Course course = courseDao.create(Course.builder()
                    .title(courseTitle)
                    .build());
            return (course != null);
        } else {
            System.out.println("Course already exist!");
        }
        return false;
    }

    /**
     * Mapping student to course.
     *
     * @param studentName    Student name
     * @param studentSurname Student surname
     * @param courseTitle    Course title
     */
    public void mapStudentToCourse(String studentName, String studentSurname, String courseTitle) {
        Student stud = null;
        Course course = null;
        Integer studentId = getStudentIdByFullName(studentName, studentSurname);
        Integer courseId = getCourceIdByTitle(courseTitle);
        if (studentId != null) {
            try {
                stud = studentDao.findOne(studentId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //TODO Add throw of some exception.
            System.out.println("Such student is not exist!");
            return;
        }
        if (courseId != null) {
            try {
                course = courseDao.findOne(courseId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //TODO Add throw of some exception.
            System.out.println("Such course is not exist!");
            return;
        }
        Set<Course> set = stud.getCourses();
        if (set != null) {
            set.add(course);
        } else {
            set = Set.of(course);
        }
        stud.setCourses(set);
        studentDao.update(stud);
    }

    /**
     * Mapping mentor to course.
     *
     * @param mentorName    Mentor name
     * @param mentorSurname Mentor surname
     * @param courseTitle   Course title
     */
    public void mapMentorToCourse(String mentorName, String mentorSurname, String courseTitle) {
        Integer mentorId = getMentorIdByFullName(mentorName, mentorSurname);
        Integer courseId = getCourceIdByTitle(courseTitle);
        Mentor mentor = null;
        Course course = null;
        if (mentorId != null) {
            try {
                mentor = mentorDao.findOne(mentorId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            //TODO Add throw of some exception.
            System.out.println("Such mentor is not exist!");
            return;
        }
        if (courseId != null) {
            try {
                course = courseDao.findOne(courseId);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            //TODO Add throw of some exception.
            System.out.println("Such course is not exist!");
            return;
        }
        if (mentor.getCourseMentor() == null
                && course.getMentorCourse() == null) {
            mentor.setCourseMentor(course);
        } else {
            //TODO Add throw of some exception.
            if (mentor.getCourseMentor() != null) {
                System.out.println("Mentor already have course!");
            } else {
                System.out.println("Course already have mentor!");
            }
        }
    }

    /**
     * Searching for course by title in database,
     * returns Course id if existed, or null.
     *
     * @param courseTitle Course title
     * @return Integer ID of course or null
     */
    private Integer getCourceIdByTitle(String courseTitle) {
        List<Course> courseList = courseDao.findAll();
        Course course = courseList.stream()
                .filter(crs -> crs.getTitle().equals(courseTitle))
                .findFirst().orElse(null);
        Integer id = null;
        if (course != null) {
            id = course.getId();
        }
        return id;
    }

    /**
     * Searching for mentor by name and surname in database,
     * returns Mentor id if existed, or null.
     *
     * @param mentorName    Mentor name
     * @param mentorSurname Mentor surname
     * @return Integer ID of mentor or null
     */
    private Integer getMentorIdByFullName(String mentorName, String mentorSurname) {
        List<Mentor> mentorList = mentorDao.findAll();
        Mentor mentor = mentorList.stream()
                .filter(mntr -> mntr.getName().equals(mentorName)
                        && mntr.getSurname().equals(mentorSurname))
                .findFirst().orElse(null);
        Integer id = null;
        if (mentor != null) {
            id = mentor.getId();
        }
        return id;
    }

    /**
     * Searching for student by name and surname in database,
     * returns Student id if existed, or null.
     *
     * @param studentName    Student name
     * @param studentSurname Student surname
     * @return Integer ID of student or null
     */
    private Integer getStudentIdByFullName(String studentName, String studentSurname) {
        List<Student> studentList = studentDao.findAll();
        Student student = studentList.stream()
                .filter(stud -> stud.getName().equals(studentName)
                        && stud.getSurname().equals(studentSurname))
                .findFirst().orElse(null);
        Integer id = null;
        if (student != null) {
            id = student.getId();
        }
        return id;
    }


}
