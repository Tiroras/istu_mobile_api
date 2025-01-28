package com.example.istu.app.grades;


import com.example.istu.app.subject.Subject;
import com.example.istu.app.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grades {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "grade_book", referencedColumnName = "gradeBook")
  private User user;

  @ManyToOne
  @JoinColumn(name = "subject_name", referencedColumnName = "name")
  private Subject subject;

  private int grade;
}
