package ds.kready.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AthleteList {
    private Long id;
    private String name;
    private String grade;
    private Long credits;
}
