package com.eyaoshun.activiti.oa.controller;

import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;


@Controller
@RequestMapping("/activiti")
public class ActivitiController {

	@Autowired
	private RepositoryService repositoryService;
	
	@Test
	public void processTest() {
		// 引擎配置
		ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		// 获取流程引擎对象
		ProcessEngine processEngine=pec.buildProcessEngine();
	}
	

}
