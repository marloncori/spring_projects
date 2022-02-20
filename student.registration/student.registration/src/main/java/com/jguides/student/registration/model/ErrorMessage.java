package com.jguides.student.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private final String error1 = "STUDENT has not been found in the database.";
    private final String error2 = "STUDENTS have not been found in the database!";
    private final String error3 = "STUDENT is already present in the database!";

    private HttpStatus status;
    private String message;

}
