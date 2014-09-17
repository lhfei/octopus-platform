/**
 * 卫视查阅获取门户各类图文信息和素材
 */
Ext.application({
    name: 'Ifeng',

    // automatically create an instance of AM.view.Viewport
    autoCreateViewport: true,
    
    appFolder: '../resources/modules/process/audit/app',
    // All the paths for custom classes
    paths: {
        'Ext.ux': 'resources/ext4/ux/'
    },

    controllers: [
        'VideoFileController'
    ]
});