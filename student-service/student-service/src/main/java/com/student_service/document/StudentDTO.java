package com.student_service.document;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class StudentDTO {

    private Long studentId;
    private String studentName;
    private String email;
    private String phone;
}
