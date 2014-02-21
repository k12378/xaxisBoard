Ext.application({
	requires : ["Ext.container.Viewport"],
	name : "BBS",
	appFoler : "app",
	controllers : ["board.Board"], 
	launch : function(){
		Ext.create("Ext.container.Viewport", {
			layout : "fit",
			items : {
				xtype : "boardList"
			}
		});
	}
});