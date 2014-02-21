Ext.application({
	requires : ["Ext.container.Viewport"],
	name : "xaxisBoardAdmin",
	appFoler : "app",
	controllers : ["AppController"],
	launch : function(){
		Ext.create("Ext.container.Viewport", {
			layout : "auto",
			items : [
			         {
			        	id : "topWarp",
			        	xtype : "topLayout"			        		
			         },
			         {
			        	id : "contentWarp",
			        	xtype : "panel",
			        	items : [{
			        		tag : "div",
			        		html : "Content View"
			        	}]
				     }  
			]
		});
	}
});