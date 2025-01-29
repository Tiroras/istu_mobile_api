package com.example.istu.app.user;


import com.example.istu.app.student_group.StudentGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class User {

  @Id
  private long gradeBook;
  private String name;
  private String surname;
  private String patronymic;
  private String login;
  private String password;
  @ManyToOne
  @JoinColumn(name = "student_group", referencedColumnName = "name")
  private StudentGroup studentGroup;

}
