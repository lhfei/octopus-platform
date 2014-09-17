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

package com.ifeng.octopus.bpm2.services;

import java.util.List;
import java.util.Map;

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
public interface ITaskProcessService {

	/**
	 * @param userId
	 * @return
	 */
	List<TaskModel> findPersonalTasks(String userId);
	
	/**
	 * @param taskId
	 * @param owner
	 * @param map
	 * @return
	 */
	boolean completeTask(String taskId,ProcessOwner owner,Map<String,Object> map);
	
	/**
	 * Search in history task information
	 * @param assignee
	 * @return
	 */
	List<HistoryModel> getHistory(String assignee);
}
