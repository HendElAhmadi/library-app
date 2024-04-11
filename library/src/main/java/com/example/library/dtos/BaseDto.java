package com.example.library.dtos;

import lombok.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto<ID extends Serializable> implements Serializable {

    @Serial
    private static final long serialVersionUID = -5358047312584615854L;

    private ID id;

}
