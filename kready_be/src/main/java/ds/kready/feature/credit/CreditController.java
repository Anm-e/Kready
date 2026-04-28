package ds.kready.feature.credit;

import ds.kready.feature.credit.dto.CreditAssignment;
import ds.kready.feature.credit.dto.CreditCreation;
import ds.kready.feature.credit.model.CreditType;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Credit")
@RequestMapping("credit")
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class CreditController {
    private final CreditService creditService;

    @PostMapping()
    public void createCredit(@RequestBody CreditCreation body){
        creditService.createCredit(body);
    }

    @GetMapping("type")
    public List<CreditType> getCreditTypes(){
        return creditService.getCreditTypes();
    }

    @PostMapping("assign")
    public void assignCredit(@RequestBody List<CreditAssignment> body){
        creditService.assignCredit(body);
    }

}
