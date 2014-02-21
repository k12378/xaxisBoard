Ext.define("xaxisBoardAdmin.view.CategoryList", {
	extend : "Ext.tree.Panel",
	alias : "widget.categoryListView",
	id : "categoryListContainer",
	title : "Category List",
	width : 200,
	height : 500,
	collapsible: true,
	frame : true,
	useArrows : true,
	rootVisible : false,
	store : "categoryList",
	initComponent : function(){				 
		this.callParent();
	}	
});