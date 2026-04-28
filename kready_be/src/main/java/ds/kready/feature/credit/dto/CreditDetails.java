package ds.kready.feature.credit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreditDetails {
    private Long id;
    private String type;
    private String place;
    private LocalDate date;
    private Long credits;
}
