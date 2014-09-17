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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.octopus.bpm2.services.ITaskProcessService;
import com.ifeng.octopus.bpm2.web.model.ProcessOwner;
import com.ifeng.octopus.bpm2.web.model.TaskModel;
import com.ifeng.octopus.bpm2.web.model.UserSession;
import com.ifeng.octopus.bpm2.web.util.ExtJSReturn;
import com.mockrunner.util.common.StringUtil;

/**
 * Phoenix TV business process controller.</p>
 * 
 * 卫视查阅、获取门户各类图文信息和素材</b>
 * 
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 4, 2014
 */
@Controller
@RequestMapping("phoenixtv")
@SessionAttributes(UserSession.USER_SESSION)
public class PhoenixtvProcessController {
	private Marker marker = MarkerFactory.getMarker("PHOENIX_TV");
	private static final Logger log = LoggerFactory.getLogger(PhoenixtvProcessController.class);
	

	/**
	 * 
	 * 根据流程 <tt>Key</tt> 开启流程实例
	 * @param pKey
	 * @return
	 */
	@RequestMapping(value="start",produces = "application/json")
	public @ResponseBody Map<String, Object> start(@RequestParam("pKey") String pKey,HttpSession session) {
		String userId = (String)session.getAttribute(UserSession.USER_ID);
		if(!StringUtil.isEmptyOrNull(pKey)){
			Map<String, Object> variables = new HashMap<String, Object>();
			variables.put("owner", userId);
			executionService.startProcessInstanceByKey(pKey,variables);
			
			return ExtJSReturn.mapOK("\u6D41\u7A0B\u555F\u52D5\u6210\u529F.");
		}else{
			return ExtJSReturn.mapError("\u8ACB\u9078\u64C7\u60A8\u8981\u555F\u52D5\u7684\u6D41\u7A0B.");
		}
		
	}
	
	/**
	 * 查询当前用户的待办任务列表</br>
	 * <ul>查询规则: 根据当前用户所输的用户组</ul>
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "findPersonalTasks", produces = "application/json")
	public @ResponseBody Map<String, Object> getTasks(HttpSession session) {
		String userId = (String)session.getAttribute(UserSession.USER_ID);
		List<TaskModel> taskList = taskProcessService.findPersonalTasks(userId);

		return ExtJSReturn.mapOK(taskList);
	}
	
	@RequestMapping("taskList")
	public ModelAndView taskList() {
		ModelAndView view = new ModelAndView("tv/taskList");
		log.info("forward to taskList");
		return view;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	//// 卫视查阅、获取门户各类图文信息和素材 -- 处理流程
	//// Process step  												... start
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * 发起 <tt>查询请求<tt> </p>
	 * 
	 * @return
	 */
	@RequestMapping("readFileApplay")
	public ModelAndView readFileApplay(@RequestParam("taskId")String taskId) {
		ModelAndView view = new ModelAndView("tv/readFileTaskApplay");
		view.addObject("taskId", taskId);
		
		log.info("Process step {}: Read File Applay.",1,marker);
		
		return view;
	}
	
	/**
	 * <tt> 查询请求</tt> 任务处理</br>
	 * <ul>完成<tt> 查询请求</tt> 相应的业务流程处理</ul>
	 * <ul>下一流程节点: <tt> 权限审查</tt> 
	 * 
	 * @param taskId
	 * @return
	 */
	@RequestMapping("applayComplete")
	public @ResponseBody Map<String,Object> applayComplete(@RequestParam("taskId")String taskId) {
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("owner", ProcessOwner.SECURITY_AUDITOR.getCode());
		// submit the task
		taskService.completeTask(taskId, "申請人身份檢查", variables);
		
		return ExtJSReturn.mapOK("");
	} 
	
	/**
	 * 权限审查-请求</br>
	 * <ul>调整至<tt> 权限审查</tt> 业务处理表单</ul>
	 * @param taskId
	 * @return
	 */
	@RequestMapping("securityCheck")
	public ModelAndView securityCheck(@RequestParam("taskId")String taskId) {
		ModelAndView view = new ModelAndView("tv/securityCheck");
		view.addObject("taskId", taskId);
		
		log.info("Process step {}: Operator security check.",2,marker);
		
		return view;
	}
	
	/**
	 * <tt> 权限审查</tt> 任务处理</br>
	 * <ul>完成<tt> 权限审查</tt> 相应的业务流程处理</ul>
	 * <ul>下一流程节点: <tt> 统计</tt> 
	 * @param taskId
	 * @return
	 */
	@RequestMapping("checkComplete")
	public @ResponseBody Map<String,Object> checkComplete(@RequestParam("taskId")String taskId) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("owner", ProcessOwner.STATISTICS_AUDITOR.getCode());
		
		// submit the task
		taskService.completeTask(taskId, "safeness", variables);
		
		return ExtJSReturn.mapOK("");
	} 
	
	/**
	 * <tt> 统计</tt> -请求</br>
	 * <ul>调整至<tt> 统计</tt> 业务处理表单</ul>
	 * @param taskId
	 * @return
	 */
	@RequestMapping("audit")
	public ModelAndView audit(@RequestParam("taskId")String taskId) {
		ModelAndView view = new ModelAndView("tv/audit");
		view.addObject("taskId", taskId);
		
		log.info("Process step {}: Audit.",3,marker);
		
		return view;
	}
	
	/**
	 * <tt> 统计</tt> 任务处理</br>
	 * <ul>完成<tt> 统计</tt> 相应的业务流程处理</ul>
	 * <ul>下一流程节点: <tt> 数据标准化</tt> 
	 * @param taskId
	 * @return
	 */
	@RequestMapping("auditComplete")
	public @ResponseBody Map<String,Object> auditComplete(@RequestParam("taskId")String taskId) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("owner", ProcessOwner.DATA_FORMATER.getCode());
		
		// submit the task
		taskService.completeTask(taskId, "數據標準化處理", variables);
		
		return ExtJSReturn.mapOK("");
	} 
	
	/**
	 * <tt> 数据标准化</tt> -请求</br>
	 * <ul>调整至<tt> 数据标准化</tt> 业务处理表单</ul> 
	 * @param taskId
	 * @return
	 */
	@RequestMapping("dataFormat")
	public ModelAndView dataFormat(@RequestParam("taskId")String taskId) {
		ModelAndView view = new ModelAndView("tv/dataFormat");
		view.addObject("taskId", taskId);
		
		log.info("Process step {}: Data Format.",4,marker);
		
		return view;
	}
	
	/**
	 * <tt> 数据标准化</tt>  任务处理</br>
	 * <ul>完成<tt> 数据标准化</tt>  相应的业务流程处理</ul>
	 * <ul>下一流程节点: <tt> 流程结束</tt>  
	 * @param taskId
	 * @return
	 */
	@RequestMapping("formatComplete")
	public @ResponseBody Map<String,Object> formatComplete(@RequestParam("taskId")String taskId) {
		
		// submit the task
		taskService.completeTask(taskId, "流程結束");
		
		return ExtJSReturn.mapOK("");
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////
	//// Process step  												... start
	/////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ExecutionService executionService;
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ITaskProcessService taskProcessService;
	
}
