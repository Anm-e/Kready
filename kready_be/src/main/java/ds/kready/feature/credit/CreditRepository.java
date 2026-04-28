package ds.kready.feature.credit;

import ds.kready.feature.credit.dto.CreditDetails;
import ds.kready.feature.credit.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    @Query("SELECT new ds.kready.feature.credit.dto.CreditDetails(" +
            "c.id, ct.type, c.place, c.date, CAST(ct.creditValue AS long)) " +
            "FROM AthleteCredit ac " +
            "JOIN ac.credit c " +
            "JOIN c.creditType ct " +
            "WHERE ac.athlete.id = :athleteId " +
            "ORDER BY c.date DESC")
    List<CreditDetails> findCreditDetailsByAthleteId(@Param("athleteId") Long athleteId);
}
