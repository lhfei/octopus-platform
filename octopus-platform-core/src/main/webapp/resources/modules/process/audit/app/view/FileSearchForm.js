/**
 * 
 */
Ext.define('Ifeng.view.FileSearchForm', {
	extend: 'Ext.form.Panel',
	alias: 'widget.searchForm',
	
	frame: true,
	autoWidth: true,
	autoHeight: true,
	title: 'Search Form',
	
	
	fieldDefaults: {
        labelAlign: 'left',
        labelWidth: 90,
        anchor: '100%'
    },

    items: [{
        xtype: 'textfield',
        name: 'textfield1',
        fieldLabel: 'Text field',
        readOnly: true,
        value: Ext.get('taskId').getValue()
    }, {
        xtype: 'hiddenfield',
        name: 'hidden1',
        value: 'Hidden field value'
    },{
        xtype: 'textfield',
        name: 'password1',
        inputType: 'password',
        fieldLabel: 'Password field'
    }, {
        xtype: 'filefield',
        name: 'file1',
        fieldLabel: 'File upload'
    }]
});