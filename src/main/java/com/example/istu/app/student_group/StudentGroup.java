package com.example.istu.app.student_group;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentGroup {
  @Id
  private String name;

}
