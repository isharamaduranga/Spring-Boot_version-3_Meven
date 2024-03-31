package com.lk.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tbl_teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"

    )
    private Long teacherId;
    private String firstName;
    private String lastName;

 /*   @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_Id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
*/
}
