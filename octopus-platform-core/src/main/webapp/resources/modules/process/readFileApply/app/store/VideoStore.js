Ext.define('Ifeng.store.VideoStore', {
    extend: 'Ext.data.Store',
    alias: 'widget.videoStore',
    model: 'Ifeng.model.VideoModel',
    autoLoad: true,
    
    proxy: {
        type: 'ajax',
        api: {
            read: '../resources/modules/process/readFileApply/app/data/VideoModel.json',
            update: 'data/updateUsers.json'
        },
        reader: {
            type: 'json',
            root: 'videos',
            successProperty: 'success'
        }
    }
});