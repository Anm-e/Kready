package ds.kready.service;

import ds.kready.dto.CreditCreation;
import ds.kready.model.Credit;
import ds.kready.model.CreditType;
import ds.kready.repository.CreditRepository;
import ds.kready.repository.CreditTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditService {
    private final CreditRepository creditRepository;
    private final CreditTypeRepository creditTypeRepository;

    public List<CreditType> getCreditTypes(){
        return creditTypeRepository.findAll();
    }

    public void createCredit(CreditCreation body){
        Credit credit = new Credit();

        credit.setDate(body.getDate());
        credit.setPlace(body.getPlace());

        credit.setCreditType(creditTypeRepository.findById(body.getCreditType()).get());

        creditRepository.save(credit);
    }

}
