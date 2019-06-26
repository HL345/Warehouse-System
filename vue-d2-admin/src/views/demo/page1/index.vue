<template>
  <d2-container>
    <template slot="header">Page 1 header</template>
    <d2-crud
            :columns="columns"
            :data="data"
            :options="options"
            :loading="loading"

            selection-row
            @selection-change="handleSelectionChange"

            :rowHandle="rowHandle"
            @row-remove="handleRowRemove"

            :pagination="pagination"
            @pagination-current-change="paginationCurrentChange"

            ref="d2Crud"
            add-title="我的新增"
            :add-template="addTemplate"
            :form-options="formOptions"
            @dialog-open="handleDialogOpen"
            @row-add="handleRowAdd"
            @dialog-cancel="handleDialogCancel"
    >
      <el-button slot="header" style="margin-bottom: 5px" @click="addRow">新增</el-button>
    </d2-crud>
  </d2-container>
</template>

<script>
export default {
  name: 'page1',
  data () {
    return {
      columns: [
        {
          title: '日期',
          key: 'date',
          width: '180',
          sortable: true
        },
        {
          title: '姓名',
          key: 'name',
          width: '180',
          sortable: true
        },
        {
          title: '地址',
          key: 'address'
        }
      ],
      data: [
        {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        },
        {
          date: '2016-05-04',
          name: 'A小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        },
        {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        },
        {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }
      ],
      options: {
        // 边框
        border: true,
        // 斑马条纹
        stripe: true,
        // 排序
        // 在 columns 中设置 sortable 属性为 true ，即可实现以该列为基准的排序。
        defaultSort: {
          // prop排序项
          prop: 'date',
          order: 'descending'
        }
      },
      // 加载状态
      loading: false,
      // 删除
      rowHandle: {
        remove: {
          size: 'mini',
          confirm: false
        }
      },
      // 分页
      pagination: {
        // 当前页
        currentPage: 1,
        // 一个页面大小
        pageSize: 5,
        // 总条目数
        total: 15
      },
      addTemplate: {
        date: {
          title: '日期',
          value: '2016-05-05'
        },
        name: {
          title: '姓名',
          value: '王小虎'
        },
        address: {
          title: '地址',
          value: '上海市普陀区金沙江路 1520 弄'
        }
      },
      formOptions: {
        labelWidth: '80px',
        labelPosition: 'left',
        saveLoading: false
      }
    }
  },
  methods: {
    // 多选
    handleSelectionChange (selection) {
      console.log(selection)
    },
    // 删除
    handleRowRemove ({ index, row }, done) {
      // 发送row.id
      this.$message({
        message: '删除成功',
        type: 'success'
      })
      done()
    },

    // 换页面
    paginationCurrentChange (currentPage) {
      this.pagination.currentPage = currentPage
      this.fetchData()
    },
    // 更新数据
    fetchData () {
      this.loading = true
      this.loading = false
      // BusinessTable1List({
      //   ...this.pagination
      // }).then(res => {
      //   this.data = res.list
      //   this.pagination.total = res.page.total
      //   this.loading = false
      // }).catch(err => {
      //   console.log('err', err)
      //   this.loading = false
      // })
    },

    // 新增数据
    handleDialogOpen ({ mode }) {
      this.$message({
        message: '打开模态框，模式为：' + mode,
        type: 'success'
      })
    },
    // 普通的新增
    addRow () {
      this.$refs.d2Crud.showDialog({
        mode: 'add'
      })
    },
    // Axios row给后端
    handleRowAdd (row, done) {
      this.formOptions.saveLoading = true
      setTimeout(() => {
        console.log(row)
        // Axios 内容
        this.$message({
          message: '保存成功',
          type: 'success'
        })

        // done可以传入一个对象来修改提交的某个字段
        done({
          // address: '我是通过done事件传入的数据！'
        })
        this.formOptions.saveLoading = false
      }, 300)
    },
    handleDialogCancel (done) {
      this.$message({
        message: '取消保存',
        type: 'warning'
      })
      done()
    }
  }
}
</script>
