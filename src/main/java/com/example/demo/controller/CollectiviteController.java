package com.example.demo.controller;

import com.example.demo.dto.CollectiviteDto;
import com.example.demo.entity.Collectivite;
import com.example.demo.service.CollectiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/collectivites")
public class CollectiviteController {

    @Autowired
    private CollectiviteService collectiviteService;

    @GetMapping
    public ResponseEntity<List<CollectiviteDto>> getAllCollectivite(){
        List<CollectiviteDto> collectiviteDtoList = collectiviteService.getAllCollectivite();
        return new ResponseEntity<>(collectiviteDtoList, HttpStatus.OK);
    }

    @GetMapping("/code/{codeCol}")
    public ResponseEntity<CollectiviteDto> getCollectiviteByCodeCol(@PathVariable int codeCol) {
        CollectiviteDto collectiviteDto = collectiviteService.getCollectiviteByCodeCol(codeCol);
        return new ResponseEntity<>(collectiviteDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CollectiviteDto> getCollectiviteById(@PathVariable Long id) {
        CollectiviteDto collectiviteDto = collectiviteService.getFatureById(id);
        return new ResponseEntity<>(collectiviteDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Collectivite> createdCollectivite(@RequestBody CollectiviteDto collectiviteDto){
        Collectivite savedCollectivite = collectiviteService.createNewCollectivite(collectiviteDto);
        return new ResponseEntity<>(savedCollectivite, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collectivite> updateCollectivite(@PathVariable Long id, @RequestBody CollectiviteDto collectiviteDto) {
        Collectivite updatedCollectivite = collectiviteService.updateCollectivite(id, collectiviteDto);
        return new ResponseEntity<>(updatedCollectivite, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllCollectivites() {
        collectiviteService.deleteAllCollectivite();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCollectivite(@PathVariable Long id) {
        collectiviteService.deleteCollectivite(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
