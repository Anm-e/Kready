package ds.kready.feature.credit;

import ds.kready.feature.credit.model.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository extends JpaRepository<CreditType, Long> {
}
