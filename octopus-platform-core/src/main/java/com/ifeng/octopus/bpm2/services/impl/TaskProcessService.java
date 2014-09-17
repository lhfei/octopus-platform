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

package com.ifeng.octopus.bpm2.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jbpm.api.ExecutionService;
import org.jbpm.api.HistoryService;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.history.HistoryTask;
import org.jbpm.api.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifeng.octopus.bpm2.services.ITaskProcessService;
import com.ifeng.octopus.bpm2.web.model.HistoryModel;
import com.ifeng.octopus.bpm2.web.model.ProcessOwner;
import com.ifeng.octopus.bpm2.web.model.TaskModel;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 7, 2014
 */
@Service("taskProcessService")
public class TaskProcessService implements ITaskProcessService {

	private static final Logger log = LoggerFactory.getLogger(TaskProcessService.class);
	
	public List<TaskModel> findPersonalTasks(String userId) {
		TaskModel model;
		List<TaskModel> tasks = new ArrayList<TaskModel>();
		List<Task> list = taskService.findPersonalTasks(userId);
		for(Task task : list){
			model = new TaskModel();
			model.setActivityName(task.getActivityName());
			model.setAssignee(task.getAssignee());
			model.setCreate(task.getCreateTime());
			model.setDbId(task.getId());
			//model.setDbVersion(task.);
			model.setDescr(task.getDescription());
			model.setDuedate(task.getDuedate());
			//model.setExecution(task.getExecutionId());
			model.setExecutionId(task.getExecutionId());
			model.setForm(task.getFormResourceName());
			//model.setHasvars(task.get);
			model.setName(task.getName());
			model.setPriority(task.getPriority());
			//model.setProcinst(task.getp);
			//model.setProgress(task.getProgress());
			//model.setSignalling(tas);
			//model.setState(task.);
			//model.setSuperTask(task.get);
			//model.setSusphiststate(task.gets);
			//model.setSwimlane(task.gets);
			//model.setTaskClass(task.getClass());
			//model.setTaskDefName(task.get);
			
			tasks.add(model);
			
		}
		
		return tasks;
	}
	
	@Override
	public boolean completeTask(String taskId,ProcessOwner owner, Map<String, Object> map) {
		map.put("owner", owner.getCode());
		
		log.info("complete task: {}", taskId);
		
		taskService.completeTask(taskId, map);
		return false;
	}
	
	public List<HistoryModel> getHistory(String assignee) {
		HistoryModel model;
		List<HistoryModel> list = new ArrayList<HistoryModel>();
		List<HistoryTask> tasks = historyService.createHistoryTaskQuery()
				.assignee(assignee).orderDesc("createTime").list();
		for(HistoryTask task : tasks){
			model = new HistoryModel();
			model.setAssignee(task.getAssignee());
			model.setCreateTime(task.getCreateTime());
			model.setDbid(task.getId());
			model.setDuration(task.getDuration());
			model.setEndTime(task.getEndTime());
			model.setExecutionId(task.getExecutionId());
			model.setOutcome(task.getOutcome());
			model.setState(task.getState());
			
			list.add(model);
		}
		
		return list;
	}
	
	@Autowired
	private HistoryService historyService;
	@Autowired
	private org.jbpm.api.TaskService taskService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ExecutionService executionService;

}
