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

package com.ifeng.octopus.bpm2.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.octopus.bpm2.services.ITaskProcessService;
import com.ifeng.octopus.bpm2.web.model.HistoryModel;
import com.ifeng.octopus.bpm2.web.model.UserSession;
import com.ifeng.octopus.bpm2.web.util.ExtJSReturn;

/**
 * 流程管理控制器</p>
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 6, 2014
 */
@Controller
 @RequestMapping("processManager")
public class ProcessManagerController {

	private static final Logger log = LoggerFactory.getLogger(ProcessManagerController.class);
	
	/**
	 * Deploy process instance.
	 * 
	 * @return
	 */
	@RequestMapping(value="/deploy",produces = "application/json",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deploy(){
		String deploymentId = repositoryService
				.createDeployment()
				.addResourceFromClasspath(
						"process/PhoenixtvReadFileTask.jpdl.xml").deploy();
		
		log.info("process {} deploy done.","PhoenixtvReadFileTask");
		
		return ExtJSReturn.mapOK("\u6D41\u7A0B\u767C\u5E03\u6210\u529F.");
	}
	
	@RequestMapping(value="/history",method=RequestMethod.GET)
	public ModelAndView history(){
		ModelAndView view = new ModelAndView("pm/historyList");
		
		log.info("process {} deploy done.","PhoenixtvReadFileTask");
		
		return view;
	}
	
	
	/**
	 * Query process execution history.</br>
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getHistory",consumes="application/json",
			produces="application/json", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getHistory(@RequestBody HistoryModel model, 
			HttpSession session) {
		
		String userId = (String)session.getAttribute(UserSession.USER_ID);

		log.info("Method {} has be extcuted. ", "getHistory()");
		
		List<HistoryModel> list = taskProcessService.getHistory(userId);
		
		return ExtJSReturn.mapOK(list);
	}
	
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ExecutionService executionService;
	
	@Autowired
	private ITaskProcessService taskProcessService;
}
