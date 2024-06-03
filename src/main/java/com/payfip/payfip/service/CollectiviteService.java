package com.payfip.payfip.service;

import com.payfip.payfip.dto.CollectiviteDto;
import com.payfip.payfip.dto.CollectiviteMapper;
import com.payfip.payfip.models.Collectivite;
import com.payfip.payfip.repository.CollectiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CollectiviteService {

    @Autowired
    private CollectiviteRepository collectiviteRepository;

    @Autowired
    private CollectiviteMapper collectiviteMapper;

    public CollectiviteDto createCollectivite(CollectiviteDto collectiviteDto) {
        Collectivite collectivite = collectiviteMapper.collectiviteDtoToCollectivite(collectiviteDto);
        Collectivite savedCollectivite = collectiviteRepository.save(collectivite);
        return collectiviteMapper.collectiviteToCollectiviteDto(savedCollectivite);
    }

    public Optional<CollectiviteDto> getCollectiviteById(Long id) {
        return collectiviteRepository.findById(id)
                .map(collectiviteMapper::collectiviteToCollectiviteDto);
    }

    public List<CollectiviteDto> getAllCollectivites() {
        return collectiviteRepository.findAll()
                .stream()
                .map(collectiviteMapper::collectiviteToCollectiviteDto)
                .collect(Collectors.toList());
    }

    public Optional<CollectiviteDto> getUserByCodeCollectivite(String codeCollectivite) {
        Optional<Collectivite> collectivite = collectiviteRepository.findByCodeCollectivite(codeCollectivite);
        return collectivite.map(collectiviteMapper::collectiviteToCollectiviteDto);
    }

    public CollectiviteDto updateCollectivite(Long id, CollectiviteDto collectiviteDto) {
        Collectivite collectivite = collectiviteMapper.collectiviteDtoToCollectivite(collectiviteDto);
        collectivite.setId(id); // Ensure the ID is set to the one provided
        Collectivite updatedCollectivite = collectiviteRepository.save(collectivite);
        return collectiviteMapper.collectiviteToCollectiviteDto(updatedCollectivite);
    }

    public void deleteCollectivite(Long id) {
        collectiviteRepository.deleteById(id);
    }
}
