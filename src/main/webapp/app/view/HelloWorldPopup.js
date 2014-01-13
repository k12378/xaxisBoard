Ext.define("BBS.view.HelloWorldPopup", {
	extend : "Ext.tab.Panel",
	alias : "widget.helloPopup",	
	width : "100%",
	height : 300,
	layout : "fit",
	activeTab : 0,
	items : [{
				title : "Hello",
				bodyPadding : 10,
				html : "first Panel"
			},{
				title : "World",
				bodyPadding : 10,
				html : "second Panel"
			}],
	renderTo : Ext.getBody()
});