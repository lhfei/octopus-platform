/**
 * 
 */
Ext.define('Ifeng.view.list.HistoryList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.histList',

    title : '任務列表',
    
    store: 'HistStore',
    
    selType: 'checkboxmodel',

    columns: [
        Ext.create('Ext.grid.RowNumberer'),
        {header: 'ID',  dataIndex: 'dbId',  flex: 1, align: 'center'},
        {header: '任務名稱', dataIndex: 'state', flex: 1, align: 'center'},
        {header: '下一節點', dataIndex: 'outcome', flex: 1, align: 'center'},
        {header: '開始時間', dataIndex: 'createTime', flex: 1, align: 'center'},
        {header: '結束時間', dataIndex: 'endTime', flex: 1, align: 'center'},
        {header: '經辦人', dataIndex: 'assignee', flex: 1, align: 'center'},
        {header: '流轉時間', dataIndex: 'duration', flex: 1, align: 'center'},
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
        dock: 'top',
        items: ['-',{
            text: 'Add',
            iconCls: 'icon-add',
            action: 'complete'
        }, '-', {
            itemId: 'refresh',
            text: '刷新',
            iconCls: 'icon-refreshable',
            disabled: false,
            action: 'refresh'
        },'-']
    },{
    	xtype: 'pagingtoolbar',
    	dock: 'bottom',
    	store: 'HistStore',
    	displayInfo: true
    }]
});
