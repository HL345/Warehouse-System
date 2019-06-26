 ## 使用d2-admin模板的Vue前端  
 <a href="https://github.com/d2-projects/d2-admin" target="_blank"><img src="https://raw.githubusercontent.com/FairyEver/d2-admin/master/doc/image/d2-admin@2x.png" width="200"></a>  
技术栈：Vue + Vue Router + Vuex + Axios + Mock  
## 运行这个项目：  
1. 安装Node.js(请直接面向百度编程)  
2. 配置npm国内源 
```
npm config set registry https://registry.npm.taobao.org
```
3. 安装webpack  
```
npm install webpack -g
```
4. 安装vue-cli  
```
npm install vue-cli -g
```
5. 进入项目(命令行)
```
cd 项目目录/vue-d2-admin
注意是进入vue-d2-admin目录，这个是前端目录
```
6. 安装依赖
```
npm install
```
7. 开发者模式运行
```
npm run dev
```
若没和后端联调，你需要在mock/index.js中取消下面的注释以登陆
```
// d2Mock.load(option)
```
## 开发这个项目： 

所有页面放置在src/view/中，system文件夹为系统文件不需更改，你可以尝试修改demo/page1/index.vue里的内容，这是项目中 页面/page1 的内容  
  
如果你是Vue开发者，可在在router/routes.js中自由的增加页面，在store中增加全局变量  
  
如果你还未掌握Vue，你可以直接修改.vue文件中的内容，templete标签是Html内容(你必须用<d2-container>标签包裹所有内容)，script标签是JS内容，style标签是CSS内容。得力于Vue的特性，你的所有更改都只对当前页面影响，不必担心你的JS/CSS会影响其他页面。