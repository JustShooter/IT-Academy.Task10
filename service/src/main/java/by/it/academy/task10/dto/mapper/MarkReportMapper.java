package by.it.academy.task10.dto.mapper;

import by.it.academy.task10.dto.MarkReportDto;
import by.it.academy.task10.entity.MarkReport;

public class MarkReportMapper {

    public static MarkReportDto mapFrom(MarkReport markReport) {
        return new MarkReportDto(markReport.getId(), markReport.getMark(), markReport.getFeedback(),
                StudentMapper.mapFrom(markReport.getStudent()),
                TaskMapper.mapFrom(markReport.getTask()),
                MentorMapper.mapFrom(markReport.getMentor()));
    }
}
