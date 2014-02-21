Ext.define("xaxisBoardAdmin.view.Category", {
	extend : "Ext.panel.Panel",
	id : "categoryView",
	alias : "widget.category",
	layout : "auto",
	minHeight : 500,
	title : "Application > Category",
	initComponent : function(){
		
		var warpContainer = Ext.create("Ext.container.Container", {
			layout : {
				type : "hbox",				
			},
			border: false,
			padding : 10
		});
		
		var listPanel = Ext.create("Ext.panel.Panel", {
			id : "categoryListPanel",
			border : false,
			padding : "0 0 0 10",
			flex : 1
		});
		
		var viewPanel = Ext.create("Ext.panel.Panel",{
			id : "categoryDetailPanel",
			border : false,
			padding : "0 10 0 0",
			flex : 2
		});
		
		
		var categoryDetailView = Ext.create("Ext.panel.Panel",{
			title : "Category Infomation"
		});
		
		var categoryList = Ext.create("Ext.panel.Panel", {
			xtype : "categoryListView",
			title : "Category List"
		});
		
		listPanel.add(categoryList);
		
		viewPanel.add(categoryDetailView);
		
		warpContainer.add(listPanel);
		warpContainer.add(viewPanel);
		
		this.items = warpContainer;
		
		this.callParent(arguments);
	}
});