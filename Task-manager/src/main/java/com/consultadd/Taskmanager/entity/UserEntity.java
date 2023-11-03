package com.consultadd.Taskmanager.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    private Long user_id;

    @Column(unique = true)
    private String username;
    private String password;
}
