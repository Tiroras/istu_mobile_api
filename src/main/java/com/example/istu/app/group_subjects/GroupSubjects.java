package com.example.istu.app.group_subjects;


import com.example.istu.app.professor.Professor;
import com.example.istu.app.student_group.StudentGroup;
import com.example.istu.app.subject.Subject;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class GroupSubjects {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  @JoinColumn(name = "group_name", referencedColumnName = "name")
  private StudentGroup group;
  @ManyToOne
  @JoinColumn(name = "subject_name", referencedColumnName = "name")
  private Subject subject;
  @ManyToOne
  @JoinColumn(name = "professor_id", referencedColumnName = "id")
  private Professor professor;
}
