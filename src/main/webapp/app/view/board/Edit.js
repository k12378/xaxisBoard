var messageForm;
Ext.onReady(function(){
	messageForm = Ext.define("Ext.panel", {
		title : "update - "+ boardCode,
		layout : "form",
		renderTo : Ext.getBody(),
		bodyPadding : 10,
		defaultType : "textfield",
		items : [{
			xtype : "displayfield",
			name : "subject",
			fieldLabel : "Subject",
			labelWidth : 200,
			minWidth : 600,
			padding : "10",
			align : "left",
			matchFieldWidth : false
		},
		{
			xtype : "displayfield",
			name : "register",
			fieldLabel : "Register",
			labelWidth : 200,
			minWidth : 600,
			padding : "10",
			align : "left",
			matchFieldWidth : false
		},
		{
			xtype : "displayfield",
			name : "nickName",
			fieldLabel : "Nick Name",
			labelWidth : 200,
			minWidth : 600,
			padding : "10",
			align : "left",
			matchFieldWidth : false,
		},
		{
			xtype : "displayfield",
			name : "viewCount",
			fieldLabel : "View Count",
			labelWidth : 200,
			minWidth : 600,
			padding : "10",
			align : "left",
			matchFieldWidth : false
		},
		{
			xtype : "displayfield",
			name : "recommendanteCount",
			fieldLabel : "Recommendante Count",
			labelWidth : 200,
			minWidth : 600,
			padding : "10",
			align : "left",
			matchFieldWidth : false
		},
		{
			xtype : "htmleditor",
			name : "messageContents",
			fieldLabel : "Content",
	        enableColors: true,
	        enableAlignments: true,
			labelWidth : 200,
			minWidth : 600,
			minHeight : 200,
			padding : "10",
			align : "left top",
			matchFieldWidth : false
		}],
		button : [{
			text : "Save",
			submit : {
				url : "",
				param : [],
				method : "post",
				failure : function(){
					console.log("Update Failed");
				},
				success : function(){
					console.log("Update Success");
				},
				waitMsg : "업데이트 중입니다. <br />잠시만 기다려 주십시오.",
				waitTitle : "Message를 업데이트 중입니다."
			}
		},
		{
			text : "Cancel",
			scope : this,
			handler : this.close
		}]
	});
});

Ext.define("BBS.view.board.Edit", {
	extend : "Ext.window.Window",
	alias : "widget.boardedit",
	title : boardCode + " Edit Form",
	layout : "fit",
	autoShow : true,
	initComponent : function(){
		
		
		this.items = [{
			xtype : "form",
			id : "messageUpdateForm",
			items :[{
				xtype : "displayfield",
				name : "subject",
				fieldLabel : "Subject",
				labelWidth : 200,
				minWidth : 600,
				padding : "10",
				align : "left",
				matchFieldWidth : false
			},
			{
				xtype : "displayfield",
				name : "register",
				fieldLabel : "Register",
				labelWidth : 200,
				minWidth : 600,
				padding : "10",
				align : "left",
				matchFieldWidth : false
			},
			{
				xtype : "displayfield",
				name : "nickName",
				fieldLabel : "Nick Name",
				labelWidth : 200,
				minWidth : 600,
				padding : "10",
				align : "left",
				matchFieldWidth : false,
			},
			{
				xtype : "displayfield",
				name : "viewCount",
				fieldLabel : "View Count",
				labelWidth : 200,
				minWidth : 600,
				padding : "10",
				align : "left",
				matchFieldWidth : false
			},
			{
				xtype : "displayfield",
				name : "recommendanteCount",
				fieldLabel : "Recommendante Count",
				labelWidth : 200,
				minWidth : 600,
				padding : "10",
				align : "left",
				matchFieldWidth : false
			},
			{
				xtype : "htmleditor",
				name : "messageContents",
				fieldLabel : "Content",
		        enableColors: true,
		        enableAlignments: true,
				labelWidth : 200,
				minWidth : 600,
				minHeight : 200,
				padding : "10",
				align : "left top",
				matchFieldWidth : false
			}]
		}];
		
		this.buttons = [{
			text : "Save",
			submit : {
				url : "",
				param : [],
				method : "post",
				failure : function(){
					console.log("Update Failed");
				},
				success : function(){
					console.log("Update Success");
				},
				waitMsg : "업데이트 중입니다. <br />잠시만 기다려 주십시오.",
				waitTitle : "Message를 업데이트 중입니다."
			}
		},
		{
			text : "Cancel",
			scope : this,
			handler : this.close
		}];
		
		this.callParent(arguments);
	},
	onTest : function(){
		console.log("test");
	}
	
});