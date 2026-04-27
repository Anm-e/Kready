package ds.kready.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "athlete_credit")
@Getter
@Setter
public class AthleteCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "athlete")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "credit")
    private Credit credit;
}
