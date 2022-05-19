package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.entity.MarkReport;

public class MarkReportMapper {
    private static final StudentMapper studentMapper = new StudentMapper();
    private static final MentorMapper mentorMapper = new MentorMapper();
    private static final TaskMapper taskMapper = new TaskMapper();

    public static MarkReportDto mapFrom(MarkReport markReport) {
        return new MarkReportDto(markReport.getId(), markReport.getMark(), markReport.getFeedback(),
                studentMapper.mapFrom(markReport.getStudent()),
                taskMapper.mapFrom(markReport.getTask()),
                mentorMapper.mapFrom(markReport.getMentor()));
    }
}
