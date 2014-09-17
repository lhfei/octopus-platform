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

package com.ifeng.octopus.bpm2.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 7, 2014
 */
public class TaskModel implements Serializable{

	private static final long serialVersionUID = 4500544166347301320L;

	public String getDbId() {
		return dbId;
	}
	public void setDbId(String dbId) {
		this.dbId = dbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public Date getDuedate() {
		return duedate;
	}
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}
	public String getExecutionId() {
		return executionId;
	}
	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String dbId;
	//private int dbVersion;
	private String name;
	private String descr;
	//private String state;
	//private String susphiststate;
	private String assignee;
	private String form;
	private int priority;
	private Date create;
	private Date duedate;
	//private int progress;
	//private int signalling;
	private String executionId;
	private String activityName;
	//private String hasvars;
	//private Long superTask;
	//private Long execution;
	//private Long procinst;
	//private Long swimlane;
	//private String taskDefName;

}
