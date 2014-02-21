Ext.define("xaxisBoardAdmin.model.CategoryList", {
	extend : "Ext.data.Model",
	fields : [{
		name : "id", type : "int"
	},{
		name : "text", type : "string"
	},{
		name : "parentCode", type : "int"
	},{
		name : "depth", type : "int" 
	},{
		name : "displayOrder", type : "int" 
	}],
	proxy : {
		type : "ajax",
		url : "/xaxisBoard/category/list/tree/",
		reader : {
			type : "json"
		}
	}
});