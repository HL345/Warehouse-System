# Warehouse-System
由440和430联合打造的仓库管理系统  
运用Vue前端+Java后端完成  
前端（开发）部分在vue-d2-admin中，后端在Program中  
#### 参与

##### [金文杰](https://github.com/lKingl)

- 前端**主要**参与者
- API制定
- 文档制作者

##### [罗润峰](https://github.com/lrfNetwork)

- 后端**主要**参与者
- JDBC封装

##### 娄方成
- 前端参与者
- PPT制作

##### 吴鸿林
- 前端参与者

##### 杜宇佳
- 后端参与者

##### 沈森林
- 后端参与者
- 数据库建表

##### 陈天琪
- 后端参与者


## 规定：
调试前端占用8080端口，后端占用8090端口  
数据交互大部分由Ajax完成，默认前端发送表格数据，默认后端发送Json格式数据
## API:
前部分为前端发送（后端接收）后部分为前端接收（后端发出）  
### `登陆  /api/login ` 
***
email(String)  
password(String)  
***
uuid(int)  
username(String)  
token(定值String)  
isSuccess(布尔)   
***
### `注册  /api/register ` 
***
username(String)  
email(String)  
password(String)  
***
isSuccess(布尔)
***
### `删除表格数据  /api/table/remove ` 
***
// 多选则传数组(后期再考虑)  
id(int)
***
isSuccess(布尔)
***
### `更新表格数据  /api/table/fetch`
***
this.data = res.list  
// 当前页  
currentPage(int)  
// 一个页面大小  
pageSize(int)  
// 总条目数  
total(int)  
***
// 数据  
data(Json数组)例如：  
```
[
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
    }
]
```
// 总条目数  
total(int)  
isSuccess(布尔)
***
### `新增表格数据  /api/table/add ` 
***
完整的一列数据，例如,数据库有date,name,address，则：  
```
{
    date: '2016-05-02',
    name: '王小虎',
    address: '上海市普陀区金沙江路 1518 弄'
}
```
***
isSuccess(布尔)
***
未完待续...