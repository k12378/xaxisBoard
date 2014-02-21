var defaultMenuName = "Category";
var leftMenuData;
var contentPanel;

Ext.onReady(function(){
	
});

Ext.define("xaxisBoardAdmin.controller.layout.Layout", {
	extend : "Ext.app.Controller",
	views : ["layout.LayoutTop", "layout.LayoutContent"],
	//views : ["layout.LayoutTop", "layout.LayoutContent", "common.SearchForm"],
	init : function(){
		console.log("controller run init function");
				
		this.control({
			"viewport > panel" : {
				render : this.onPanelRendered,
			},
			"layoutTop button[name=menuItems]" : {
				click : this.topMenuItemClick
			},
			"layoutTop button[name=logout_btn]" : {
				click : this.logoutBtnClick
			}
		});
	},
	logoutBtnClick : function(item){
		console.log("logout");
	},
	topMenuItemClick : function(item){
		var itemDataObj = item["data"]["data"];
		this.changeContent(contentPanel, itemDataObj["name"]);
	},
	onPanelRendered : function(panel){
		
		//console.log( panel );
		
		// Top Menu Load
		if( panel["region"] == "north" )			
			this.loadTopMenuItems(panel);
		// Top Menu Load 종료
		
		// LEFT Menu Load
		if( panel["region"] == "west" )
			this.loadLeftMenuItemData(panel);		
		// LEFT Menu Load 종료 
		
		if( panel["region"] == "center")
			this.changeContent(panel, defaultMenuName);
	},
	loadTopMenuItems : function( panel ){
		
		Ext.define("topMenuModel", {
			extend : "Ext.data.Model",
			fields : [
			         	{ name : "name", type : "string" },
			         	{ name : "url", type : "string" },
			         	{ name : "description", type : "string" },
			         	{ name : "width", type : "int" },
			         	{ name : "height", type : "int" }
			
			]
		});
		
		panel.add(Ext.create("Ext.Img", {
			id : "xaxis-logo",
			src : contextRoot + "/images/logo.jpg",
			width : 95,
			height: 65,
			x : 10,
			y : 10,
			listeners : {
				click : {
					element : "el",
					fn : panel.onPressLogo
	       		 }
	       	  }
	    }));
		
		panel.add(Ext.create("Ext.Button", {
	      	  id : "logout_btn",
	      	  name : "logout_btn",
	    	  text : "Logout",
	    	  width : 70,
	    	  height : 20,
	    	  x : panel.getApplicationWidth() - 100,
	    	  y : 10,
	    	  handler : panel.onPressLoginButton     	  
	    }));
		
		var topMenuStore = Ext.create("Ext.data.Store",{
			model : "topMenuModel",
			proxy : {
				type : "ajax",
				url : contextRoot + "/properties/topMenu.json",
				reader : {
					type : "json",
					root : "menus"
				}
			}
		});
		
		//console.log( topMenuStore );
		
		topMenuStore.load({
			callback : function(records, operation, success){					
				var xPosition = 100;
				var yPosition = 60;									
				records.forEach(function(entry){
					var templateMenu = Ext.create("Ext.Button", {
						id : entry.get("name"),
						name : "menuItems",
						text : entry.get("name"),
						width : entry.get("width"),
						height : entry.get("height"),
						data : entry,
						x : xPosition + 100,
						y : yPosition							
					});
					xPosition += 100;
					panel.add(templateMenu);
				});	
			}
		});
		
		//console.log("top menu loaded");
	},
	loadLeftMenuItemData : function(panel){
		/*
		var leftMenuStore = Ext.create("Ext.data.Store", {
			model : "",
			proxy : {
				type : "ajax",
				url : contextRoot + "/properties/leftMenu.json",
				reader : {
					type : "json",
					root : "menus"
				}
			}
		});
		
		leftMenuStore.load({
			callback : function( records, operation, success ){
				
			}
		});
		*/
	},
	changeContent : function(panel, menuName){
		contentPanel = panel;		
		// Navigation Text 변경
		contentPanel.setTitle("Application > " + menuName);
		
		// view 아이템 삭제
		contentPanel.removeAll();
		
		// 서치 폼 생성
		contentPanel.add(this.makeSearchForm(menuName));
		
		// 리스트 조회
		contentPanel.add(this.makeContentList(menuName));
	},
	makeContentList : function(menuName){
		var listContent;
		
		switch(menuName){
			case "Category" :
				listContent = this.makeCategoryContentList();
				break;
			case "Group" :
				listContent = this.makeGroupContentList();
				break;
			case "BoardConfig" :
				listContent = this.makeBoardConfigList();
				break;
			default :
				listContent = this.makeCategoryContentList();
				break;
		}
		
		return listContent;
	},
	makeCategoryContentList : function(){
		console.log("makeCategoryContentList loadding!");
		
		var categoryContainer = Ext.create("Ext.container.Container", {
			layout : {
				type : "hbox"
			},
			anchor : "100%"
		});
		
		Ext.define("category", {
			extend : "Ext.data.Model",
			fields : [
			          	{ name : "categoryCode", type : "string" },
			          	{ name : "categoryName", type : "string" }
			]
		});
		
		var categoryListStore = Ext.create("Ext.data.Store", {
			model : "category",
			proxy : {
				type : "ajax",
				url : contextRoot + "/category/list/",
				reader : {
					type : "json",
					root : "data"				
				}
			}
		});
		categoryListStore.load();
		var categoryGridPanel = Ext.create("Ext.grid.Panel", {
			title : "Category",
			width : 300,
			height : 300,
			margins : "10 10 10 10",
			autoScroll : true,
			store : categoryListStore,
			anchor : "50%",
			columns : [
			           	{ text : "Code", dataIndex : "categoryCode", flex : 100 },
			           	{ text : "Name", dataIndex : "categoryName", flex : 200 }			           	
			],
			listeners : {
			    itemdblclick: this.categoryItemClick
			}			
		});
		
		
		
		categoryContainer.add(categoryGridPanel);
		//consoleOutStoreData(categoryListStore, "categoryName");		
		
		return categoryContainer;

	},
	categoryItemClick : function(dv, record, item, index, e){
		console.log(record);
		var categoryId = record["data"]["categoryCode"];
		
		var categoryItemStore = Ext.create("Ext.form.Panel", {
			
		});
		
		
	},
	makeGroupContentList : function(){
		console.log("makeGroupContentList loadding!");
	},
	makeBoardConfigList : function(){
		console.log("makeBoardConfigList loadding!");
	},
	makeSearchForm : function(menuName){
		
		console.log("MenuName => "+ menuName);
		
		var searchContainer = Ext.create("Ext.container.Container", {
			layout : {
				type : "hbox"
			},
			anchor : "100%"
		});	
		
		// combo box 생성	
		Ext.define("searchFormCombobax", {
			extend : "Ext.data.Model",
			fields : [
			          { name : "display", type : "string" },
			          { name : "value", type : "string" }
			]
		});
				
		var searchComboBox = Ext.create("Ext.data.Store", {
			model : "searchFormCombobax",
			proxy : {
				type : "ajax",
				url : "/xaxisBoard/properties/searchItems.json",
				reader : {
					type : "json",
					root : menuName
				}
			}
		});
		
		searchContainer.add(Ext.create("Ext.form.ComboBox", {
			fieldLabel : "Search Type",
			store : searchComboBox,
			displayField : "display",
			valueField : "value",
			margins : "8 5 10 5",
			autoSelect : true
		}));
		
		searchContainer.add({
     		xtype : "textfield",
			name : "searchKeyword",
			fieldLabel : "Search Keyword",
			allowBlank : false,
			padding : 10,
			anchor : "35%"
        });
		
		searchContainer.add(Ext.create("Ext.Button", {
			name : "searchBtn",
			text : "Search",
			width : 75,
			height : 25,
			margin : "8 5 10, 5",
			anchor : "35%"
		}));
				
		var searchForm = Ext.create("Ext.form.Panel", {
			title : "Search",
			height : window.innerWidth,
			margin : "10 10 10 10",
			width : "100%",
			height : 80,
			border : true,
			collapsible: true,
			collapsed: true,
			url : ""
		});
		
		searchForm.add(searchContainer);
		return searchForm;
	},
	searchSubmit : function(){
		console.log("submit Search");
	}
});


function consoleOutStoreData(store, key){
	store.load({
		callback : function( records, opperation, success ){
			if( success ){
				records.forEach(function(entry){
					console.log("store "+ key + "value => "+ entry.get(key));
				});
			}
		}
	});
};