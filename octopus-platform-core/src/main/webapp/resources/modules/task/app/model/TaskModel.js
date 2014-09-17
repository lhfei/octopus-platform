/**
 * 
 */
Ext.define('Ifeng.model.TaskModel', {
	extend: 'Ext.data.Model',
	alias: 'widget.taskModel',
	
	requires: ['Ext.data.reader.Json'],
	
	fields: ['dbId', 'name', 'descr', 'assignee', 'form', 'priority',
	     'create', 'duedate', 'executionId', 'activityName']
});
