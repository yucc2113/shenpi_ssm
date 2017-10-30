/**
 * Wgy.StudentWindows
 * @extend Ext.Window
 * @xtype 'studentwindows'
 * 
 * @author wgy
 */
Ext.namespace('Wgy');
var wgy_student_windows_data = null;
Wgy.StudentWindows = Ext.extend(Ext.Window, {
	//自定义参数设置
	detWidth : 200,
    stdPageSize:10,
    stdRecordStart:0,
    selectType:false,		//是否选择本部门
    selectDeptId:-1,		//查询固定部门学生
    callbackName:'',		//回调函数名称
    isOver:false,			//是否查询已经毕业的学生
    selectRoom:false,       //公寓管理里使用
    selectRoomId:-1,		//部门id
    //默认设置
    modal: true,
    resizable: false,
    constrain: true,
    layout: 'fit',
    buttonAlign:'center',
    title:'选择学生',
    /**
     * 初始化
     * Init
     */
    initComponent : function() {
        Wgy.StudentWindows.superclass.initComponent.call(this);
        var win = this;
        var dep_width = win.detWidth;
        var page_size = win.stdPageSize;
        var record_start = win.stdRecordStart;
		var select_type = win.selectType;
		var select_dept_id = win.selectDeptId;
		var callback_name = win.callbackName;
		var selectRoomIds = win.selectRoomId;
		var dept_id = -2;
		var is_over = win.isOver;
		var search_tree_value = '';
		var search_tree_type = 0;
		var selectRooms = win.selectRoom;
        var user_grid_store = new Ext.data.JsonStore({
            //autoLoad: true,
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
        user_grid_store.on('beforeload', function() {
	        Ext.apply(this.baseParams, {
	        	isOver: is_over,
	        	selectType: select_type,
	        	deptId: select_dept_id,
	            searchTreeType: search_tree_type,
	            searchTreeValue: search_tree_value
	        });
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
	        	dataUrl: 'student/student!searchStudentTree?selectType='+select_type+'&deptId='+select_dept_id+'&houseId='+selectRoomIds+'&selectRoom='+selectRooms,
	        	listeners: {
		            beforeload: function(treeLoader,node) {
		            	var node_id = node.attributes.id.split('@');
	        			treeLoader.dataUrl = 'student/student!searchStudentTree?selectType=' + select_type +'&searchTreeType='+node_id[1]+'&searchTreeValue='+node_id[0]+'&deptId='+select_dept_id+'&houseId='+selectRoomIds+'&selectRoom='+selectRooms;
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
	        search_tree_value = node_id[0];
			search_tree_type = node_id[1];
            user_grid_store.load({params:{start:0,limit:10}});
	    });
		var dept_tree_panel = new Ext.Panel({
            title: '学院-专业-年级-班级',
            region: 'west',
            split: true,
            width: dep_width,
            collapsible: true,
            margins:'3 0 3 3',
            cmargins:'3 3 3 3',
            layout: 'fit',
            items: dept_tree
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
                refreshText: '刷新',
                displayMsg: "当前显示记录从 {0} - {1} 总 {2} 条记录",
                emptyMsg: "没有相关记录!",
                doLoad: function(start) {
                    record_start = start;
                    var o = {}, pn = this.paramNames;
                    o[pn.start] = start;
                    o[pn.limit] = this.pageSize;
                    this.store.load({ params: o });
                },
                
             onClick: function(which){
	         var store = this.store;
	         var d = this.getPageData();
	         switch(which){
	             case 'first':
	                 this.doLoad(0);
	                 break;
	             case 'prev':
	                 this.doLoad(Math.max(1, d.activePage - 1)*10-10);
	                 break;
	             case 'next':
	                 this.doLoad(Math.min(d.pages, d.activePage + 1)*10-10);
	                 break;
	             case 'last':
	                 this.doLoad(d.pages*10-10);
	                 break;
	             case 'refresh':
	               user_grid_store.reload({params:{start:0,limit:10,roomNo:win.selectRoomId}});
	         }
     		}
            }),
            monitorResize: true
        });
        var panel = new Ext.Panel({
            layout: 'border',
            border: false,
            items: [dept_tree_panel,user_grid]
        });
        win.add(panel);
        win.dept_tree_root = dept_tree_root;
        win.addButton(new Ext.Button({
        	text: '确定',
        	handler:function(){
        		var house_rec = user_grid.getSelectionModel().getSelected();
        		if(house_rec){
        			var fun = callback_name+'('+house_rec.data.id+')';
        			eval(fun);
        		}else{
        			Ext.MessageBox.alert('警告', '请先选中要操作的学生记录!');
        		}
        		
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
                this.dept_tree_root.expand();
            }
        }
    }
});

/**
 * --------------------------------- 
 * 将StudentWindows注册为Ext的组件,以便使用
 * Ext的延迟渲染机制，xtype:'StudentWindows'
 * ---------------------------------
 */
Ext.reg('studentwindows', Wgy.StudentWindows);


