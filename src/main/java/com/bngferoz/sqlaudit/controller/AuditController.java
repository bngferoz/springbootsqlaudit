package com.bngferoz.sqlaudit.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bngferoz.sqlaudit.entity.Name;
import com.bngferoz.sqlaudit.jparepository.NameRepo;
import com.bngferoz.sqlaudit.requestModel.NameRequestDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("name")
@Tag(name = "1. Audit Controller", description = "Audit Related APIs")
public class AuditController {

	@Autowired
	NameRepo nameRepo;
	
	@Autowired
    ModelMapper modelMapper;
	
	@Tag(name = "sqlAudit001", description = "Save Name")
    @PostMapping()
	public boolean name(@RequestBody NameRequestDto reqObj) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Name objToSave = modelMapper.map(reqObj, Name.class);
        nameRepo.save(objToSave);
		return true;
	}
	
}
