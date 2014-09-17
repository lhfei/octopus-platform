/**
 * 
 */
Ext.application({
    name: 'Ifeng',

    // automatically create an instance of AM.view.Viewport
    autoCreateViewport: true,
    
    appFolder: '../resources/modules/history/app',
    // All the paths for custom classes
    paths: {
        'Ext.ux': 'resources/ext4/ux/'
    },

    controllers: [
        'HistoryController'
    ]
});
