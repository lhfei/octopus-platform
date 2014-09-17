/**
 * 
 */
Ext.define('Ifeng.store.HistStore', {
	extend: 'Ext.data.Store',
	alias: 'widget.histStore',
	
	model: 'Ifeng.model.HistModel',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        pageParam: false,
        startParam: false,
        limitParam: false,
        headers: {"Content-Type": 'application/json'},
        
        doRequest: function(operation, callback, scope) {
            var writer  = this.getWriter(),
                request = this.buildRequest(operation, callback, scope);
               
            if (operation.allowWrite()) {
                request = writer.write(request);
            }
           
            Ext.apply(request, {
                headers       : this.headers,
                timeout       : this.timeout,
                scope         : this,
                callback      : this.createRequestCallback(request, operation, callback, scope),
                method        : this.getMethod(request),
                jsonData        : this.jsonData,
                disableCaching: false // explicitly set it to false, ServerProxy handles caching
            });
            Ext.Ajax.request(request);               
            return request;
        },
        
        
        actionMethods: {
        	create: 'POST',
        	read: 'POST',
        	update: 'POST',
        	destory: 'GET'
        },
        api: {
            read: 'getHistory.do'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    },
    
    listeners: {
    	
    	beforeload: function(store,operation,eOpts) {
    		store.proxy.jsonData = {
	        	assignee: 'phoneixtv',
	        	start: operation.start,
	        	limit: operation.limit
    		}
    	}
    	
    }


});