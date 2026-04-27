package ds.kready.service;

import ds.kready.dto.AthleteDetails;
import ds.kready.dto.AthleteList;
import ds.kready.model.Athlete;
import ds.kready.repository.AthleteRepository;
import ds.kready.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AthleteService {
    private final AthleteRepository athleteRepository;
    private final GradeRepository gradeRepository;

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

    public Athlete getAthleteDetails(Long id){
        Optional<Athlete> oAthlete = athleteRepository.findById(id);

        if(oAthlete.isEmpty()){
            return null;
        }

        return oAthlete.get();
    }
}
