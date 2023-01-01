package io.cherrytechnologies.abilitiesservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@ToString
public class ResponseDto<T> implements Serializable {
    private final Date date = new Date();
    private T data;

    public ResponseDto(T data) {
        this.data = data;
    }
}
