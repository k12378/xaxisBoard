Ext.define("BBS.controller.HelloWorld", {
	extend : "Ext.app.Controller",
	// views : ["HelloWorldPopup"],
	init : function(){
		this.control({
			"viewport > panel" : {
				render : this.onPanelRendered
			}
		});
	},
	onPanelRendered : function(){
		console.log("The panel was rendered");
	}
});