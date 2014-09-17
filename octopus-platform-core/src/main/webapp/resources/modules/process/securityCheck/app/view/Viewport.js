/**
 * 
 */
Ext.define('Ifeng.view.Viewport', {
	extend: 'Ext.container.Viewport',
	
	layout: 'border',
	
	items: [{
		xtype: 'searchForm',
		region: 'north',
		spilt: true
	},{
		xtype: 'fileList',
		region: 'center',
		split: true
	}]
	
});