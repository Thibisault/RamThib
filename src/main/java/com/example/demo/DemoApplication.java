package com.example.demo;

import com.example.demo.dto.CollectiviteDto;
import com.example.demo.dto.FactureDto;
import com.example.demo.entity.Collectivite;
import com.example.demo.entity.Facture;
import com.example.demo.repository.CollectiviteRepository;
import com.example.demo.repository.FactureRepository;
import com.example.demo.service.CollectiviteService;
import com.example.demo.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@SpringBootApplication(scanBasePackages={
        "package com.example.demo.dto.CollectiviteMapper", "package com.example.demo.dto.FactureMapper"})
public class DemoApplication {
    
    @GetMapping("/")
    public String firstLa(){
        return "Mister";
    }
    
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
