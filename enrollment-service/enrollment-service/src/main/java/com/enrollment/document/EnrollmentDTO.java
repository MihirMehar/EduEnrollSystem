package com.enrollment.document;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class EnrollmentDTO {

    private  Long enrollmentId;
    private  Long studentId;
    private  Long courseId;
    private LocalDate enrollmentDate;
}
