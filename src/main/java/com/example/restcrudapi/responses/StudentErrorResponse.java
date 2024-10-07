package com.example.restcrudapi.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentErrorResponse {

    private int status;
    private String errorMessage;
    private long timestamp;
}
