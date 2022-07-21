package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;
   @Column(name = "NAME")
   private String name;
   @Column(name="EMAIL")
   private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
