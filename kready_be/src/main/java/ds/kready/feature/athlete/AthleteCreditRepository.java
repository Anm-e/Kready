package ds.kready.feature.athlete;

import ds.kready.feature.athlete.model.AthleteCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteCreditRepository extends JpaRepository<AthleteCredit, Long> {
}
