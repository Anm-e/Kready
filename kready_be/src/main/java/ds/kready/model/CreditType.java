package ds.kready.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credit_type")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreditType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Integer creditValue;
}
