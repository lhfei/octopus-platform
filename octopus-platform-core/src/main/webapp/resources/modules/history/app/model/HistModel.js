/**
 * 
 */
Ext.define('Ifeng.model.HistModel', {
	extend: 'Ext.data.Model',
	
	//requires: ['Ext.data.reader.Json'],
	
	fields: ['dbId', 'state', 'executionId', 'assignee', 'outcome', 'createTime', 'endTime', 'duration']
});
