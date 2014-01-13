Ext.define("BBS.controller.admin.Admin", {
	extend : "Ext.app.Controller",
	views : ["admin.AdminLayout"],
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