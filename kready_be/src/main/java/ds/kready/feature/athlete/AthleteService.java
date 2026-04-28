package ds.kready.feature.athlete;

import ds.kready.feature.athlete.dto.AthleteDetails;
import ds.kready.feature.athlete.dto.AthleteList;
import ds.kready.feature.credit.CreditRepository;
import ds.kready.feature.credit.dto.CreditDetails;
import ds.kready.feature.grade.GradeRepository;
import ds.kready.feature.grade.dto.GradeDetails;
import ds.kready.feature.athlete.model.Athlete;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final GradeRepository gradeRepository;
    private final CreditRepository creditRepository;

    public List<AthleteList> getAthletes(){
        return athleteRepository.findAthletes();
    }

    public Long createAthlete(Athlete body){
        Athlete athlete = athleteRepository.save(body);

        return athlete.getId();
    }

    public void updateAthlete(Athlete athlete){
        athleteRepository.save(athlete);
    }

    public void deleteAthlete(Long id){
        Optional<Athlete> athlete = athleteRepository.findById(id);

        athlete.ifPresent(athleteRepository::delete);
    }

    public AthleteDetails getAthleteDetails(Long id){
        // 1. Recupero anagrafica base
        Athlete athlete = athleteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Atleta non trovato"));

        // 2. Recupero liste correlate usando i DTO che hai creato
        List<GradeDetails> grades = gradeRepository.findGradeDetailsByAthleteId(id);
        List<CreditDetails> credits = creditRepository.findCreditDetailsByAthleteId(id);

        // 3. Calcolo totali e grado attuale
        String currentGrade = grades.isEmpty() ? "Nessun Grado" : grades.get(0).getGrade();
        Long totalCredits = credits.stream()
                .mapToLong(CreditDetails::getCredits)
                .sum();

        // 4. Assemblaggio DTO finale
        return new AthleteDetails(
                athlete.getName(),
                athlete.getSurname(),
                athlete.getBirthday(),
                athlete.getStartDate(),
                currentGrade,
                grades,
                credits,
                totalCredits
        );
    }
}
