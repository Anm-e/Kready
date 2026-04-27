package ds.kready.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "athlete_grade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AthleteGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "grade")
    private Grade grade;

    private LocalDate date;
}
