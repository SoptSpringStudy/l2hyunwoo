package kr.co.marubook.javaspringboot.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HelloWorldDto {
    private String message;

    // AllArgsConstructor 덕분에 이거 안 적어도 됨
    // public HelloWorldDto(String msg) { this.message = msg }
}
