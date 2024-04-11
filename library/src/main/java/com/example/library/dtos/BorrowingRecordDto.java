package com.example.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serial;
import java.time.LocalDateTime;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BorrowingRecordDto extends BaseDto<Long>{

    @Serial
    private static final long serialVersionUID = -281639340799589190L;

    private BookDto book;

    private PatronDto patron;

    private LocalDateTime returnDate;
}
