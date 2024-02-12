package com.example.demo.service;

import com.example.demo.dto.FactureDto;
import com.example.demo.dto.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Facture;
import com.example.demo.repository.FactureRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureService
{
    @Autowired
    FactureRepository factureRepository;

    @Autowired
    FactureMapper factureMapper;

    public List<FactureDto> getAllFactureDtos() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream().map(factureMapper::factureToDto).collect(Collectors.toList());
    }

    public Facture getFactureByReference(long reference){
        return factureRepository.findByReference(reference);
    }

    public Facture getFatureById(Long id){
        return factureRepository.getById(id);
    }

    public Facture createNewFacture(FactureDto factureDto) {
        Facture facture = factureMapper.dtoToFacture(factureDto);
        return factureRepository.save(facture);
    }


    public Facture updateFacture(Long id, FactureDto factureDto) {
        Facture facture = factureRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Facture not found with id " + id));
        facture = factureMapper.dtoToFacture(factureDto);
        facture.setId(id);
        return factureRepository.save(facture);
    }
    public void deleteAllFactures() {
        factureRepository.deleteAll();
    }

    public void deleteFacture(Long id){
        factureRepository.deleteById(id);
    }

}
