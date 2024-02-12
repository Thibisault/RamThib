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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
