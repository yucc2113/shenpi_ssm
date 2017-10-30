/**
 * ComboBoxGrid
 * @extend Ext.form.ComboBox
 * @xtype 'combogrid'
 * 
 * @author 王根友
 */
ComboBoxGrid = Ext.extend(Ext.form.ComboBox, {
	gridWidth : 100,
    gridHeight : 100,
    gridPageSize:10,
    gridRecordStart:0,
    gridColmodel:null,
    storeUrl:'',
    storeFields:[],
    combobox_grid_check_data:null,
    callbackName:'',
    isPage:true,
    url:'',
    setFieldValue:function(id,text){
        this.setValue(text);
        this.hiddenField.value = id;
    },
    store : new Ext.data.SimpleStore({
            fields : [],
            data : [[]]
    }),
    //Default
    editable : false, // 禁止手写及联想功能
    mode : 'local',
    triggerAction : 'all',
   	maxHeight : 500,
    selectedClass : '',
    onSelect : Ext.emptyFn,
    emptyText : '请选择...',
    /**
     * 初始化
     * Init
     */
    initComponent : function() {
        ComboBoxGrid.superclass.initComponent.call(this);
        var combo = this;
        this.tplId = Ext.id();
        this.tpl = '<div id="' + combo.tplId + '" ></div>';
        this.listWidth = combo.gridWidth;
        this.handleHeight = combo.gridHeight;
        var page_size = combo.gridPageSize;
        var record_start = combo.gridRecordStart;
		var store_fields = combo.storeFields;
		var grid_colmodel = combo.gridColmodel;
		var store_url = combo.storeUrl;
		var is_page = combo.isPage;
        var store = new Ext.data.JsonStore({
            autoLoad: true,
            url: store_url,
            root: "datas",
            totalProperty: "total",
            idProperty: "id",
            fields: store_fields,
            baseParams: {
                limit: page_size
            }
        });
        var grid = new Ext.grid.GridPanel({
        	width: this.gridWidth-3,
            height: this.gridHeight,
            layout: 'fit',
            border: false,
            viewConfig: { forceFit: true },
            loadMask: true,
            store: store,
            colModel: grid_colmodel,
            monitorResize: true,
            listeners:{
				rowdblclick : function(g,r,e){
					var rec = g.getSelectionModel().getSelected();
                    if (rec) {
                    	combo.setFieldValue(rec.data.id,rec.data.name);
                    	combo.combobox_grid_check_data = rec.data;
                		combo.collapse();
                    }
				}
			}
        });
        if(is_page){
        	grid = new Ext.grid.GridPanel({
	        	width: this.gridWidth-3,
	            height: this.gridHeight,
	            layout: 'fit',
	            border: false,
	            viewConfig: { forceFit: true },
	            loadMask: true,
	            store: store,
	            colModel: grid_colmodel,
	            monitorResize: true,
	            bbar: new Ext.PagingToolbar({
	                pageSize: page_size,
	                store: store,
	                displayInfo: true,
	                beforePageText: "第",
	                afterPageText: "/ {0}页",
	                firstText: "首页",
	                prevText: "上一页",
	                nextText: "下一页",
	                lastText: "尾页",
	                refreshText: "刷新",
	                displayMsg: "总{2}条记录",
	                emptyMsg: "没有相关记录!",
	                doLoad: function(start) {
	                    record_start = start;
	                    var o = {}, pn = this.paramNames;
	                    o[pn.start] = start;
	                    o[pn.limit] = this.pageSize;
	                    this.store.load({ params: o });
	                }
	            }),
	            listeners:{
					rowdblclick : function(g,r,e){
						var rec = g.getSelectionModel().getSelected();
	                    if (rec) {
	                    	combo.setFieldValue(rec.data.id,rec.data.name);
	                    	combo.combobox_grid_check_data = rec.data;
	                		combo.collapse();
	                    }
					}
				}
	        });
        }
        this.panel = grid;
    },

    /**
     * ------------------
     * 事件监听器 
     * Listener
     * ------------------
     */
    listeners : {
        'expand' : {
            fn: function() {
                if (!this.panel.rendered && this.tplId) {
                    this.panel.render(this.tplId);
                }
                this.panel.show();
            }
        },
        'render':{
            fn:function(){
                this.hiddenField = this.el.insertSibling({
                    tag:'input',
                    type:'hidden',
                    name:this.getName()
                },'before',true);
                this.el.dom.removeAttribute('name');
            }
        },
        'collapse': {
        	fn:function(){
        		if(!Ext.isEmpty(this.callbackName)){
        			var fun = this.callbackName+"("+this.combobox_grid_check_data+")";
    				eval(fun);
        		}
	    	}
        }
    }
});

/**
 * --------------------------------- 
 * 将ComboBoxGrid注册为Ext的组件,以便使用
 * Ext的延迟渲染机制，xtype:'combogrid' 
 * ---------------------------------
 */
Ext.reg('combogrid', ComboBoxGrid);


