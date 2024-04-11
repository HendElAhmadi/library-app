package com.example.library.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDateTime;


@Entity
@Table(name = "BORROWING_RECORD")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class BorrowingRecord extends BaseEntity<Long>{

    @Serial
    private static final long serialVersionUID = -7795435321247744746L;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;

    @Column(name="return_date")
    private LocalDateTime returnDate;

    @Column(name="has_returned")
    private Boolean hasReturned;
}
