package com.courseservice.document;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CourseDTO {
    private Long courseId;

    @NotBlank(message = "courseName should not be blank")
    private String courseName;

    @NotBlank(message = "courseDescription should not be blank")
    private String courseDescription;

    @NotBlank(message = "category should not be blank")
    private String category;


    private int durationInHours;
}
