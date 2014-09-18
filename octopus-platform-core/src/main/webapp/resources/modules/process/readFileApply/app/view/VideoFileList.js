/**
 * 
 */
Ext.define('Ifeng.view.VideoFileList', {
	extend: 'Ext.grid.Panel',
	alias: 'widget.fileList',
	
	frame: true,
	autoWidth: true,
	autoHeight: true,
	
	//title: 'FileList',
	store: 'VideoStore',
	
	selType: 'checkboxmodel',

    columns: [
        Ext.create('Ext.grid.RowNumberer'),
        {header: 'ID',  dataIndex: 'id',  flex: 1, align: 'center'},
        {header: '節目名稱', dataIndex: 'name', flex: 1, align: 'center'},
        {
            xtype: 'actioncolumn',
            id: 'ctrlCell',
            flex: 1,
            header: '節目預覽',
            align: 'center',
            sortable: false,
            menuDisabled: true,
            items: [{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-start',
                tooltip: '視頻預覽',
                action: 'start',
                scope: this
            },'-',{
            	xtype: 'button',
            	id: 'startCtrl',
                iconCls: 'icon-summary',
                tooltip: '圖片預覽',
                action: 'start',
                scope: this
            }]
        },
        {header: '所屬分類', dataIndex: 'category', flex: 1, align: 'center'},
        {header: 'CP', dataIndex: 'cp', flex: 1, align: 'center'},
        {header: '創建時間', dataIndex: 'createDate', flex: 1, align: 'center'},
        {header: '文件狀態', dataIndex: 'state', flex: 1, align: 'center'},
        {header: '創建人', dataIndex: 'producer', flex: 1, align: 'center'}
        
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
    }],
    
    buttonAlign: 'center',
    buttons: [{
    	text: '審批',
    	action: 'approve',
    	iconCls: 'icon-process',
    },{
    	text : '重置',
		iconCls: 'icon-refresh',
		handler : function() {
			this.up('formPanel').getForm().reset();
		}
    },{
    	text: '返回',
		iconCls: 'icon-back',
		action: 'goBack'
    }]
});