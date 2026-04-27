package ds.kready.repository;

import ds.kready.dto.GradeDetails;
import ds.kready.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Query("SELECT ag.grade.grade FROM AthleteGrade ag " +
            "WHERE ag.athlete.id = :athleteId " +
            "ORDER BY ag.date DESC LIMIT 1")
    String findCurrentGradeNameByAthleteId(@Param("athleteId") Long athleteId);

    @Query("SELECT new ds.kready.dto.GradeDetails(g.grade, ag.date) " +
            "FROM AthleteGrade ag JOIN ag.grade g " +
            "WHERE ag.athlete.id = :athleteId ORDER BY ag.date DESC")
    List<GradeDetails> findGradeDetailsByAthleteId(@Param("athleteId") Long athleteId);
}
