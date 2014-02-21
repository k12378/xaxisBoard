Ext.define("xaxisBoardAdmin.view.TopLayout", {
	extend : "Ext.panel.Panel",
	alias : "widget.topLayout",
	id : "layoutTopWarp",
	layout : "auto",
	height : 130,
	border: false,
	initComponent : function(){
		
		// 상 / 하 레이아웃
		var warpContainer = Ext.create("Ext.container.Container", {
			layout : {
				type : "vbox",				
			},
			border: false,
			padding : 10
		});
		
		// 좌 / 우 레이아웃
		var infomationContainer = Ext.create("Ext.container.Container", {
			width : window.innerWidth,
			layout : {
				type : "hbox",				
			},
			border : false
		});
		
		// logo Layout
		var logoPanel = Ext.create("Ext.panel.Panel",{
			minWidth : 95,
			border : false,
			flex : 9 
		});
		
		// button Layout
		var userInfoPanel = Ext.create("Ext.panel.Panel", {
			minWidth : 75,
			border : false,
			flex : 1
		});		
		
		// logo image
		var logo = Ext.create("Ext.Img", {
			id : "xaxis-logo",
			src : contextRoot + "/images/logo.jpg",
			width : 95,
			height: 65,
			listeners : {
				click : {
					element : "el",
					fn : this.onPressLogo
				} 
			}
	    });
		
		// logout button
		var logoutButton = Ext.create("Ext.Button", {
			name : "logoutBtn",
			text : "Logout",
			width : 75,
			height : 25,
			listeners : {
				click : {
					element : "el",
					fn : this.onPressLogout
				}
			}
		});
		
		logoPanel.add(logo);
		userInfoPanel.add(logoutButton);		
		infomationContainer.add(logoPanel);
		infomationContainer.add(userInfoPanel);
		
		
		// Menu Items panel 		
		var topMenuItemsPanel = Ext.create("Ext.panel.Panel", {
			id : "topMenuItemsPanel",
			height : 40,
			border : false,
			padding : "5 0 0 5"
		});		
				
		warpContainer.add(infomationContainer);
		warpContainer.add(topMenuItemsPanel);
		
		this.items = warpContainer;
		
		this.callParent(arguments);
	},
	onPressLogo : function(){
		window.open("http://www.xaxis.com");
	},
	onPressLogout : function(){
		console.log("Logout click!!");
	}
});