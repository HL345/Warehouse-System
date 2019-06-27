<template>
  <d2-container>
    <div class="all-container">
      <div class="all-container-padding bg" >
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="基本信息" name="first">
            <el-row :gutter="12">
              <el-col :span="8">
                <el-card shadow="hover">
                  <h1>ID</h1>
                  <h2>{{userList.id}}</h2>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover">
                  <h1>邮箱</h1>
                  <h2>{{userList.email}}</h2>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover">
                  <h1>用户名</h1>
                  <h2>{{userList.username}}</h2>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover">
                  <h1>注册时间</h1>
                  <h2>{{userList.date}}</h2>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card shadow="hover">
                  <h1>是否管理员</h1>
                  <h2 v-if="userList.is_admin===1">管理员</h2>
                  <h2 v-else>用户</h2>
                </el-card>
              </el-col>
            </el-row>
          </el-tab-pane>
          <el-tab-pane label="修改信息" name="second">
            <el-form :model="userList">
              <el-form-item label="邮箱" prop="email" :label-width="formLabelWidth">
                <el-col :span="8">  <el-input v-model="userList.email" placeholder="请输入用户名" type="text"></el-input></el-col>
              </el-form-item>
              <el-form-item label="用户名" prop="username" :label-width="formLabelWidth">
                <el-col :span="8"><el-input v-model="userList.username" placeholder="请输入邮箱" type="email"></el-input></el-col>
              </el-form-item>
            </el-form>
            <div class="grid-content bg-purple">
              <el-button type="primary" @click="changePassword">保存</el-button>
            </div>
          </el-tab-pane>
          <el-tab-pane label="修改密码" name="third">
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm">
              <el-form-item label="原密码" prop="pass" :label-width="formLabelWidth">
                <el-col :span="8">  <el-input v-model="ruleForm.pass" placeholder="请输入原密码" type="password"></el-input></el-col>
              </el-form-item>
              <el-form-item label="新密码" prop="newpass" :label-width="formLabelWidth">
                <el-col :span="8"><el-input v-model="ruleForm.newpass" placeholder="请输入新密码" id="newkey" type="password"></el-input></el-col>
              </el-form-item>
              <el-form-item label="重复新密码" prop="checknewpass" :label-width="formLabelWidth">
                <el-col :span="8">  <el-input v-model="ruleForm.checknewpass" placeholder="请再次输入新密码" id='newkey1' type="password"></el-input></el-col>
              </el-form-item>
            </el-form>
            <div class="grid-content bg-purple">
              <el-button type="primary" @click="changePassword">保存</el-button>
            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </d2-container>
</template>
<script>
import cookies from '@/libs/util.cookies'
import { GetUsetInfo } from '@/api/user'

export default {
  data () {
    /** ***检验两次密码是否一致***/
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'))
      } else {
        if (this.ruleForm.checknewpass !== '') {
          this.$refs.ruleForm.validateField('checknewpass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'))
      } else if (value !== this.ruleForm.newpass) {
        callback(new Error('两次输入密码不一致!'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        pass: '',
        newpass: '',
        checknewpass: ''
      }, // 修改密码的表单
      activeName: 'first',
      baseUrl: process.env.BASE_API,
      userList: {
        id: '',
        email: '',
        username: '',
        password: '',
        is_admin: 0,
        date: ''
      }, // 用户信息表单
      formLabelWidth: '150px',
      /** *校验***/
      rules: {
        pass: [
          {
            required: true,
            trigger: 'blur',
            message: '请输入密码'
          }
        ],
        newpass: [
          {
            validator: validatePass,
            trigger: 'blur'
          }
        ],
        checknewpass: [
          {
            validator: validatePass2,
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    // tab切换
    handleClick (tab, event) {
      console.log(tab, event)
    },
    // 修改密码
    changePassword () {
      GetUsetInfo({
        id: cookies.get('uuid')
      }).then(res => {
        this.userList.id = res.id
        this.userList.email = res.email
        this.userList.username = res.username
        this.userList.date = res.date
        this.userList.is_admin = res.is_admin
        this.$message({
          message: '成功获取用户信息',
          type: 'success'
        })
      }).catch(err => {
        console.log(err)
        this.$message({
          message: '获取用户信息失败',
          type: 'warning'
        })
      })
    }
  }
}
</script>

<style scoped>
.el-card {
  margin: 5px 5px 5px 5px;
}
</style>
