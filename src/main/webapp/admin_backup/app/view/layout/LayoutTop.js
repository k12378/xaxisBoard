Ext.define("xaxisBoardAdmin.view.layout.LayoutTop", {
	extend : "Ext.panel.Panel",
	alias : "widget.layoutTop",
	height : 100,
	id : topRegionId,
	padding : "0 0 0 0",
	layout : "absolute",
	initComponent : function(){		
		this.callParent(arguments);
	},
	onPressLogo : function(){
		console.log("xaxis logo click");
		window.open("http://www.xaxis.com", "", "");
	},
	getApplicationWidth : function(){
		var width = window.innerWidth || document.body.clientWidth;
		return width;
	}
});