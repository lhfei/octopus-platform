/**
 * 
 */
Ext.require([ 'Ext.form.*', 'Ext.data.*', 'Ext.tip.QuickTipManager' ]);

Ext.onReady(function() {
	var taskId =  Ext.get('taskId').getValue();
	
	var formPanel = Ext.create('Ext.form.Panel',{
		frame : true,
		title : '卫视查阅获取门户各类图文信息和素材',
		autoWidth : true,
		bodyPadding : 5,
	
		fieldDefaults : {
			labelAlign : 'left',
			labelWidth : 90,
			anchor : '100%'
		},
	
		items : [{
			xtype : 'textfield',
			name : 'email',
			fieldLabel : '流程編號',
			msgTarget : 'side',
			value : taskId,
			allowBlank : false
		},{
			xtype : 'textfield',
			name : 'email',
			fieldLabel : '申請人郵箱',
			vtype : 'email',
			msgTarget : 'side',
			emptyText : '申請結果會通過郵件及時提醒.',
			allowBlank : false
		},{
			xtype : 'fieldcontainer',
			fieldLabel : '申請日期範圍',
			combineErrors : true,
			msgTarget : 'side',
			layout : 'hbox',
			defaults : {
				flex : 1,
				hideLabel : true
			},
			items : [ {
				xtype : 'datefield',
				name : 'startDate',
				fieldLabel : '開始日期',
				margin : '0 5 0 0',
				allowBlank : false
			}, {
				xtype : 'datefield',
				name : 'endDate',
				fieldLabel : '結束日期',
				allowBlank : false
			} ]
		},{
			xtype : 'fieldset',
			title : 'Details',
			collapsible : true,
			defaults : {
				labelWidth : 89,
				anchor : '100%',
				layout : {
					type : 'hbox',
					defaultMargins : {
						top : 0,
						right : 5,
						bottom : 0,
						left : 0
					}
				}
			},
			items : [{
				xtype : 'fieldcontainer',
				fieldLabel : '聯繫電話',
				combineErrors : true,
				msgTarget : 'under',
				defaults : {
					hideLabel : true
				},
				items : [{
					xtype : 'displayfield',
					value : '('
				},{
					xtype : 'textfield',
					fieldLabel : 'Phone 1',
					name : 'phone-1',
					width : 35,
					allowBlank : false
				},{
					xtype : 'displayfield',
					value : ')'
				},{
					xtype : 'textfield',
					fieldLabel : 'Phone 2',
					name : 'phone-2',
					width : 35,
					allowBlank : false,
					margins : '0 5 0 0'
				},{
					xtype : 'displayfield',
					value : '-'
				},{
					xtype : 'textfield',
					fieldLabel : 'Phone 3',
					name : 'phone-3',
					width : 48,
					allowBlank : false
				} ]
			},{
				xtype : 'fieldcontainer',
				combineErrors : true,
				msgTarget : 'side',
				fieldLabel : '申請資源類別',
				defaults : {
					hideLabel : true
				},
				items : [{
					width : 65,
					xtype : 'combo',
					queryMode : 'local',
					value : 'mrs',
					triggerAction : 'all',
					forceSelection : true,
					editable : false,
					fieldLabel : 'Title',
					name : 'title',
					displayField : 'name',
					valueField : 'value',
					store : Ext.create('Ext.data.Store',{
						fields : ['name','value' ],
						data : [{
									name : '視頻 ',
									value : 'vedio'
								},{
									name : '音頻',
									value : 'media'
								},{
									name : '網頁',
									value : 'webpage'
								} ]
					})
				},{
					xtype : 'textfield',
					flex : 1,
					name : 'firstName',
					fieldLabel : 'First',
					allowBlank : false
				},{
					xtype : 'textfield',
					flex : 1,
					name : 'lastName',
					fieldLabel : 'Last',
					allowBlank : false
				} ]
			} ]
		}],
	
		buttons : [{
			text : '審批',
			iconCls: 'icon-process',
			handler : function() {
				var form = this.up('formPanel').getForm(), encode = Ext.String.htmlEncode, s = '';
				if (form.isValid()) {
					/* Ext.iterate(form.getValues(), function(key, value) {
					    value = encode(value);
					    
					    s += Ext.util.Format.format("{0} = {1}<br />", key, value);
					}, this); */

					Ext.Ajax.request({
						url : '#W',
						waitMsg : 'Loading ...',
						method : 'post',
						headers : {
							'Content-Type' : 'application/json'
						},
						success : function(response) {
							var result = Ext.decode(response.responseText);
							if (result.success
									&& result.message == '0') {
								document.location.href = 'index.do';
							} else if (result.message == '1')
								Ext.MessageBox.show({
									title : 'System Message',
									msg : 'Your enter name or password invalid.'
								});
						},
						failure : function() {
							Ext.MessageBox.show({
								title : 'System Message',
								msg : 'The server engine is busy now, please try a later.'
							});
						},
						params : {},
						jsonData : {
							userId : userId,
							userName : passwd
						}
					});
				}
			}
		},{
			text : 'Reset',
			iconCls: 'icon-refresh',
			handler : function() {
				this.up('formPanel').getForm().reset();
			}
		},{
			text: '返回',
			iconCls: 'icon-back',
			handler: function(){
				var tabPanel = parent.Ext.getCmp('centerPanel'),
					currentPanel = tabPanel.getActiveTab();
				
				tabPanel.remove(currentPanel);
			}
			
		}]
	});

	formPanel.render('form-ct');

});