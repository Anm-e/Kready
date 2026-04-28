package ds.kready.feature.athlete;

import ds.kready.feature.athlete.dto.AthleteDetails;
import ds.kready.feature.athlete.dto.AthleteList;
import ds.kready.feature.athlete.model.Athlete;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Athlete")
@RequestMapping("athlete")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AthleteController {
    private final AthleteService athleteService;

    @Operation(summary = "get a list of athletes")
    @GetMapping()
    public List<AthleteList> getAthletes(){
        return athleteService.getAthletes();
    }

    @Operation(summary = "get an athlete details")
    @GetMapping("{id}")
    public AthleteDetails getAthleteDetails(@PathVariable("id") Long id){
        return athleteService.getAthleteDetails(id);
    }

    @Operation(summary = "insert a new athlete")
    @PostMapping()
    public Long createAthletes(@RequestBody Athlete athlete){
        return athleteService.createAthlete(athlete);
    }

    @Operation(summary = "update an athlete")
    @PutMapping("")
    public void updateAthlete(@RequestBody Athlete athlete){
        athleteService.updateAthlete(athlete);
    }

    @Operation(summary = "delete an athlete")
    @DeleteMapping("{id}")
    public void deleteAthlete(@PathVariable("id") Long id){
        athleteService.deleteAthlete(id);
    }
}
