// 菜单 侧边栏
export default [
  { path: '/index', title: '首页', icon: 'home' },
  {
    title: '页面',
    icon: 'folder-o',
    children: [
      { path: '/page1', title: '商品数据' },
      { path: '/page2', title: '用户信息' },
      { path: '/page3', title: '页面 3' }
    ]
  }
]
