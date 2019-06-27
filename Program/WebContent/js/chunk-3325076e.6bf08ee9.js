(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-3325076e"],{"2fcf":function(e,t,a){"use strict";a.r(t);a("386d"),a("6b54");var i=a("9bd2"),n=a("4328"),o=a.n(n);function s(e){return Object(i.a)({url:"/table/remove",method:"post",data:o.a.stringify(e)})}var l={name:"page1",data:function(){return{columns:[{title:"编号",key:"id",sortable:!0},{title:"商品名",key:"name",sortable:!0},{title:"价格",key:"price",sortable:!0},{title:"类别",key:"type",sortable:!0},{title:"库存",key:"save",sortable:!0},{title:"重量",key:"size",sortable:!0},{title:"生产厂家",key:"manufacture",sortable:!0},{title:"入库日期",key:"date",sortable:!0},{title:"保质期",key:"period",sortable:!0}],data:[],options:{border:!0,stripe:!0,defaultSort:{prop:"date",order:"descending"}},loading:!1,rowHandle:{remove:{icon:"el-icon-delete",size:"small",fixed:"right",confirm:!0},edit:{icon:"el-icon-edit",size:"small",fixed:"right"}},pagination:{currentPage:1,pageSize:5,total:0},addTemplate:{name:{title:"商品名",value:"默认商品"},price:{title:"价格",value:"50"},type:{title:"类别",value:"默认"},save:{title:"库存",value:"199"},size:{title:"重量",value:"50g"},manufacture:{title:"生产厂家",value:"成都大学"},period:{title:"保质期",value:"180"}},editTemplate:{name:{title:"商品名",value:""},price:{title:"价格",value:""},type:{title:"类别",value:""},save:{title:"库存",value:""},size:{title:"重量",value:""},manufacture:{title:"生产厂家",value:""},period:{title:"保质期",value:""}},formOptions:{labelWidth:"80px",labelPosition:"left",saveLoading:!1},select:null,search:""}},methods:{handleSelectionChange:function(e){this.select=e},handleRowRemove:function(e,t){var a=this;e.index;s({ids:e.row.id.toString()}).then(function(e){e.isSuccess?a.$message({message:"删除成功",type:"success"}):a.$message({message:"删除失败",type:"erro"}),a.fetchData()}),t()},removeRowSelected:function(){for(var t=this,e=[],a=0;a<this.select.length;a++)e.push(this.select[a].id);s({ids:e.toString()}).then(function(e){e.isSuccess?(t.$message({message:"删除成功",type:"success"}),t.fetchData()):t.$message({message:"删除失败",type:"erro"})})},paginationCurrentChange:function(e){this.pagination.currentPage=e,this.fetchData()},fetchData:function(){var t=this;this.loading=!0,function(e){return Object(i.a)({url:"/table/fetch",method:"post",data:o.a.stringify(e)})}({currentPage:this.pagination.currentPage,pageSize:this.pagination.pageSize,total:this.pagination.total}).then(function(e){t.data=e.data,t.pagination.total=e.total,t.loading=!1}).catch(function(e){t.loading=!1})},handleDialogOpen:function(e){var t=e.mode;this.$message({message:"打开模态框，模式为："+t,type:"success"})},addRow:function(){this.$refs.d2Crud.showDialog({mode:"add"})},handleRowAdd:function(e,t){var a=this;this.formOptions.saveLoading=!0,setTimeout(function(){(function(e){return Object(i.a)({url:"/table/add",method:"post",data:o.a.stringify(e)})})(e).then(function(e){e.isSuccess?(a.$message({message:"保存成功",type:"success"}),a.fetchData()):a.$message({message:"保存失败",type:"warning"}),a.formOptions.saveLoading=!1}).catch(function(e){a.loading=!1}),t({}),a.formOptions.saveLoading=!1},300)},handleRowEdit:function(e,t){var a=this,n=(e.index,e.row);this.formOptions.saveLoading=!0,setTimeout(function(){(function(e){return Object(i.a)({url:"/table/edit",method:"post",data:o.a.stringify(e)})})(n).then(function(e){e.isSuccess?(a.$message({message:"编辑成功",type:"success"}),a.formOptions.saveLoading=!1,a.fetchData()):(a.$message({message:"编辑失败",type:"warning"}),a.formOptions.saveLoading=!1)}).catch(function(e){a.loading=!1}),t({}),a.formOptions.saveLoading=!1},300)},handleDialogCancel:function(e){this.$message({message:"取消保存",type:"warning"}),e()},doSearch:function(){var t=this;this.loading=!0,function(e){return Object(i.a)({url:"/table/search",method:"post",data:o.a.stringify(e)})}({content:this.search}).then(function(e){t.data=e.data,t.pagination.total=e.total,t.loading=!1,t.pagination.currentPage=1,t.$message({message:"查询到"+t.pagination.total+"条数据",type:"success"}),t.loading=!1}).catch(function(e){t.$message({message:"查询失败",type:"warning"}),t.loading=!1})}},mounted:function(){this.fetchData(),this.$message({message:"获取到"+this.pagination.pageSize+"条数据",type:"success"})}},c=(a("71d9"),a("2877")),r=function(e){e.options.__source="src/views/demo/page1/index.vue"},d=Object(c.a)(l,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("d2-container",[a("template",{slot:"header"},[t._v("查看商品内容")]),a("d2-crud",{ref:"d2Crud",attrs:{columns:t.columns,data:t.data,options:t.options,loading:t.loading,"form-options":t.formOptions,pagination:t.pagination,"selection-row":"",rowHandle:t.rowHandle,"edit-title":"我的修改","edit-template":t.editTemplate,"add-title":"我的新增","add-template":t.addTemplate},on:{"dialog-open":t.handleDialogOpen,"dialog-cancel":t.handleDialogCancel,"pagination-current-change":t.paginationCurrentChange,"selection-change":t.handleSelectionChange,"row-remove":t.handleRowRemove,"row-edit":t.handleRowEdit,"row-add":t.handleRowAdd}},[a("el-button",{staticStyle:{"margin-bottom":"5px"},attrs:{slot:"header"},on:{click:t.addRow},slot:"header"},[t._v("新增")]),a("el-button",{staticStyle:{"margin-bottom":"5px"},attrs:{slot:"header"},on:{click:t.removeRowSelected},slot:"header"},[t._v("删除所选项")]),a("el-input",{staticStyle:{width:"200px","margin-left":"20px"},attrs:{slot:"header",placeholder:"查询内容","suffix-icon":"el-icon-search"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.doSearch(e)}},slot:"header",model:{value:t.search,callback:function(e){t.search=e},expression:"search"}})],1)],2)},[],!1,null,null,null);"function"==typeof r&&r(d);t.default=d.exports},3846:function(e,t,a){a("9e1e")&&"g"!=/./g.flags&&a("86cc").f(RegExp.prototype,"flags",{configurable:!0,get:a("0bfb")})},"6b54":function(e,t,a){"use strict";a("3846");function n(e){a("2aba")(RegExp.prototype,l,e,!0)}var i=a("cb7c"),o=a("0bfb"),s=a("9e1e"),l="toString",c=/./[l];a("79e5")(function(){return"/a/b"!=c.call({source:"a",flags:"b"})})?n(function(){var e=i(this);return"/".concat(e.source,"/","flags"in e?e.flags:!s&&e instanceof RegExp?o.call(e):void 0)}):c.name!=l&&n(function(){return c.call(this)})},"71d9":function(e,t,a){"use strict";var n=a("ad6b");a.n(n).a},ad6b:function(e,t,a){}}]);