package com.estore.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 40,nullable = false,unique = true)
    private String name;
    @Column(length = 1024,nullable = false,unique = true)
    private String description;

    public Role() {
        super();
    }
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
