Ext.define('BBS.view.board.List', {
	extend : "Ext.grid.Panel",
	alias : "widget.boardList",
	title : boardCode + " List",
	initComponent : function(){
		
		Ext.define("boardListModel",{
			extend : "Ext.data.Model",
			fields : [
			         	{name : "messageId", type : "int"},
			         	{name : "boardCode", type : "string"},
			         	{name : "subject", type : "string"},
			         	{name : "contentsIdx", type : "int"},
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
			         ]
		});	
		
		var requestUrl = contextRoot + "/board/"+ boardCode +"/list/";
		console.log("requestUrl => "+  requestUrl);
		this.store = Ext.create("Ext.data.Store", {
			model : "boardListModel",				
			proxy : {
				type : "ajax",
				url : requestUrl,
				reader : {
					type : "json",
					root : "data"
				}
			},
			autoLoad : true
		});
		
		this.columns = [
		               		{header : "message Id", dataIndex : "messageId", flex : 1 },
		               		{header : "Subject", dataIndex : "subject", flex : 1 },
		               		{header : "Writer", dataIndex : "register", flex : 1 },
		               		{header : "Regist Date", dataIndex : "registDate", flex : 1 },
		               		{header : "view Count", dataIndex : "viewCount", flex : 1 },
		               		{header : "recommendante Count", dataIndex : "recommendanteCount", flex : 1 }            		
		              ];
		
		this.callParent(arguments);
		
	}
});