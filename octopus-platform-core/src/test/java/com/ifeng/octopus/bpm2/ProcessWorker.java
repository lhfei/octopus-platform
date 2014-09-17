/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ifeng.octopus.bpm2;

import java.util.HashMap;
import java.util.Map;

import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ifeng.octopus.bpm2.test.support.BasicTestSuit;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 4, 2014
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-context.xml")
public class ProcessWorker extends BasicTestSuit {
	
	private String deploymentId;
	
	@Test
	public void deploy(){
		deploymentId = repositoryService
				.createDeployment()
				.addResourceFromClasspath(
						"process/PhoenixtvReadFileTask.jpdl.xml").deploy();
		
	    ProcessInstance processInstance = executionService.startProcessInstanceByKey("PhoenixtvReadFileTask");
	    Execution executionInPrintDots = processInstance.findActiveExecutionIn("print dots");
	    Assert.assertNotNull(executionInPrintDots);
	    String executionId = executionInPrintDots.getId();
	    executionService.signalExecutionById(executionId);
	}
	
	@Test
	public void getTask() {
		Map<String, Object> variables = new HashMap<String, Object>();
	    variables.put("owner", "phoneixtv");
		executionService.startProcessInstanceByKey("PhoenixtvReadFileTask",variables);
	}
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ExecutionService executionService;
	
	

}
