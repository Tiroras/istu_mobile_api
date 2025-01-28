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


  public long getGradeBook() {
    return gradeBook;
  }

  public void setGradeBook(long gradeBook) {
    this.gradeBook = gradeBook;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public StudentGroup getStudentGroup() {
    return studentGroup;
  }

  public void setStudentGroup(StudentGroup studentGroup) {
    this.studentGroup = studentGroup;
  }

}
