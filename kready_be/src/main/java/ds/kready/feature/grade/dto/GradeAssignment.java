package ds.kready.feature.grade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeAssignment {
    private Long athleteId;
    private Long gradeId;
    private LocalDate date;
}
