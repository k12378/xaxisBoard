Ext.define("xaxisBoardAdmin.store.CategoryList", {
	extend : "Ext.data.TreeStore",
	requires : ["xaxisBoardAdmin.model.CategoryList"],
	model : "xaxisBoardAdmin.model.CategoryList",
	storeId : "categoryList"
});