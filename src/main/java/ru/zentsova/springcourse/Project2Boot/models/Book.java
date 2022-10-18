package ru.zentsova.springcourse.Project2Boot.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "Book")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле \"Название книги\" не должно быть пустым")
    @Column(name = "title")
    @NonNull
    private String title;

    @NotEmpty(message = "Поле \"Автор\" не должно быть пустым")
    @Column(name = "author")
    @NonNull
    private String author;

    @Min(value = 1600, message = "Поле \"Год публикации\" не должно меньше, чем 1600 ")
    @Max(value = 2022, message = "Поле \"Год публикации\" не должно больше, чем 2022")
    @Column(name = "year_of_publication")
    @NonNull
    private int yearOfPublication;

    @Column(name = "time_taken")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeTaken;

    @Transient
    private boolean isExpired;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

}
