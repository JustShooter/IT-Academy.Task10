package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.TaskDto;
import by.it.academy.task10.entity.Task;

public class TaskMapper {

    CourseMapper courseMapper = new CourseMapper();

    public TaskDto mapFrom(Task task) {
        return new TaskDto(task.getId(), task.getTitle(),
                courseMapper.mapFrom(task.getTaskCourse()));
    }
}
