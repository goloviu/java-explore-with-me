package ru.yandex.practicum.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Email(message = "Неверный формат записи почты пользователя")
    @Column
    private String email;

    @ColumnDefault("0")
    private Long rating;
}
