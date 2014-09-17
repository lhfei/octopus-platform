/**
 * @class Ext.chooser.InfoPanel
 * @extends Ext.panel.Panel
 * @author Ed Spencer
 * 
 * This panel subclass just displays information about an image. We have a simple template set via the tpl property,
 * and a single function (loadRecord) which updates the contents with information about another image.
 */
Ext.define('Ext.chooser.InfoPanel', {
    extend: 'Ext.panel.Panel',
    alias : 'widget.infopanel',
    id: 'img-detail-panel',

    autoWidth: true,
    autoHeight: true,
    minWidth: 600,
    autoScroll: false,
    
    items: [{
    	xtype:	'fieldset',
    	title: '流程預覽圖',
    	autoheight: true,
    	collapsible: true,
    	items: [{
    		id: 'processImg',
    		height: 320,
    		html: '點擊左邊流程,查看流程預覽圖.'
    	}]
    },{
    	xtype: 'fieldset',
    	collapsible: true,
    	title: '流程說明',
    	items: [{
    		id: 'processInfo',
    		height: 120,
    		html: '點擊左邊流程,查看相應描述信息.'
    	}]
    	
    }],
    
    tpl: [
     '<div class="details">',
         '<tpl for=".">',
             '<div class="details-info">',
                 '<b><p>流程名稱:</b>',
                 '<span>{name}</span></p>',
                 '<b><p>流程描述:</b>',
                 '<span>{desc}</span></p>',
                 '<b><p>流程約束:</b>',
                 '<span>{type}</span></p>',
             '</div>',
         '</tpl>',
     '</div>'
    ],
    
    afterRender: function(){
        this.callParent();
        if (!Ext.isWebKit) {
            this.el.on('click', function(){
                alert('The Sencha Touch examples are intended to work on WebKit browsers. They may not display correctly in other browsers.');
            }, this, {delegate: 'a'});
        } 
    },

    /**
     * Loads a given image record into the panel. Animates the newly-updated panel in from the left over 250ms.
     */
    loadRecord: function(image) {
        this.body.hide();
        this.tpl.overwrite(Ext.fly('processInfo'), image.data);
        
        var html = Ext.fly('processImg').update('<img src=\"'+(image.data).url+'\" width="100%" height="100%"/>');
        
        this.body.slideIn('l', {
            duration: 250
        });
    },
    
    clear: function(){
        this.body.update('');
    }
});