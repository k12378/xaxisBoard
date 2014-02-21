// region ids
var topRegionId, westRegionId, bottomRegionId, contentRegionId;

var contentTitle;

var topMenuData;

Ext.onReady(function(){
	
	// Application Variable	
	topReionId = "xaxis-board-admin-layout-top";
	westRegionId = "xaxis-board-admin-layout-west";
	bottomRegionId = "xaxis-board-admin-layout-south";
	contentRegionId = "xaxis-board-admin-layout-center";
	contentTitle = "Application Navigation";

});

Ext.application({
	requires : ["Ext.container.Viewport"],
	name : "xaxisBoardAdmin",
	appFoler : "app",
	controllers : ["layout.Layout"], 
	launch : function(){
		
		console.log("app launcher function load");
		
		Ext.create("Ext.container.Viewport", {
			id : "xaxis-board-admin-layout",
			layout : "border",
			border: false,
			items : [			         
			         {
			        	 region : "north",
			        	 id : topRegionId,
			        	 xtype : "layoutTop"
			         },			        
			         // Left Menu
			         {
			        	region : "west",
			        	id : westRegionId,
			        	xtype : "panel",
			        	width : 200,
			        	padding : 0,
			        	margins : "1 1 1 1",
			        	title : "West Side",
			        	collapsible : true,
			        	hidden : true,
			        	layout : "fit"			        	
			         },			         
			         // Center
			         {
			        	 region : "center",
			        	 id : contentRegionId,
			        	 xtype : "layoutContent",
			        	 title : contentTitle,
			        	 autoScroll : true
			         
			         },
			         // Bottom
			         {
			        	 region : "south",
			        	 id : bottomRegionId,
			        	 padding : 0,
			        	 margins : "1 1 1 1",
			        	 height: 25,
			        	 html : "<div style='text-align:right;padding-right:20px;padding-top:5px;'>xaxis</div>"
			        	 
			         }   
			]
		});
	}
});