package ma.meriem.hospitalProject.repositories;

import ma.meriem.hospitalProject.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
