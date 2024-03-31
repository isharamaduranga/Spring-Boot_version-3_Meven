package com.lk.springdatajpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "tbl_course_material")
@Builder
//@ToString(exclude = "course") //OPTION 01
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long  courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )

    //Uni directional mapping
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
                ", course=" + course.getCourseId() +//OPTION 02 GET SPECIFIC DETAILS IN COURSE
                '}';
    }
}