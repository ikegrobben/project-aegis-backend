package com.springbootproject.aegis.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job")
public class JobRole {

    @Id
    @GeneratedValue
    Long id;

    String name;

    @OneToMany(mappedBy = "job")
    @JsonIgnore
    List<Users> users;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
