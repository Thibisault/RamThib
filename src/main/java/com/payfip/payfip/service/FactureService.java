//path: src/main/java/com/payfip/payfip/service/FactureService.java
package com.payfip.payfip.service;

import com.payfip.payfip.dto.FactureDto;
import com.payfip.payfip.dto.FactureMapper;
import com.payfip.payfip.models.Facture;
import com.payfip.payfip.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        System.out.println("Before save: " + facture.toString());  // Assurez-vous que votre classe Facture a une méthode toString bien définie
        Facture savedFacture = factureRepository.save(facture);
        System.out.println("After save: " + savedFacture.toString());  // Idem pour Facture
        FactureDto resultDto = factureMapper.factureToFactureDto(savedFacture);
        System.out.println("Result DTO: " + resultDto.toString());  // Idem pour FactureDto
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