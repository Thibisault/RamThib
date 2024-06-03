//path: back/demo/controller/FactureController.java
package com.payfip.payfip.controller;

import com.payfip.payfip.dto.FactureDto;
import com.payfip.payfip.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

@RestController
@RequestMapping("/api/facture")
public class FactureController {

    @Autowired
    private FactureService factureService;

    @GetMapping("/un")
    public String un() {
        return "deux";
    }
    // Create
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FactureDto> createFacture(@RequestBody FactureDto factureDto) {
        System.out.println("Je susi dans le créer facture");
        FactureDto createdFactureDto = factureService.createFacture(factureDto);
        return ResponseEntity.ok(createdFactureDto);
    }

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<FactureDto> getFactureById(@PathVariable Long id) {
        FactureDto factureDto = factureService.getFactureById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
        return ResponseEntity.ok(factureDto);
    }

    @GetMapping
    public ResponseEntity<List<FactureDto>> getAllFactures() {
        System.out.println("Entrée dans la méthode getAllFactures");
        List<FactureDto> factureDtos = factureService.getAllFactures();
        System.out.println("Factures récupérées: " + factureDtos);
        return ResponseEntity.ok(factureDtos);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<FactureDto> updateFacture(@PathVariable Long id, @RequestBody FactureDto factureDto) {
        FactureDto updatedFactureDto = factureService.updateFacture(factureDto);
        return ResponseEntity.ok(updatedFactureDto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return ResponseEntity.ok().build();
    }

    // Check by reference and amount
    @GetMapping("/checkReferenceFacture")
    public ResponseEntity<Boolean> checkReferenceFactureAndMontant(@RequestParam String referenceFacture, @RequestParam Double montantFacture) {
        System.out.println("Je suis dans le controller facture checkReferenceFacture : " + referenceFacture);
        System.out.println("Montant facture : " + montantFacture);
        FactureDto factureDto = factureService.getFactureByReferenceFacture(referenceFacture).orElseThrow(() -> new RuntimeException("Facture not found"));
        boolean matches = factureService.matcheReferenceFactureAndMontant(factureDto, montantFacture);
        System.out.println("Le boolean est : " + matches);
        return ResponseEntity.ok(matches);
    }
}