/**
 * 
 */
Ext.define('Ifeng.controller.TaskController', {
	extend: 'Ext.app.Controller',
	
	stores: ['TaskStore'],
	models: ['TaskModel'],
	views: ['TaskList@Ifeng.view.task'],
	
	refs: [
        {ref: 'taskList', selector: 'taskList'},
        {ref: 'TaskStore', selector: 'TaskStore'}
	],
	
	init: function() {
		var me = this;
		this.control({
			'viewport > taskList': {
				itemdblclick: this.editTask
			},
			'taskList actioncolumn': {
				click: this.completeTask
			},
			'taskList button[action=refresh]': {
				click: this.reloadTask
			}
		});
	},
	
	editTask: function(grid,record) {
		//Ext.MessageBox.show(record.name, record.data.name);
	},
	
	completeTask: function(view,cell,row,col,e){
		var tabPanel = parent.Ext.getCmp('centerPanel')//parent.Ifeng.view.MainPanel;
        var m = e.getTarget().className.match(/\bicon-(\w+)\b/);
        var record = this.getTaskList().getStore().getAt(row).data;
        var mm =  this.getTaskStore();
        
        if(m){
            switch(m[1]){
                case 'start':
                	var tab = tabPanel.getComponent(record.dbId);
            		if (!tab) {
                        tab = tabPanel.add(Ext.create('Ext.panel.Panel', {
                            itemId: record.form,
                            title: record.name,
                            id: record.dbId,
            				iconCls: 'commTab',
            				autoScroll: true,
            				closable: true,
            				autoHeight: true,
            				layout: 'fit',
            				autoLoad: {
                				url: '../resources/annex/tabFrame.jsp?url=' + record.form + '?taskId=' +record.dbId,
                				method : "post",
                				discardUrl: false,
                				nocache: true,
                				text: 'Loading ...'
            				}
                        }));
                    }
            		
            		tabPanel.setActiveTab(tab); 
                    
                    break;
                case 'summary':
                    Ext.msg.Alert("",record.form);
                    break;    
            }
        }
    },
    
    reloadTask: function(e) {
    	var store = this.getTaskList().getStore();
    	store.reload();
    }
	
});