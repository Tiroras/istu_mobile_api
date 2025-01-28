package com.example.istu.app.schedule;


import com.example.istu.app.student_group.StudentGroup;
import com.example.istu.app.subject.Subject;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Schedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "subject_name", referencedColumnName = "name")
  private Subject subject;
  private String room;
  private java.sql.Date date;
  private String timeStart;
  @ManyToOne
  @JoinColumn(name = "group_name", referencedColumnName = "name")
  private StudentGroup group;

}
