/**
 * 
 */
Ext.define('Ifeng.model.VideoModel', {
	extend: 'Ext.data.Model',
	
	requires: ['Ext.data.reader.Json'],
	fields: [
	   "id" ,
	   "name" ,
	   "url", 
	   "realPath", 
	   "category", 
	   "categoryCod", 
	   "cp", 
	   "cpCode", 
	   "createDate", 
	   "producer", 
	   "state", 
	   "title", 
	   "theaterMode", 
	   "duration", 
	   "keyWords", 
	   "original"
	]
	
});