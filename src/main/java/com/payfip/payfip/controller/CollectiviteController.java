package com.payfip.payfip.controller;

import com.payfip.payfip.dto.CollectiviteDto;
import com.payfip.payfip.service.CollectiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collectivite")
public class CollectiviteController {

    @Autowired
    private CollectiviteService collectiviteService;

    @PostMapping
    public ResponseEntity<CollectiviteDto> createCollectivite(@RequestBody CollectiviteDto collectiviteDto) {
        CollectiviteDto createdCollectivite = collectiviteService.createCollectivite(collectiviteDto);
        return ResponseEntity.ok(createdCollectivite);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectiviteDto> getCollectiviteById(@PathVariable Long id) {
        CollectiviteDto collectiviteDto = collectiviteService.getCollectiviteById(id)
                .orElseThrow(() -> new RuntimeException("Collectivite not found"));
        return ResponseEntity.ok(collectiviteDto);
    }

    @GetMapping
    public ResponseEntity<List<CollectiviteDto>> getAllCollectivites() {
        List<CollectiviteDto> collectivites = collectiviteService.getAllCollectivites();
        return ResponseEntity.ok(collectivites);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CollectiviteDto> updateCollectivite(@PathVariable Long id, @RequestBody CollectiviteDto collectiviteDto) {
        CollectiviteDto updatedCollectivite = collectiviteService.updateCollectivite(id, collectiviteDto);
        return ResponseEntity.ok(updatedCollectivite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollectivite(@PathVariable Long id) {
        System.out.println("Je suis dans le controller deleteCollectivite : " + id);
        collectiviteService.deleteCollectivite(id);
        return ResponseEntity.noContent().build();
    }

    // Check by codeCollectivite
    @GetMapping("/checkCodeCollectivite")
    public ResponseEntity<Boolean> checkCodeCollectivite(@RequestParam String codeCollectivite) {
        System.out.println("Je suis dans le controller user checkcodeCollectivite : "+codeCollectivite);
        boolean exists = collectiviteService.getUserByCodeCollectivite(codeCollectivite).isPresent();
        System.out.println("Le boolean est : "+exists);
        return ResponseEntity.ok(exists);
    }

}
