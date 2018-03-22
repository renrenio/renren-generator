**项目说明** 
- renren-generator是人人开源项目的代码生成器，可在线生成entity、xml、dao、service、html、js、sql代码，减少70%以上的开发任务
<br> 


**如何交流、反馈、参与贡献？** 
- Git仓库：https://gitee.com/renrenio/renren-generator
- [人人开源](http://www.renren.io)：http://www.renren.io   
- [官方社区](http://www.renren.io/?s=index/Community)：http://www.renren.io/?s=index/Community   
- 官方QQ群：324780204、145799952
- 如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持
<br> 


 **本地部署**
- 通过git下载源码
- 修改application.yml，更新MySQL账号和密码、数据库名称
- Eclipse、IDEA运行RenrenApplication.java，则可启动项目
- 项目访问路径：http://localhost

**演示效果图：**
![输入图片说明](http://cdn.renren.io/img/82b99a1f0f884454ac3fff5e7f658ac8 "在这里输入图片标题")


**renren-fast-vue**
- 会生成elementui目录，把elementui目录下的src目录，直接覆盖原工程
- 修改原工程下的src/api/index.js，如：

```javascript
import * as common from './modules/common'
import * as user from './modules/user'
import * as role from './modules/role'
import * as menu from './modules/menu'
import * as log from './modules/log'
import * as config from './modules/config'
import * as oss from './modules/oss'
import * as goods from './modules/goods'
import * as schedule from './modules/schedule'

export default {
  common,     // 公共
  user,       // 管理员管理
  role,       // 角色管理
  menu,       // 菜单管理
  log,        // 系统日志
  config,     // 参数管理
  oss,        // 文件服务
  goods,        // 商品管理
  schedule    // 定时任务
}
```

- 修改原工程下的src/router/index.js，如：

```javascript
children: [
    // 以'/n'开头统一拦截, 标记为左侧菜单导航tab展示内容方式路由
    { path: '/n/user', component: _import('user/index'), name: 'user', desc: '管理员管理' },
    { path: '/n/role', component: _import('role/index'), name: 'role', desc: '角色管理' },
    { path: '/n/menu', component: _import('menu/index'), name: 'menu', desc: '菜单管理' },
    { path: '/n/sql', component: _import('sql/index'), name: 'sql', desc: 'SQL监控' },
    { path: '/n/schedule', component: _import('schedule/index'), name: 'schedule', desc: '定时任务' },
    { path: '/n/config', component: _import('config/index'), name: 'config', desc: '参数管理' },
    { path: '/n/oss', component: _import('oss/index'), name: 'oss', desc: '文件上传' },
    { path: '/n/goods', component: _import('goods/index'), name: 'goods', desc: '商品管理' },
    { path: '/n/log', component: _import('log/index'), name: 'log', desc: '系统日志' }
]
```
