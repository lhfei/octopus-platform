/**
 * 卫视查阅获取门户各类图文信息和素材 - 申請信息Form
 */
Ext.define('Ifeng.view.ReadFileApplyForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.fileApplyForm',
	
	frame: true,
    title: '衛視查閱獲取門戶各類圖文信息和素材',

    height: 300,

    bodyPadding: 5,
    defaults: {
    	anchor: '100%'
    },
    
    layout: 'hbox',
    
    items:[{
    	xtype: 'fieldset',
    	flex: 1,
    	title: 'M1',
    	collapseable: true,
    	defaults: {
        	anchor: '100%',
        	xtype: 'textfield'
        },
    	items: [{
    		fieldLable: '流程編號'
    	}]
    	
    }],
    
    buttons: [{
    	text: '審批'
    },{
    	text: '重置'
    }]
	
});