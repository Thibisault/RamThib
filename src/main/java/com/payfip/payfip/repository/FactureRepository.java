//path: src/main/java/com/payfip/payfip/repository/FactureRepository.java
package com.payfip.payfip.repository;

import com.payfip.payfip.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
    Optional<Facture> findByReferenceFacture(String referenceFacture);
}
