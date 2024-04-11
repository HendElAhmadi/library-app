package com.example.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serial;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatronDto extends BaseDto<Long>{

    @Serial
    private static final long serialVersionUID = -1130552586402320334L;

    private String name;

    private String contact;

    private String email;
}
