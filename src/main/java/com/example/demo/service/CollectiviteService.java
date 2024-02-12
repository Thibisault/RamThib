package com.example.demo.service;

import com.example.demo.dto.CollectiviteDto;
import com.example.demo.dto.CollectiviteMapper;
import com.example.demo.entity.Collectivite;
import com.example.demo.repository.CollectiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectiviteService {

    @Autowired
    CollectiviteRepository collectiviteRepository;

    @Autowired
    private CollectiviteMapper collectiviteMapper;

    public List<CollectiviteDto> getAllCollectivite() {
        List<Collectivite> collectivites = collectiviteRepository.findAll();
        return collectivites.stream().map(collectiviteMapper::collectiviteToDto).collect(Collectors.toList());
    }

    public Collectivite createNewCollectivite(CollectiviteDto collectiviteDto) {
        Collectivite collectivite = collectiviteMapper.dtoToCollectivite(collectiviteDto);
        return collectiviteRepository.save(collectivite);
    }

    public CollectiviteDto getCollectiviteByCodeCol(int codeCol){
        Collectivite collectivite = collectiviteRepository.findByCodeCol(codeCol);
        return collectiviteMapper.collectiviteToDto(collectivite);
    }

    public CollectiviteDto getFatureById(Long id){
        Collectivite collectivite = collectiviteRepository.getById(id);
        return collectiviteMapper.collectiviteToDto(collectivite);
    }

    public Collectivite updateCollectivite(Long id, CollectiviteDto collectiviteDto) {
        Collectivite collectivite = collectiviteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Collectivite not found with id " + id));
        collectivite.setCodeCol(collectiviteDto.getCodeCol());
        return collectiviteRepository.save(collectivite);
    }

    public void deleteAllCollectivite() {
        collectiviteRepository.deleteAll();
    }

    public void deleteCollectivite(Long id){
        collectiviteRepository.deleteById(id);
    }
}
