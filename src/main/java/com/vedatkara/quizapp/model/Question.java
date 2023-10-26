package com.vedatkara.quizapp.model;

//ORM: Object Relational Mapping

import jakarta.persistence.*;
import lombok.Data;

@Data //lombok
@Entity
@Table(name = "questions")
public class Question {

    @Id //Declaring that id is primary key.
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    /*
    @GeneratedValue annotation, the name itself suggests that it will generate something.
    This annotation is generally used in conjunction with @Id annotation to automatically
    generate unique values for primary key columns within our database tables
     */

    private Integer id;
    private String category;
    private String difficultylevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
    private String rightAnswer;
}
