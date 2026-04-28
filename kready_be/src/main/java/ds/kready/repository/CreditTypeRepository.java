package ds.kready.repository;

import ds.kready.model.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository extends JpaRepository<CreditType, Long> {
}
