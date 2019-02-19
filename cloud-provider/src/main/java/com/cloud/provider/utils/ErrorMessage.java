package com.cloud.provider.utils;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class ErrorMessage<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 400;

    private Integer code;
    private String message;
    private String url;
    private T data;
}