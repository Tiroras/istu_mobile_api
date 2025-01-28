package com.example.istu.app.professor;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Professor {
  @Id
  private long id;
  private String name;
  private String surname;
  private String patronymic;
  private String consultations;
  private String contactInfo;

}
