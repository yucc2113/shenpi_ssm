/**
 * ComboBoxPanel
 * @extend Ext.form.ComboBox
 * @xtype 'combopanel'
 * 
 * @author wgy
 */
 /*-------------------------------------------------*
	 {
            xtype:'combopanel',
            fieldLabel:'选择学生',
            name:'department_id',
            panelWidth : 100,
		    panelHeight : 100,
		    panelPageSize:10,
		    panelRecordStart:0,
		    /---可选参数----/
		    selectType:false,//默认值:false,只选登录人部门:true
    		selectReturn:0,//	选中后触发的参数；默认值:0 , 1-奖学金管理
	}
*-----------------------------------------------------*/
var combobox_panel_check_data = null;
ComboBoxPanel = Ext.extend(Ext.form.ComboBox, {
	panelWidth : 100,
    panelHeight : 100,
    panelPageSize:10,
    panelRecordStart:0,
    selectType:false,
    selectDeptId:-1,		//查询固定机构学生
    selectReturn:0,			//0-默认值 1-单项奖学金 11-三好学生评优 20-处分管理 21-学籍变动 22-困难学生 23-学生寒暑假住宿 24-助学管理 25-助学贷款 30-学生走读管理 
    isOpen:true,			//是否开启
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
        ComboBoxPanel.superclass.initComponent.call(this);
        this.tplId = Ext.id();
        this.tpl = '<div id="' + this.tplId + '" ></div>';
        if(this.isOpen){
        	this.listWidth = this.panelWidth+3;
        	this.handleHeight = this.panelHeight;
        }else{
        	this.listWidth = 0;
        	this.handleHeight = 0;
        }
        var page_size = this.panelPageSize;
        var record_start = this.panelRecordStart;
        var combo = this;
        var search_sno = "";
        var search_name = "";
		var search_type = 0;
		var search_value = 0;
		var select_type = this.selectType;
		var select_dept_id = this.selectDeptId;
		var select_return = this.selectReturn;
        var user_grid_store = new Ext.data.JsonStore({
            autoLoad: true,
            url: "student/student!searchStudentList",
            root: "datas",
            totalProperty: "total",
            idProperty: "id",
            fields: ['id','sno','name','deptId','major','grade','clno','degree','eduYear',
                		'attendDate','idCard','sex','nationg','political','birthDate','origin',
                		'rideSchool','rideFamily','familyPost','familyAddress','fullName','examNo',
                		'checkup','schStatus','dorm','roomNo','homePlace','gradYear','dormName','roomNoName',
                		'phone','email','tel','homepage','qq','blog','skill','highSch','photo',
                		'isHard','isGreen','counsellor','arts','usedName','faith','trace','isLoan',
                		'tutor','cardno','flag','remark','deptName','majorName','degreeName','familyPhone','familyRel',
                		'eduyearName','nationgName','politicalName','schstatusName','duty','attendDateDesc','birthDateDesc',
                		'sexName','checkupName','ishardName','isgreenName','isloanName','familyName','familyUnit','familyTel'],
            baseParams: {
                limit: page_size
            }
        });
        var  dept_tree_root = new Ext.tree.AsyncTreeNode({
	        id:'0@0',	//id@type	type:1-学院 2-专业 3-年级 4-班级
	        text:'根目录'
	    });
        var dept_tree = new Ext.tree.TreePanel({
	    	split: true,
	    	autoScroll: true,
	    	animate: true,
	        loader: new Ext.tree.TreeLoader({
	        	dataUrl: 'student/student!searchStudentTree?selectType='+select_type+'&deptId='+select_dept_id,
	        	listeners: {
		            beforeload: function(treeLoader,node) {
		            	var node_id = node.attributes.id.split('@');
	        			treeLoader.dataUrl = 'student/student!searchStudentTree?selectType=' + select_type +'&searchTreeType='+node_id[1]+'&searchTreeValue='+node_id[0]+'&deptId='+select_dept_id;
		            }
		        }
	        }),
	        root:dept_tree_root,
	        rootVisible:false,
	        border: false
	    });
	    dept_tree.on('click',function(node){
	        node.expand();
	        node.select();
	        var node_id = node.attributes.id.split('@');
	        search_sno = "";
	        search_name = "";
			search_value = node_id[0];
			search_type = node_id[1];
			Ext.getCmp('search_sno').setValue("");
			Ext.getCmp('search_name').setValue("");
			user_grid_store.reload();
	    });
		var dept_tree_panel = new Ext.Panel({
            title: '学院-专业-年级-班级',
            region: 'west',
            split: true,
            width: 200,
            collapsible: true,
            margins:'3 0 3 3',
            cmargins:'3 3 3 3',
            layout: 'fit',
            items: dept_tree
        });
        user_grid_store.on('beforeload', function() {
	        Ext.apply(this.baseParams, {
	        	searchSno: search_sno,
	            searchName: search_name,
	            searchTreeType: search_type,
	            searchTreeValue: search_value,
	            selectType: select_type,
	            deptId:select_dept_id
	        });
	    });
        var user_grid = new Ext.grid.GridPanel({
            layout: 'fit',
            region: 'center',
            margins:'3 3 3 0',
            viewConfig: { forceFit: true },
            loadMask: true,
            store: user_grid_store,
            columns: [
                new Ext.grid.RowNumberer({
                    renderer: function(value, metadata, record, rowIndex) {
                        return record_start + 1 + rowIndex;
                    }
                }),
                { header: '学号', width: 100, dataIndex: 'sno', sortable: true },
                { header: '姓名', width: 100, dataIndex: 'name', sortable: true },
                { header: '专业', width: 100, dataIndex: 'majorName', sortable: true },
                { header: '年级', width: 100, dataIndex: 'grade', sortable: true },
                { header: '班号', width: 100, dataIndex: 'clno', sortable: true }
            ],
            bbar: new Ext.PagingToolbar({
                pageSize: page_size,
                store: user_grid_store,
                displayInfo: true,
                beforePageText: "第",
                afterPageText: "/ {0}页",
                firstText: "首页",
                prevText: "上一页",
                nextText: "下一页",
                lastText: "尾页",
                refreshText: "刷新",
                displayMsg: "当前显示记录从 {0} - {1} 总 {2} 条记录",
                emptyMsg: "没有相关记录!",
                doLoad: function(start) {
                    record_start = start;
                    var o = {}, pn = this.paramNames;
                    o[pn.start] = start;
                    o[pn.limit] = this.pageSize;
                    this.store.load({ params: o });
                }
            }),
            tbar: [{
               xtype: "tbtext",
			   text: "学生学号:"
			},{
				xtype: "textfield",
                id: 'search_sno',
                name: 'search_sno',
                width: 100
			},{
               xtype: "tbtext",
			   text: "学生姓名:"
			},{
				xtype: "textfield",
                id: 'search_name',
                name: 'search_name',
                width: 100
			},{
                id: 'search_button',
                text: '查询',
                cls: 'x-btn-text-icon',
                icon: 'image/query.gif',
                handler: function(){
                	search_sno = Ext.getCmp('search_sno').getValue();
                	search_name = Ext.getCmp('search_name').getValue();
                	user_grid_store.reload();
                }
            },'->',{
                text: '确定',
                cls: 'x-btn-text-icon',
                icon: 'image/add.gif',
                handler:function(){
                	var rec = user_grid.getSelectionModel().getSelected();
                    if (rec) {
                        combo.setValue(rec.data.name);
                		combo.hiddenField.value =rec.data.id;
                		combobox_panel_check_data = rec.data;
                		combo.collapse();
                    } else {
                        combo.collapse();
                    }
                }
            }],
            monitorResize: true,
            listeners:{
				rowdblclick : function(g,r,e){
					var rec = g.getSelectionModel().getSelected();
                    if (rec) {
                        combo.setValue(rec.data.name);
                		combo.hiddenField.value =rec.data.id;
                		combobox_panel_check_data = rec.data;
                		combo.collapse();
                    }
				}
			}
        });
        var panel = new Ext.Panel({
            width: this.panelWidth,
            height: this.panelHeight,
            layout: 'border',
            border: false,
            items: [dept_tree_panel,user_grid]
        });
        this.panel = panel;
        this.dept_tree_root = dept_tree_root;
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
            	if(this.isOpen){
	                if (!this.panel.rendered && this.tplId) {
	                    this.panel.render(this.tplId);
	                }
	                this.dept_tree_root.expand();
	                this.panel.show();
            	}else{
            		$(this.tplId).hide();
            	}
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
        		if(this.selectReturn==1)
	    			ScholarshipDetailSingle.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==2)
        			ScholarshipDetailNation.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==3)
        			ScholarshipDetailGov.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==4)
        			ScholarshipDetailPresident.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==5)
        			ScholarshipDetailExcellent.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==11)
        			ExcellenceDetailGood.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==12)
        			ExcellenceDetailModel.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==13)
        			ExcellenceDetailRoom.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==14)
        			ExcellenceDetailClass.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==15)
        			ExcellenceDetailGrad.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==16)
        			ExcellenceDetailCadre.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==17)
        			ExcellenceOther.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==20)
        			Punish.getStudentInfo(combobox_panel_check_data);
        		if(this.selectReturn==21)
        			CensusChange.getStudentInfo(combobox_panel_check_data);
        		if(this.selectReturn==22)
        			DifficultDetail.getStudentInfo(combobox_panel_check_data);
        		if(this.selectReturn==23)
        			StayAll.getStudentInfo(combobox_panel_check_data);
        		if(this.selectReturn==24)
        			Work.getStudentInfo(combobox_panel_check_data);
        		if(this.selectReturn==25)
        			StudyFund.getStudentInfoFamily(combobox_panel_check_data);
       			if(this.selectReturn==30)
        			Extern.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==31)
        			GrantTaskDetail.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==32)
        			MinorityNationalityTaskDetail.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==33)
        			XinJiangMinorityNationalityTaskDetail.getStudentInfo(this.hiddenField.value);
        		if(this.selectReturn==34)	
        			ScholarshipDetailSingleI.getStudentInfo(this.hiddenField.value);
       			if(this.selectReturn==35)	
       				ScholarshipDetailGovI.getStudentInfo(this.hiddenField.value);
       			if(this.selectReturn==36)	
       				ScholarshipDetailPresidentI.getStudentInfo(this.hiddenField.value);
       			if(this.selectReturn==37)	
       				ScholarshipDetailExcellentI.getStudentInfo(this.hiddenField.value);
       			if(this.selectReturn==38)	
       				ScholarshipDetailNationI.getStudentInfo(this.hiddenField.value);
       			if(this.selectReturn==39)	
       				ExcellenceDetailGoodI.getStudentInfo(this.hiddenField.value);
    			if(this.selectReturn==42)	
    				ExcellenceDetailGradI.getStudentInfo(this.hiddenField.value);
    			if(this.selectReturn==43)	
    				ExcellenceDetailCadreI.getStudentInfo(this.hiddenField.value);
	    	}
        }
    }
});

/**
 * --------------------------------- 
 * 将ComboBoxPanel注册为Ext的组件,以便使用
 * Ext的延迟渲染机制，xtype:'combopanel' 
 * ---------------------------------
 */
Ext.reg('combopanel', ComboBoxPanel);


