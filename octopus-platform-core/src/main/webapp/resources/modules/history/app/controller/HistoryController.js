/**
 * 
 */
Ext.define('Ifeng.controller.HistoryController',{
	extend: 'Ext.app.Controller',
	
	stores: ['HistStore@Ifeng.store'],
	models: ['HistModel@Ifeng.model'],
	views:  ['list.HistoryList'],
	
	refs: [
	    {ref: 'histList', selector: 'histList'} ,
	    {ref: 'histStore', selector: 'histStore'}
	],
	
	init: function() {
		this.control({
			'histList button[action=refresh]' : {
				click: this.reloadHist
			}
		})
	},
	
	
	reloadHist: function(raw,idx) {
		this.getHistList().getStore().reload();
	}
});