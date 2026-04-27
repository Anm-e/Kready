package ds.kready.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GradeAssignmentDto {
    private Long athleteId;
    private Long gradeId;
    private LocalDate date;
}
