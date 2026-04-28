package ds.kready.controller;

import ds.kready.dto.CreditCreation;
import ds.kready.model.Credit;
import ds.kready.model.CreditType;
import ds.kready.repository.CreditRepository;
import ds.kready.repository.CreditTypeRepository;
import ds.kready.service.CreditService;
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

}
