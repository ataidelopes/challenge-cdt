package com.conductor.challengecdt.util.handler;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseError {

    private int code;
    private String description;
    private Map<String, String> fields;
    private LocalDateTime timestamp;

}