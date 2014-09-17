/**
 * 
 */
Ext.define('Ifeng.store.TaskStore', {
    extend: 'Ext.data.Store',
    model: 'Ifeng.model.TaskModel',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: '../phoenixtv/findPersonalTasks.do',
            update: 'data/updateUsers.json'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        }
    }
});