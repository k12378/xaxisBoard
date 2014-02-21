Ext.define("xaxisBoardAdmin.model.TopMenu", {
	extend : "Ext.data.Model",
	fields : [{
		name : "name", type : "string"		
	}, {
		name : "url", type : "string"
	}, {
		name : "description", type : "string"
	}, {
		name : "width", type : "int"
	}, {
		name : "height", type : "int"
	}],
	proxy : {
		type : "ajax",
		url : "/xaxisBoard/properties/topMenu.json",
		reader : {
			type : "json",
			root : "menus"
		}
	}	
});