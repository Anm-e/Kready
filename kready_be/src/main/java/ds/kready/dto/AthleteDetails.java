package ds.kready.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleteDetails {
    private String name;
    private String surname;
    private LocalDate birthday;
    private LocalDate startDate;
    private String grade;
    private List<GradeDetails> previousGrades;
    private List<CreditDetails> credits;
    private Long totalCredits;
}
