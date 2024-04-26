package com.micro.userservice.usermicroservice.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "email_Address")
    private String emailAddress;
    @Column(name = "about")
    private String about;

    @Transient
    private List<Rating> ratings;

}
