package com.example.library.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.io.Serial;
import java.time.LocalDate;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto extends BaseDto<Long>{

    @Serial
    private static final long serialVersionUID = 5881357477023618219L;


    private String title;

    private String author;

    private LocalDate publicationDate;

    private String internationalStandardBookNumber;
}
