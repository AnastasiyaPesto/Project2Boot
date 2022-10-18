package ru.zentsova.springcourse.Project2Boot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "Person")
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле \"ФИО\" не должно быть пустым")
    @Column(name = "full_name", unique = true)
    private String fullName;

    @Min(value = 1900, message = "Год рождения не может быть меньше 1900")
    @Max(value = 2012, message = "Минимальный возраст пользователя должен быть больше или равно 10 лет")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Book> books;

    public Person(int id, String fullName, int yearOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

}