**项目说明** 
- renren-generator是人人开源项目的代码生成器，可在线生成entity、xml、dao、service、html、js、sql代码，减少70%以上的开发任务
<br> 


**如何交流、反馈、参与贡献？** 
- Git仓库：https://gitee.com/renrenio/renren-generator
- [人人开源](http://www.renren.io)：http://www.renren.io   
- [官方社区](http://www.renren.io/community)：http://www.renren.io/community   
- 官方QQ群：324780204、145799952
- 技术讨论、二次开发等咨询、问题和建议，请移步到官方社区，我会在第一时间进行解答和回复
- 如需关注项目最新动态，请Watch、Star项目，同时也是对项目最好的支持
- 微信扫码并关注【人人开源】，获得项目最新动态及更新提醒<br>
![输入图片说明](http://cdn.renren.io/47c26201804031918312618.jpg "在这里输入图片标题")
<br> 
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
    // 通过isTab属性, 设定是否通过tab标签页展示内容
    { path: '/home', component: _import('home/index'), name: 'home', desc: '首页' },
    { path: '/layout-setting', component: _import('layout/setting'), name: 'setting', desc: '布局设置' },
    { path: '/user', component: _import('user/index'), name: 'user', desc: '管理员管理', meta: { isTab: true } },
    { path: '/role', component: _import('role/index'), name: 'role', desc: '角色管理', meta: { isTab: true } },
    { path: '/menu', component: _import('menu/index'), name: 'menu', desc: '菜单管理', meta: { isTab: true } },
    { path: '/sql', component: _import('sql/index'), name: 'sql', desc: 'SQL监控', meta: { isTab: true } },
    { path: '/schedule', component: _import('schedule/index'), name: 'schedule', desc: '定时任务', meta: { isTab: true } },
    { path: '/config', component: _import('config/index'), name: 'config', desc: '参数管理', meta: { isTab: true } },
    { path: '/oss', component: _import('oss/index'), name: 'oss', desc: '文件上传', meta: { isTab: true } },
    { path: '/goods', component: _import('goods/index'), name: 'goods', desc: '商品管理', meta: { isTab: true } },
    { path: '/log', component: _import('log/index'), name: 'log', desc: '系统日志', meta: { isTab: true } }
]
```
