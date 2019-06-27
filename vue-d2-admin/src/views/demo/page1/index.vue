<template>
  <d2-container>
    <template slot="header">查看商品内容</template>
    <d2-crud
            :columns="columns"
            :data="data"
            :options="options"
            :loading="loading"
            :form-options="formOptions"
            ref="d2Crud"
            @dialog-open="handleDialogOpen"
            @dialog-cancel="handleDialogCancel"

            :pagination="pagination"
            @pagination-current-change="paginationCurrentChange"

            selection-row
            @selection-change="handleSelectionChange"

            :rowHandle="rowHandle"
            @row-remove="handleRowRemove"

            edit-title="我的修改"
            :edit-template="editTemplate"
            @row-edit="handleRowEdit"

            add-title="我的新增"
            :add-template="addTemplate"
            @row-add="handleRowAdd"
    >
      <el-button slot="header" style="margin-bottom: 5px" @click="addRow">新增</el-button>
      <el-button slot="header" style="margin-bottom: 5px" @click="removeRowSelected">删除所选项</el-button>
        <el-input
                slot="header"
                placeholder="查询内容"
                suffix-icon="el-icon-search"
                v-model="search"
                @keyup.enter.native="doSearch"
                style="width: 200px; margin-left: 20px">
        </el-input>
    </d2-crud>
  </d2-container>
</template>

<script>
import { Fetch, Add, Remove, Search, Edit } from '@/api/table'

export default {
  name: 'page1',
  data () {
    return {
      columns: [
        {
          title: '编号',
          key: 'id',
          sortable: true
        },
        {
          title: '商品名',
          key: 'name',
          sortable: true
        },
        {
          title: '价格',
          key: 'price',
          sortable: true
        },
        {
          title: '类别',
          key: 'type',
          sortable: true
        },
        {
          title: '库存',
          key: 'save',
          sortable: true
        },
        {
          title: '重量',
          key: 'size',
          sortable: true
        },
        {
          title: '生成厂家',
          key: 'manufacture',
          width: 120,
          sortable: true
        },
        {
          title: '生产日期',
          key: 'date',
          width: '180',
          sortable: true
        },
        {
          title: '保质期',
          key: 'period',
          sortable: true
        }
      ],
      data: [
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
          confirm: true
        },
        edit: {
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
        total: 0
      },
      addTemplate: {
        name: {
          title: '商品名',
          value: '默认商品'
        },
        price: {
          title: '价格',
          value: '50'
        },
        type: {
          title: '类别',
          value: '默认'
        },
        save: {
          title: '库存',
          value: '199'
        },
        size: {
          title: '重量',
          value: '50g'
        },
        manufacture: {
          title: '生产厂家',
          value: '成都大学'
        },
        period: {
          title: '保质期',
          value: '180'
        }
      },
      editTemplate: {
        name: {
          title: '商品名',
          value: ''
        },
        price: {
          title: '价格',
          value: ''
        },
        type: {
          title: '类别',
          value: ''
        },
        save: {
          title: '库存',
          value: ''
        },
        size: {
          title: '重量',
          value: ''
        },
        manufacture: {
          title: '生产厂家',
          value: ''
        },
        period: {
          title: '保质期',
          value: ''
        }
      },
      formOptions: {
        labelWidth: '80px',
        labelPosition: 'left',
        saveLoading: false
      },
      select: null,
      search: ''
    }
  },
  methods: {
    // 多选
    handleSelectionChange (selection) {
      this.select = selection
    },
    // 删除
    handleRowRemove ({ index, row }, done) {
      // 发送row.id
      Remove({
        ids: row.id.toString()
      }).then(res => {
        console.log(res)
        if (res.isSuccess) {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.fetchData()
        } else {
          this.$message({
            message: '删除失败',
            type: 'erro'
          })
          this.fetchData()
        }
      })
      done()
    },
    // 批量删除
    removeRowSelected () {
      let ids = []
      for (let i = 0; i < this.select.length; i++) {
        ids.push(this.select[i].id)
      }
      console.log(ids)
      Remove({
        ids: ids.toString()
      }).then(res => {
        console.log(res)
        if (res.isSuccess) {
          this.$message({
            message: '删除成功',
            type: 'success'
          })
          this.fetchData()
        } else {
          this.$message({
            message: '删除失败',
            type: 'erro'
          })
          this.fetchData()
        }
      })
    },
    // 换页面
    paginationCurrentChange (currentPage) {
      this.pagination.currentPage = currentPage
      this.fetchData()
    },
    // 更新数据
    fetchData () {
      console.log(this.pagination)
      this.loading = true
      Fetch({
        currentPage: this.pagination.currentPage,
        pageSize: this.pagination.pageSize,
        total: this.pagination.total
      }
      ).then(res => {
        console.log(res)
        this.data = res.data
        this.pagination.total = res.total
        this.loading = false
      }).catch(err => {
        console.log('err', err)
        this.loading = false
      })
    },

    // 提示框
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
    // 新增数据
    handleRowAdd (row, done) {
      // Axios row给后端
      this.formOptions.saveLoading = true
      setTimeout(() => {
        console.log(row)
        // Axios 内容
        Add(
          row
        ).then(res => {
          console.log(res)
          if (res.isSuccess) {
            this.$message({
              message: '保存成功',
              type: 'success'
            })
            this.formOptions.saveLoading = false
          } else {
            this.$message({
              message: '保存失败',
              type: 'warning'
            })
            this.formOptions.saveLoading = false
          }
        }).catch(err => {
          console.log('err', err)
          this.loading = false
        })
        // done可以传入一个对象来修改提交的某个字段
        done({
          // address: '我是通过done事件传入的数据！'
        })
        this.formOptions.saveLoading = false
      }, 300)
    },
    // 编辑数据
    handleRowEdit ({ index, row }, done) {
      this.formOptions.saveLoading = true
      setTimeout(() => {
        console.log(index)
        console.log(row)
        Edit(
          row
        ).then(res => {
          if (res.isSuccess) {
            this.$message({
              message: '编辑成功',
              type: 'success'
            })
            this.formOptions.saveLoading = false
            this.fetchData()
          } else {
            this.$message({
              message: '编辑失败',
              type: 'warning'
            })
            this.formOptions.saveLoading = false
          }
        }).catch(err => {
          console.log('err', err)
          this.loading = false
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
    },
    // 搜索内容
    doSearch () {
      this.loading = true
      Search({
        content: this.search
      }).then(res => {
        this.data = res.data
        this.pagination.total = res.total
        this.loading = false
        this.pagination.currentPage = 1
        this.$message({
          message: '查询到' + this.pagination.total + '条数据',
          type: 'success'
        })
        this.loading = false
      }).catch(err => {
        console.log('err', err)
        this.$message({
          message: '查询失败',
          type: 'warning'
        })
        this.loading = false
      })
    }
  },
  mounted () {
    this.fetchData()
  }
}
</script>
