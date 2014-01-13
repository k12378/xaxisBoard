Ext.onReady(function(){
	
	Ext.state.Manager.setProvider(Ext.create("Ext.state.CookieProvider"));
	
	var viewport = Ext.create("Ext.Viewport", {
		layout : {
			type : "border",
			padding : 1
		},
		defaults : {
			split : true
		},
		items : [{
					region : "north",
					split : false,
					height : 100,
					minHeight : 80,
					html : "<h1>TopMenu</h1>"
			
				}, {
					region : "west",
					collapsible : true,
					title : "Left Menu",
					layout : "absolute",
					title : "Side Menu",
					split : false,
					width : "20%",
					minWidth : 100,
					minHeight : 600,
					autoScroll : true,
					bodyPadding : 10,
					stateId : "leftMenuPanel",
					html : "<div>left</div>"
					
				},{
					region : "center",
					title : "Menu Location",
					split : false,
					html : "Center",
					width : "80%",
					minHeight: 600,
					autoScroll : true,
					bodyPadding : 10,
					stateId : "contentsPanel",					
				}]
		
	});
});

Ext.define('BBS.view.admin.AdminLayout', {
	extend : "Ext.Component",
	xtype : "regionsetter",
	autoEl : {
		tag : "table",
		cn :[{
			tag : "tr",
			cn : [{
				tag : "td",
				align : "left",
				cls : "ux-allow ux-arrow-up",
				html : "&#9650;"
			}]
		},{
			tag : "tr",
			cn : [{
				tag : "td",
				align : "left",
				cls : "ux-allow ux-arrow-left",
				html : "&#9668"
			},{
				tag : "td",
				align : "left",
				html : "&#9658"
			}]
			
		}]
	},
	afterrender : function(){
		this.callParent();
		
		this.ownerCt.on({
			changeregion : "onChangeRegion",
			scope : this
		});
		this.onChangeRegion(this.ownerCt);
		this.el.on({
			click : this.onClick,
			scope : this
		});
	},
	onClick : function(e){
		var target = Ext.fly(e.getTarget());
		var region;
		if( target.hasCls("ux-arrow-up")){
			region = "north";
		}else if( target.hasCls("ux-arrow-left") ){
			region = "west";
		}
		
		if( region && region !== this.ownerCt.region ){
			this.ownerCt.setBorderRegion(region);
		}
	},
	onChangeRegion : function(panel, oldRegion){
		if( oldRegion ){
			this.removeCls("ux-aroow-current-"+ oldRegion);
		}
		this.addCls("ux-arrow-current-" + panel.region);
	}
});