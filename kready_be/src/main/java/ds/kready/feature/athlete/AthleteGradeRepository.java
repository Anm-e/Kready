package ds.kready.feature.athlete;

import ds.kready.feature.athlete.model.AthleteGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AthleteGradeRepository extends JpaRepository<AthleteGrade, Long> {
}
