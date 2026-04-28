package ds.kready.feature.grade;

import ds.kready.feature.athlete.model.AthleteGrade;
import ds.kready.feature.grade.dto.GradeDetails;
import ds.kready.feature.grade.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("SELECT new ds.kready.feature.grade.dto.GradeDetails(g.grade, ag.date) " +
            "FROM AthleteGrade ag JOIN ag.grade g " +
            "WHERE ag.athlete.id = :athleteId ORDER BY ag.date DESC")
    List<GradeDetails> findGradeDetailsByAthleteId(@Param("athleteId") Long athleteId);
}
