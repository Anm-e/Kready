package ds.kready.service;

import ds.kready.dto.GradeAssignmentDto;
import ds.kready.model.Athlete;
import ds.kready.model.AthleteGrade;
import ds.kready.model.Grade;
import ds.kready.repository.AthleteGradeRepository;
import ds.kready.repository.AthleteRepository;
import ds.kready.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final AthleteGradeRepository athleteGradeRepository;
    private final AthleteRepository athleteRepository;
    private final GradeRepository gradeRepository;

    public void assignGrade(GradeAssignmentDto gradeAssignmentDto){
        Optional<Athlete> athlete = athleteRepository.findById(gradeAssignmentDto.getAthleteId());

        if(athlete.isEmpty()){
            return;
        }

        Optional<Grade> grade = gradeRepository.findById(gradeAssignmentDto.getGradeId());

        if(grade.isEmpty()){
            return;
        }

        athleteGradeRepository.save(new AthleteGrade(null, athlete.get(), grade.get(), gradeAssignmentDto.getDate()));
    }
}
