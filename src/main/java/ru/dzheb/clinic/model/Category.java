package ru.dzheb.clinic.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @Schema(name = "Id категории")
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private long id;
    @Column()
    private String category;

}

