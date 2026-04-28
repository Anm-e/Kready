package ds.kready.feature.athlete;

import ds.kready.feature.athlete.dto.AthleteList;
import ds.kready.feature.athlete.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    @Query(value = """
    SELECT 
        CAST(a.id AS SIGNED) AS id,
        CONCAT(a.surname, " ", a.name) as name,
        (SELECT g.grade FROM athlete_grade ag JOIN grade g ON ag.grade = g.id 
         WHERE ag.athlete = a.id ORDER BY ag.date DESC LIMIT 1) AS grade,
        COALESCE((SELECT CAST(SUM(ct.credit_value) AS SIGNED) 
         FROM athlete_credit ac JOIN credit c ON ac.credit = c.id 
         JOIN credit_type ct ON c.type = ct.id WHERE ac.athlete = a.id), 0) AS credits
    FROM athlete a
    ORDER BY a.surname
    """, nativeQuery = true)
    List<AthleteList> findAthletes();
}
