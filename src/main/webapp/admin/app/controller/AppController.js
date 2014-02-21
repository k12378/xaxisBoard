Ext.define("xaxisBoardAdmin.controller.AppController", {
	extend : "Ext.app.Controller",
	views : ["TopLayout", "Category", "CategoryList"],
	models : ["TopMenu", "CategoryList"],
	stores : ["TopMenu", "CategoryList"],
	refs : [{
		ref : "mainView", selector : "#contentWarp" 
	},
	{
		ref : "categoryView", selector : "#categoryView"
	},
	{
		ref : "categoryListPanel", selector : "#categoryListPanel"
	},
	{
		ref : "categoryDetailPanel", selector : "#categoryDetailPanel"
	}],
	init : function(){
		/**
		 * 첫 실행시 호출 함수
		 */
		this.control({
			"viewport > panel" : {
				render : this.onContainerRendered
			},
			"topLayout #topMenuItemsPanel" : {
				render : this.onTopMenuItemsPanelRendered
			},
			"topLayout button[name=topMenuItem]" : {
				click : this.onPressTopMenuItem
			}
		});
	},
	onContainerRendered : function(panel){
		/**
		 * 패널 컨테이너가 로드시 마다 호출
		 */
		console.log("rendered By "+ panel["id"]);
	},
	onTopMenuItemsPanelRendered : function(item){
		/**
		 * 탑 메뉴 아이템을 생성. Json Resource 파싱하여 자동 생성
		 */
		var topMenuStore = this.getTopMenuStore();
		topMenuStore.load({
			callback : function( records, opperation, success ){
				if( success ){
					records.forEach(function(entry){
						console.log(entry.get("name"));
						var templateTopMenuItem = Ext.create("Ext.Button", {
							name : "topMenuItem",
							text : entry.get("name"),
							width : entry.get("width"),
							height : entry.get("height"),
							data : entry,
							margin : "0 0 0 5",
							border : false
						});						
						item.add(templateTopMenuItem);
					});
				}
			}
		});
	}, 
	onPressTopMenuItem : function(item){
		/**
		 * 컨텐츠 영역 변경
		 */
		var targetCode = item["data"]["data"]["name"];
		
		switch(targetCode){
			case "Category" :
				// 뷰 내용 삭제
				this.getMainView().removeAll();								
				this.getMainView().add(this.getCategoryView());
				// categoryList 생성
				this.onLoadCategoryList();				
				
				break;
			default :
				console.log("Not found Target View");
				break;
		}
	},
	onLoadCategoryList : function(){
		/**
		 * 카테고리 뷰 로드시 데이터 조회 및 화면 구성 내용 조회
		 */			
		this.getCategoryListPanel().removeAll();
		
		var caregoryDetailPanel = this.getCategoryDetailPanel();
		
		var categoryList = Ext.create("Ext.tree.Panel", {
			id : "categoryTreeList",
			title : "Category List",
			width : 200,
			height : 300,
			store : this.getCategoryListStore(),
			rootVisible : false,
			listeners : {
				itemclick : function(view, record, item, index, e){
					// 카테고리 디테일 폼 내용 삭제. 
					caregoryDetailPanel.removeAll();
					
					// form Element 생성					
					var categoryDetailForm = Ext.create("Ext.form.Panel", {
						title : "Category Infomation > " + record.data.text,
						data : record.data,
						height : 300,
						width : 800,
						items : [{
							
						}]
					});
					
					
					// 카테고리 폼 변경					
					caregoryDetailPanel.add(categoryDetailForm);
				}
			}
		});
		
		this.getCategoryListPanel().add(categoryList);
	}
});