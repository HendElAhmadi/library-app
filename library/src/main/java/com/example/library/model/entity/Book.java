package com.example.library.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table(name = "BOOK")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Book extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = -3192275334782762715L;

    @Column(name="TITLE")
    private String title;

    @Column(name="AUTHOR")
    private String author;

    @Column(name="PUBLICATION_DATE")
    private LocalDate publicationDate;

    @Column(name="ISBN")
    private String internationalStandardBookNumber;
}
