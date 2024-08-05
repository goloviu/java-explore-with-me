package ru.yandex.practicum.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hits")
public class Hit {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "app")
    private String app;

    @Column(nullable = false, name = "uri")
    private String uri;

    @Column(nullable = false, name = "ip")
    private String ip;

    @Column(nullable = false, name = "timestamp")
    private LocalDateTime timestamp;
}
