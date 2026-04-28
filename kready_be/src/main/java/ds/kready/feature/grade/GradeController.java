package ds.kready.feature.grade;

import ds.kready.feature.grade.dto.GradeAssignment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Grade")
@RequestMapping("grade")
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;

    @Operation(summary = "Assign a Grade to an Athlete")
    @PostMapping("assign")
    public void addGrade(@RequestBody GradeAssignment gradeAssignment){
        gradeService.assignGrade(gradeAssignment);
    }
}
