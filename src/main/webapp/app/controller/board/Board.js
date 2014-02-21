Ext.onReady(function(){
	Ext.define("message", {
		extend : "Ext.data.Model",
		fields : [
		          	{name : "messageId", type : "int"},
		          	{name : "boardCode", type : "string"},
				 	{name : "subject", type : "string"},
				 	{name : "contentsIdx", type : "int"},
				 	{name : "message", type : "messageContent"},
				 	{name : "messageContents", type : "string"},
				 	{name : "secretCode", type : "string"},
				 	{name : "recommendanteCount", type : "int"},
				 	{name : "viewCount", type : "int" },
				 	{name : "tags", type : "string" },
				 	{name : "topFlag", type : "int"},
				 	{name : "parentMessageCode", type : "int" },
				 	{name : "messageLevel", type : "int" },
				 	{name : "displayOrder", type : "int" },
				 	{name : "nickName", type : "string" },
				 	{name : "registDate", type : "string"},
				 	{name : "register", type : "string" },
				 	{name : "updateDate", type : "string"},
				 	{name : "updater", type : "string" }
				 ],
		associations : [
		                {type:"belongsTo", model: "messageContent", name : "message"}
		                ]
		
		
	});	

	Ext.define("messageContent", {
		extend : "Ext.data.Model",
		fields : [
		          	{name : "contentsID", type : "int"},
		          	{name : "bytesMessage", type : "string"},
		          	{name : "messageContents", type : "string"}
		          
		         ]
	});
});

Ext.define("BBS.controller.board.Board", {
	extend : "Ext.app.Controller",
	views : ["board.List", "board.Edit"],
	init : function(){
		console.log("controller run init function");
		this.control({
			"viewport > panel" : {
				render : this.onPanelRendered
			},
			"boardList" : {
				itemdblclick : this.editBoardMessage
			}
		});
	},
	onPanelRendered : function(){
		console.log("The panel was rendered");
	},
	editBoardMessage : function(grid, record){
		console.log("double clicked on "+ record.get("messageId"));
		
		var requestUrl = contextRoot + "/board/"+ boardCode +"/item/"+ record.get("messageId") +"/";	
	
		var view = Ext.widget('boardedit');
		
		view.onTest();
		
		var recordStore = Ext.create("Ext.data.Store", {
			model : "message",
			proxy :{
				type : "ajax",
				url : requestUrl,
				reader : {
					type : "json",
					root : "data"
				}
			}
			
		});
	
		recordStore.load({
			callback : function(records, operation, success){
				records.forEach(function(entry){
					console.log("item = > " + entry);
					if( entry.get("messageId") == record.get("messageId") ){
						entry.set("subject", decodeURI(entry.get("subject")));
						entry.set("nickName", decodeURI(entry.get("nickName")));
						entry.set("messageContents", decodeURI(entry.get("message")["messageContents"]));						
						view.down('form').loadRecord(entry);
					}
				});
			},
			scope : this
		});
	}
});