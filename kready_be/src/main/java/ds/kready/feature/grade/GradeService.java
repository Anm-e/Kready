package ds.kready.feature.grade;

import ds.kready.feature.grade.dto.GradeAssignment;
import ds.kready.feature.athlete.model.Athlete;
import ds.kready.feature.athlete.model.AthleteGrade;
import ds.kready.feature.grade.model.Grade;
import ds.kready.feature.athlete.AthleteGradeRepository;
import ds.kready.feature.athlete.AthleteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final AthleteGradeRepository athleteGradeRepository;
    private final AthleteRepository athleteRepository;
    private final GradeRepository gradeRepository;

    public void assignGrade(GradeAssignment gradeAssignment){
        Optional<Athlete> athlete = athleteRepository.findById(gradeAssignment.getAthleteId());

        if(athlete.isEmpty()){
            return;
        }

        Optional<Grade> grade = gradeRepository.findById(gradeAssignment.getGradeId());

        if(grade.isEmpty()){
            return;
        }

        athleteGradeRepository.save(new AthleteGrade(null, athlete.get(), grade.get(), gradeAssignment.getDate()));
    }
}
