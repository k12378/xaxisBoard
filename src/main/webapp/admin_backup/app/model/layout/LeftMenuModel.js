Ext.define("xaxisBoard.model.layout.LeftMenuModel", {
	extend : "Ext.data.Model",
	alias : "widget.leftMenuModel",
	fields : [
	         	{ name : "name", type : "string" },
		       	{ name : "url", type : "string" },
		       	{ name : "items", type : "items" }
	],
	associations :[ 
		{type:"hasMany", model: "leftMenuItemModel", name : "items"}
	]
});