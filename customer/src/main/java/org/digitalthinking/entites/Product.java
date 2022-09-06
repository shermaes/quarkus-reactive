package org.digitalthinking.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"customer", "product"})
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    @JsonBackReference
    private Customer customer;
    @Column
    private Long product;
    @Transient
    private String name;
    @Transient
    private String code;
    @Transient
    private String description;
}
