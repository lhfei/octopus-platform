/**
 * 
 */
Ext.define('Ifeng.view.task.TaskList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.taskList',

    title : '任務列表',
    store: 'TaskStore',
    
    selType: 'checkboxmodel',

    columns: [
        Ext.create('Ext.grid.RowNumberer'),
        {header: 'ID',  dataIndex: 'dbId',  flex: 1, align: 'center'},
        {header: '任務名稱', dataIndex: 'name', flex: 1, align: 'center'},
        {header: '開始時間', dataIndex: 'create', flex: 1, align: 'center'},
        {header: '任務描述', dataIndex: 'descr', flex: 1, align: 'center'},
        {header: '責任人', dataIndex: 'assignee', flex: 1, align: 'center'},
        {header: '任務狀態', dataIndex: 'activityName', flex: 1, align: 'center'},
        {
            xtype: 'actioncolumn',
            id: 'ctrlCell',
            flex: 1,
            align: 'center',
            sortable: false,
            menuDisabled: true,
            items: [{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-start',
                tooltip: '執行任務',
                action: 'start',
                scope: this
            },'-',{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-summary',
                tooltip: '查看任務',
                action: 'start',
                scope: this
            }]
        	
        }
    ],
    
    dockedItems: [{
        xtype: 'toolbar',
        items: ['-',{
            text: 'Add',
            iconCls: 'icon-add',
            action: 'complete'
        }, '-', {
            itemId: 'delete',
            text: '刷新',
            iconCls: 'icon-refreshable',
            disabled: false,
            action: 'refresh'
        },'-']
    }]
});
