package com.payfip.payfip.repository;

import com.payfip.payfip.models.Collectivite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CollectiviteRepository extends JpaRepository<Collectivite, Long> {
    Optional<Collectivite> findByCodeCollectivite(String codeCollectivite);
}
