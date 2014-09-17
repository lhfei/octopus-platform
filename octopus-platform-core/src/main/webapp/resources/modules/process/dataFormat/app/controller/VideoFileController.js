/**
 * 
 */
Ext.define('Ifeng.controller.VideoFileController', {
	extend: 'Ext.app.Controller',
	alias: 'widget.fileCtrl',
	
	modules: [],
	stores: [],
	views: ['VideoFileList', 'FileSearchForm'],
	
	refs: [
		{ref: 'fileList', selector: 'fileList'},
		{ref: 'searchForm', selector: 'searchForm'}
	],
	
	init: function() {
		this.control({
			'fileList button[action=approve]': {
				click: this.approve
			},
			'fileList button[action=goBack]': {
				click: this.goBack
			}
		})
	},
	
	
	approve: function(){
		var me = this;
		Ext.Ajax.request({
			url : 'formatComplete.do',
			waitMsg : 'Loading ...',
			method : 'get',
			headers : {
				'Content-Type' : 'application/json'
			},
			success : function(response) {
				var result = Ext.decode(response.responseText);
				if (result.success){
					me.goBack();
				} else{
					Ext.MessageBox.show({
						title : 'System Message',
						msg : 'Your enter name or password invalid.'
					});
				}
			},
			failure : function() {
				Ext.MessageBox.show({
					title : 'System Message',
					msg : 'The server engine is busy now, please try a later.'
				});
			},
			params : {taskId: Ext.get('taskId').getValue()}
			
		});
	},
	goBack: function(){
		var tabPanel = parent.Ext.getCmp('centerPanel');
		currentPanel = tabPanel.getActiveTab();
		tabPanel.remove(currentPanel);
	}
	
});