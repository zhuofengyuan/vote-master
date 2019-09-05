package com.zhuofengyuan.mlszm.vote.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FengtoosException extends RuntimeException {

    private Integer code;
    private String message;

}
