package kr.co.marubook.javaspringboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExceptionResponse {
    private Date timeStamp;
    private String message;
    private String details;
}
