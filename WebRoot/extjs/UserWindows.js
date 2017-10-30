/**
 * Wgy.UserWindows
 * @extend Ext.Window
 * @xtype 'userwindows'
 * 
 * @author wgy
 */
Ext.namespace('Wgy');
Wgy.UserWindows = Ext.extend(Ext.Window, {
	//自定义参数设置
	detWidth : 200,
    stdPageSize:10,
    stdRecordStart:0,
    selectType:false,		//是否选择本部门
    selectDeptId:-1,		//查询固定部门学生
    selectSort:1,			//操作权限 1-管理员 2-学院 3-学生工作处 4-学生 5-处长
    isCheckNode:false,		//是否带有CheckBox样式
	nodeCheckModel:'cascade',//多选: 'multiple' 单选: 'single' 级联多选: 'cascade'(同时选父和子)(默认);'parentCascade'(选父);'childCascade'(选子) 仅当isCheckNode:true有效
	isCheckModel:true,		//是否带有CheckBox样式
	isSingleSelect:false,	//列表是否单选 isCheckModel:true 有效
    callbackName:'',		//回调函数名称
    activeTab:0,			//默认激活的tap		
    columnSort:0,			//调用控件的栏目标识 0-通知公告 1-内部邮件
    //默认设置
    modal: true,
    resizable: false,
    constrain: true,
    layout: 'fit',
    buttonAlign:'center',
    title:'选择用户',
    /**
     * 初始化
     * Init
     */
    initComponent : function() {
        Wgy.UserWindows.superclass.initComponent.call(this);
        var win = this;
        var dep_width = win.detWidth;
        var page_size = win.stdPageSize;
        var record_start = win.stdRecordStart;
		var select_type = win.selectType;
		var select_dept_id = win.selectDeptId;
		var callback_name = win.callbackName;
		var select_sort = win.selectSort;
		var is_check_node = win.isCheckNode;
		var node_check_model = win.nodeCheckModel;
		var is_check_model = win.isCheckModel;
		var is_single_select = win.isSingleSelect;
		var active_tab = win.activeTab;
		var column_sort = win.columnSort;
		var search_tree_value = '';
		var search_tree_type = 0;
		var search_tree_sort = 1;	//1-学院,学工处 2-学生
		var tab1_is_disabled = false;
		var tab2_is_disabled = false;
		var tab3_is_disabled = false;
		var wgy_user_windows_data = null;
		var save_type = 0;			//1-学院 2-专业 3-年级 4-班号 5-人员ID
		var student_id_array = new Array();
		var user_id_array = new Array();
		var tap1_title = '选择操作员';		//tap1标题
		var tap2_title = '按班级选择学生';	//tap2标题
		var tap3_title = '选择学生';		//tap3标题
		
		if(select_sort==2 || select_sort==4){
			tab1_is_disabled = true;
			tap1_title = '-';
			active_tab = 1;
		}
		if(column_sort==1){
			tab2_is_disabled = true;
			tap2_title = '-';
			tab3_is_disabled = true;
			tap3_title = '-';
		}
        var student_grid_store = new Ext.data.JsonStore({
            url: "student/student!searchStudentList",
            root: "datas",
            totalProperty: "total",
            idProperty: "id",
            fields: ['id','sno','name','deptId','major','grade','clno','degree','eduYear','attendDate','idCard','sex','nationg','political','birthDate','origin','familyPhone','familyRel',
                	 'rideSchool','rideFamily','familyPost','familyAddress','fullName','examNo','checkup','schStatus','dorm','roomNo','homePlace','gradYear','phone',
                	 'email','tel','homepage','qq','blog','skill','highSch','photo','isHard','isGreen','counsellor','arts','usedName','faith','trace','isLoan','tutor',
                	 'cardno','flag','remark','deptName','majorName','degreeName','eduyearName','nationgName','politicalName','schstatusName','duty','attendDateDesc',
                	 'birthDateDesc','sexName','checkupName','ishardName','isgreenName','isloanName','familyName','familyUnit','familyTel','dormName','roomNoName'],
            baseParams: {
                limit: page_size
            }
        });
        student_grid_store.on('beforeload', function(store,options) {
        	if(is_check_model && !is_single_select){
        		var student_records = student_grid.getSelections();
        		if(student_records.length>0){
        			store.each(function(record){
        				var isCheck = false;
        				for(var i=0;i<student_records.length;i++){
        					if(record.data.id==student_records[i].data.id){
        						isCheck = true;
        					}
        				}
        				if(isCheck){
        					if(student_id_array.indexOf(record.data.id)==-1){
        						student_id_array.push(record.data.id);	
        					}
        				}else{
        					if(student_id_array.indexOf(record.data.id)>-1){
        						student_id_array = student_id_array.remove(record.data.id);
        					}
        				}
        			},this);
        		}else{
	        		store.each(function(record){
	        			student_id_array = student_id_array.remove(record.data.id);
	        		},this); 
        		}
        	}
	        Ext.apply(this.baseParams, {
	        	selectType: select_type,
	        	deptId: select_dept_id,
	            searchTreeType: search_tree_type,
	            searchTreeValue: search_tree_value
	        });
	    });
	    student_grid_store.on('load', function(store, records,options) {
	    	var check_records = new Array();
	    	for(var i=0;i<records.length;i++){
	    		for(var j=0;j<student_id_array.length;j++){
	    			if(records[i].data.id==student_id_array[j]){
	    				check_records.push(records[i]);break;
	    			}
	    		}
	    	}
	    	student_grid.getSelectionModel().selectRecords(check_records);
	    });
	    var user_grid_store = new Ext.data.JsonStore({
            url: "admin/user!searchUserList",
            root: "datas",
            totalProperty: "total",
            idProperty: "id",
            fields: ['id','studentId','name','deptId','deptName','sort','num','flag'],
            baseParams: {
                limit: page_size
            }
        });
        user_grid_store.on('beforeload', function(store,options) {
        	if(is_check_model && !is_single_select){
        		var user_records = user_grid.getSelections();
        		if(user_records.length>0){
        			store.each(function(record){
        				var isCheck = false;
        				for(var i=0;i<user_records.length;i++){
        					if(record.data.id==user_records[i].data.id){
        						isCheck = true;
        					}
        				}
        				if(isCheck){
        					if(user_id_array.indexOf(record.data.id)==-1){
        						user_id_array.push(record.data.id);	
        					}
        				}else{
        					if(user_id_array.indexOf(record.data.id)>-1){
        						user_id_array = user_id_array.remove(record.data.id);
        					}
        				}
        			},this);
        		}else{
	        		store.each(function(record){
	        			user_id_array = user_id_array.remove(record.data.id);
	        		},this); 
        		}
        	}
	        Ext.apply(this.baseParams, {
	            searchTreeType: search_tree_type,
	            searchTreeValue: search_tree_value
	        });
	    });
	    user_grid_store.on('load', function(store, records,options) {
	    	var check_records = new Array();
	    	for(var i=0;i<records.length;i++){
	    		for(var j=0;j<user_id_array.length;j++){
	    			if(records[i].data.id==user_id_array[j]){
	    				check_records.push(records[i]);break;
	    			}
	    		}
	    	}
	    	user_grid.getSelectionModel().selectRecords(check_records);
	    });
        var  dept_xy_root = new Ext.tree.AsyncTreeNode({
	        id:'0@0',	//id@type	type:1-学院 2-专业 3-年级 4-班级
	        text:'根目录'
	    });
	    var  dept_qt_root = new Ext.tree.AsyncTreeNode({
	        id:'0@0',	//id@type	type:1-角色
	        text:'根目录'
	    });
	    var dept_xy = null;
	    var dept_qt = null;
	    if(is_check_node){
	    	dept_xy = new Ext.tree.TreePanel({
		    	split: true,
		    	autoScroll:true,
		    	animate:true,
		       	checkModel: node_check_model,   
	    		onlyLeafCheckable: false,	//对树所有结点都可选
	        	loader: new Ext.tree.TreeLoader({
		        	clearOnLoad:true,
					dataUrl: 'student/student!searchStudentTree?selectType='+select_type+'&deptId='+select_dept_id,
					listeners: {
			            beforeload: function(treeLoader,node) {
		        			var node_id = node.attributes.id.split('@');
		        			treeLoader.dataUrl = 'student/student!searchStudentTree?selectType=' + select_type +'&searchTreeType='+node_id[1]+'&searchTreeValue='+node_id[0]+'&deptId='+select_dept_id;
			            }
			        },
					baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI } //添加 uiProvider 属性
		        }),
		        root: dept_xy_root,
		        rootVisible:false,
		        border: false
		    });
		    dept_qt = new Ext.tree.TreePanel({
		    	split: true,
		    	autoScroll: true,
		    	animate: true,
		    	checkModel: node_check_model,   
	    		onlyLeafCheckable: false,	//对树所有结点都可选
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'admin/user!searchUserTree',
		        	baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI } //添加 uiProvider 属性
		        }),
		        root:dept_qt_root,
		        rootVisible:false,
		        border: false
		    });
	    }else{
	    	dept_xy = new Ext.tree.TreePanel({
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
		        root:dept_xy_root,
		        rootVisible:false,
		        border: false
		    });
		    dept_qt = new Ext.tree.TreePanel({
		    	split: true,
		    	autoScroll: true,
		    	animate: true,
		        loader: new Ext.tree.TreeLoader({
		        	dataUrl: 'admin/user!searchUserTree'
		        }),
		        root:dept_qt_root,
		        rootVisible:false,
		        border: false
		    });
	    }
	    dept_xy.on('click',function(node){
	        node.expand();
	        node.select();
	        var node_id = node.attributes.id.split('@');
	        search_tree_value = node_id[0];
			search_tree_type = node_id[1];
			student_grid_store.reload();
	    });
	    dept_qt.on('click',function(node){
	        node.expand();
	        node.select();
	        var node_id = node.attributes.id.split('@');
	        search_tree_value = node_id[0];
			search_tree_type = node_id[1];
			user_grid_store.reload();
	    });
		var dept_xy_panel = new Ext.Panel({
            title: '学院-专业-年级-班级',
            region: 'west',
            split: true,
            width: dep_width,
            collapsible: true,
            margins:'3 0 3 3',
            cmargins:'3 3 3 3',
            layout: 'fit',
            items: dept_xy
        });
        var dept_qt_panel = new Ext.Panel({
            title: '角色组',
            region: 'west',
            split: true,
            width: dep_width,
            collapsible: true,
            margins:'3 0 3 3',
            cmargins:'3 3 3 3',
            layout: 'fit',
            items: dept_qt
        });
		var student_colmodel = null;
		var user_colmodel = null;
		if(is_check_model){
			student_colmodel = new Ext.grid.ColumnModel([
				new Ext.grid.CheckboxSelectionModel ({ singleSelect : is_single_select }),
                { header: '学号', width: 100, dataIndex: 'sno', sortable: true },
                { header: '姓名', width: 100, dataIndex: 'name', sortable: true },
                { header: '学院', width: 100, dataIndex: 'deptName', sortable: true },
                { header: '专业', width: 100, dataIndex: 'majorName', sortable: true },
                { header: '年级', width: 100, dataIndex: 'grade', sortable: true },
                { header: '班号', width: 100, dataIndex: 'clno', sortable: true }
			]);
			user_colmodel = new Ext.grid.ColumnModel([
				new Ext.grid.CheckboxSelectionModel ({ singleSelect : is_single_select }),
                { header: '学院', width: 100, dataIndex: 'deptName', sortable: true },
                { header: '姓名', width: 100, dataIndex: 'name', sortable: true }
			]);
		}else{
			student_colmodel = new Ext.grid.ColumnModel([
                { header: '学号', width: 100, dataIndex: 'sno', sortable: true },
                { header: '姓名', width: 100, dataIndex: 'name', sortable: true },
                { header: '学院', width: 100, dataIndex: 'deptName', sortable: true },
                { header: '专业', width: 100, dataIndex: 'majorName', sortable: true },
                { header: '年级', width: 100, dataIndex: 'grade', sortable: true },
                { header: '班号', width: 100, dataIndex: 'clno', sortable: true }
			]);
			user_colmodel = new Ext.grid.ColumnModel([
                { header: '学院', width: 100, dataIndex: 'deptName', sortable: true },
                { header: '姓名', width: 100, dataIndex: 'name', sortable: true }
			]);
		}
        var student_grid = new Ext.grid.GridPanel({
            layout: 'fit',
            region: 'center',
            margins:'3 3 3 0',
            viewConfig: { forceFit: true },
            loadMask: true,
            store: student_grid_store,
            colModel:student_colmodel,
            sm : new Ext.grid.CheckboxSelectionModel ({singleSelect : is_single_select}),
            bbar: new Ext.PagingToolbar({
                pageSize: page_size,
                store: student_grid_store,
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
            monitorResize: true
        });
        var user_grid = new Ext.grid.GridPanel({
            layout: 'fit',
            region: 'center',
            margins:'3 3 3 0',
            viewConfig: { forceFit: true },
            loadMask: true,
            store: user_grid_store,
           	colModel:user_colmodel,
            sm : new Ext.grid.CheckboxSelectionModel ({singleSelect : is_single_select}),
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
            monitorResize: true
        });
        var  dept_bj_root = new Ext.tree.AsyncTreeNode({
	        id:'0@0',	//id@type	type:1-学院 2-专业 3-年级 4-班级
	        text:'根目录'
	    });
	    var dept_bj = new Ext.tree.TreePanel({
	    	region: 'center',
	    	split: true,
	    	autoScroll:true,
	    	animate:true,
	       	checkModel: 'cascade',   
    		onlyLeafCheckable: false,	//对树所有结点都可选
        	loader: new Ext.tree.TreeLoader({
	        	clearOnLoad:true,
				dataUrl: 'student/student!searchStudentTree?selectType='+select_type+'&deptId='+select_dept_id,
				listeners: {
		            beforeload: function(treeLoader,node) {
	        			var node_id = node.attributes.id.split('@');
	        			treeLoader.dataUrl = 'student/student!searchStudentTree?selectType=' + select_type +'&searchTreeType='+node_id[1]+'&searchTreeValue='+node_id[0]+'&deptId='+select_dept_id;
		            }
		        },
				baseAttrs: { uiProvider: Ext.ux.TreeCheckNodeUI } //添加 uiProvider 属性
	        }),
	        root: dept_bj_root,
	        rootVisible:false,
	        border: false
	    });
        var panel = new Ext.TabPanel({
        	split: true,
        	activeTab: active_tab,
			defaults:{autoScroll: true},
			resizeTabs: true,
			tabMargin: 1,
        	border: false,
        	monitorResize: true,
        	tabWidth : win.width/3,
        	items:[{
        		id: 'search-tree-sort-panel-qt',
        		title: '<center>'+tap1_title+'</center>',
        		layout: 'border',
            	border: false,
            	disabled:tab1_is_disabled,
            	items: [dept_qt_panel,user_grid]
        	},{
        		id: 'search-tree-sort-panel-bj',
        		title: '<center>'+tap2_title+'</center>',
        		layout: 'border',
	            border: false,
	            disabled:tab2_is_disabled,
	            items: [dept_bj]
        	},{
        		id: 'search-tree-sort-panel-xy',
        		title: '<center>'+tap3_title+'</center>',
        		layout: 'border',
	            border: false,
	            disabled:tab3_is_disabled,
	            items: [dept_xy_panel,student_grid]
        	}],
        	listeners: {
        		beforetabchange: function(tabPanel,newTab,currentTab){
        			if(newTab.getId()=='search-tree-sort-panel-qt'){
        				if(is_check_model){
        					if(!is_single_select){
        						if(user_grid.getStore()!=null && user_grid.getSelections().length>0){
        							user_grid.getSelectionModel().clearSelections();
        						}
        					}
        				}
					}
        			if(newTab.getId()=='search-tree-sort-panel-xy'){
        				if(is_check_model){
        					if(!is_single_select){
        						if(student_grid.getStore()!=null && student_grid.getSelections().length>0){
	        						student_grid.getSelectionModel().clearSelections();
        						}
        					}
        				}
					}
					if(newTab.getId()=='search-tree-sort-panel-bj'){
						var nodes = dept_bj.getChecked();
	    				Ext.each(nodes, function(node){
	    					node.getUI().checkbox.checked = false;
	                    	node.attributes.checked = false;
		                });
					}
        			//1-学院,学工处 2-学生
        			
        		}, 
        		tabchange: function(tabpanel,tab){
        			//1-学院,学工处 2-学生
        			if(tab.getId()=='search-tree-sort-panel-qt'){
						search_tree_sort = 1;
					}
        			if(tab.getId()=='search-tree-sort-panel-xy'){
						search_tree_sort = 2;
					}
					if(tab.getId()=='search-tree-sort-panel-bj'){
						search_tree_sort = 2;
					}
        		}
        	}
    	});
        win.add(panel);
        win.addButton(new Ext.Button({
        	text: '确定',
        	handler:function(){
        		save_type = 0;//1-班号 2-人员 3-用户
        		wgy_user_windows_data = '{value:"';
        		if(panel.getActiveTab().getId()=='search-tree-sort-panel-qt'){
        			save_type = 3;
        			if(is_check_model){
        				if(is_single_select){
        					var user_rec = user_grid.getSelectionModel().getSelected();
	        				if(user_rec){
	        					wgy_user_windows_data = user_rec.data.id;
	        				}else{
	        					Ext.MessageBox.alert('警告', '请先选中要操作的用户!');
	        					return false;
	        				}
        				}else{
        					var user_rec = user_grid.getSelections();
			        		if(user_rec.length>0){
			        			user_grid.getStore().each(function(record){
			        				var isCheck = false;
			        				for(var i=0;i<user_rec.length;i++){
			        					if(record.data.id==user_rec[i].data.id){
			        						isCheck = true;
			        					}
			        				}
			        				if(isCheck){
			        					if(user_id_array.indexOf(record.data.id)==-1){
			        						user_id_array.push(record.data.id);	
			        					}
			        				}else{
			        					if(user_id_array.indexOf(record.data.id)>-1){
			        						user_id_array = user_id_array.remove(record.data.id);
			        					}
			        				}
			        			},this);
			        		}else{
				        		user_grid.getStore().each(function(record){
				        			user_id_array = user_id_array.remove(record.data.id);
				        		},this); 
			        		}
	        				if(user_id_array.length>0){
	        					for(var i=0;i<user_id_array.length;i++){
        							if(i>0){
			                        	wgy_user_windows_data += '-';
			                    	}
			                    	wgy_user_windows_data += user_id_array[i];
        						}
	        				}else{
	        					Ext.MessageBox.alert('警告', '请先选中要操作的用户!');
	        					return false;
	        				}
        				}
        			}else{
        				var user_rec = user_grid.getSelectionModel().getSelected();
        				if(user_rec){
        					wgy_user_windows_data = user_rec.data.id;
        				}else{
        					Ext.MessageBox.alert('警告', '请先选中要操作的用户!');
        					return false;
        				}
        			}
        		}
        		if(panel.getActiveTab().getId()=='search-tree-sort-panel-xy'){
        			save_type = 2;
        			if(is_check_model){
        				if(is_single_select){
        					var student_rec = student_grid.getSelectionModel().getSelected();
		    				if(user_rec){
		    					wgy_user_windows_data = student_rec.data.id;
		    				}else{
		    					Ext.MessageBox.alert('警告', '请先选中要操作的学生!');
		    					return false;
		    				}
        				}else{
        					var student_rec = student_grid.getSelections();
			        		if(student_rec.length>0){
			        			student_grid.getStore().each(function(record){
			        				var isCheck = false;
			        				for(var i=0;i<student_rec.length;i++){
			        					if(record.data.id==student_rec[i].data.id){
			        						isCheck = true;
			        					}
			        				}
			        				if(isCheck){
			        					if(student_id_array.indexOf(record.data.id)==-1){
			        						student_id_array.push(record.data.id);	
			        					}
			        				}else{
			        					if(student_id_array.indexOf(record.data.id)>-1){
			        						student_id_array = student_id_array.remove(record.data.id);
			        					}
			        				}
			        			},this);
			        		}else{
				        		student_grid.getStore().each(function(record){
				        			student_id_array = student_id_array.remove(record.data.id);
				        		},this); 
			        		}
        					if(student_id_array.length>0){
        						for(var i=0;i<student_id_array.length;i++){
        							if(i>0){
			                        	wgy_user_windows_data += '-';
			                    	}
			                    	wgy_user_windows_data += student_id_array[i];
        						}
        					}else{
        						Ext.MessageBox.alert('警告', '请先选中要操作的学生!');
	    						return false;
        					}
        				}
        			}else{
	        			var student_rec = student_grid.getSelectionModel().getSelected();
	    				if(user_rec){
	    					wgy_user_windows_data = student_rec.data.id;
	    				}else{
	    					Ext.MessageBox.alert('警告', '请先选中要操作的学生!');
	    					return false;
	    				}
        			}
        		}
        		if(panel.getActiveTab().getId()=='search-tree-sort-panel-bj'){
        			save_type = 1;
        			var i = 0;
    				var nodes = dept_bj.getChecked();
    				Ext.each(nodes, function(node){
    					var nodeids = node.attributes.id.split('@');
    					if(nodeids[1]==4){
	                    	if(i>0){
	                        	wgy_user_windows_data += '-';
	                    	}
	                    	wgy_user_windows_data += nodeids[0];
	                    	i++;
    					}
	                });
    				if(i<=0){
    					Ext.MessageBox.alert('警告', '请先选中要操作的班级!');
    					return false;
    				}
        		}
        		wgy_user_windows_data += '",type:'+save_type+',sort:'+search_tree_sort+'}';
        		var fun = callback_name+'('+wgy_user_windows_data+')';
        		eval(fun);
        	},
			scope: this
        }));
    },

    /**
     * ------------------
     * 事件监听器 
     * Listener
     * ------------------
     */
    listeners : {
        'render':{
            fn:function(){
            }
        }
    }
});

/**
 * --------------------------------- 
 * 将UserWindows注册为Ext的组件,以便使用
 * Ext的延迟渲染机制，xtype:'UserWindows'
 * ---------------------------------
 */
Ext.reg('userwindows', Wgy.UserWindows);


