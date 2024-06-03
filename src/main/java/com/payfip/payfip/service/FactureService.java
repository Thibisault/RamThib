//path: src/main/java/com/payfip/payfip/service/FactureService.java
package com.payfip.payfip.service;

import com.payfip.payfip.dto.FactureDto;
import com.payfip.payfip.dto.FactureMapper;
import com.payfip.payfip.models.Facture;
import com.payfip.payfip.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private FactureMapper factureMapper;

    // Create
    public FactureDto createFacture(FactureDto factureDto) {
        Facture facture = factureMapper.factureDtoToFacture(factureDto);
        Facture savedFacture = factureRepository.save(facture);
        FactureDto resultDto = factureMapper.factureToFactureDto(savedFacture);
        return resultDto;
    }

    // Read
    public Optional<FactureDto> getFactureById(Long id) {
        Optional<Facture> facture = factureRepository.findById(id);
        return facture.map(factureMapper::factureToFactureDto);
    }

    public List<FactureDto> getAllFactures() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream().map(factureMapper::factureToFactureDto).collect(Collectors.toList());
    }

    public Optional<FactureDto> getFactureByReferenceFacture(String referenceFacture) {
        System.out.println("Je suis dans le getFactureByReferenceFacture : "+referenceFacture);
        Optional<Facture> facture = factureRepository.findByReferenceFacture(referenceFacture);
        return facture.map(factureMapper::factureToFactureDto);
    }

    // permet de verifier si le montant de la facture est le meme que celui de la factureDto
    public Boolean matcheReferenceFactureAndMontant(FactureDto factureDto, Double montantFacture){
        System.out.println("Je suis dans le matcheReferenceFactureAndMontant : "+factureDto.getMontantFacture());
        System.out.println("Je suis dans le matcheReferenceFactureAndMontant : "+montantFacture);
        return Objects.equals(factureDto.getMontantFacture(), montantFacture);
    }

    // Update
    public FactureDto updateFacture(FactureDto factureDto) {
        Facture facture = factureMapper.factureDtoToFacture(factureDto);
        Facture updatedFacture = factureRepository.save(facture);
        return factureMapper.factureToFactureDto(updatedFacture);
    }

    // Delete
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }
}