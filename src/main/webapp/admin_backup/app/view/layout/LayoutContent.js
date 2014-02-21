Ext.define("xaxisBoardAdmin.view.layout.LayoutContent", {
	extend : "Ext.panel.Panel",
	alias : "widget.layoutContent",
	layout : {
		type : "vbox",
		align : "left"
	},
	region : "center",
	id : contentRegionId,
	padding : "0 0 0 0",
	initComponent : function(){		
		this.callParent(arguments);
	}
});