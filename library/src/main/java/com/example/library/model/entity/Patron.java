package com.example.library.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
@Entity
@Table(name = "PATRON")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
public class Patron extends BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 8056845379826379960L;

    @Column(name="patron_name")
    private String name;

    @Column(name="contact")
    private String contact;

    @Column(name="email")
    private String email;


}
