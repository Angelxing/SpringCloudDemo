### 已完成部分
- common 公用组件

- auth 登录服务
- gateway 网关,鉴权
- product 服务，CRUD
- web 网页服务
- docker compose 一键部署 


登录
curl --request POST \

--url 'http://127.0.0.1:7573/auth/doLogin?username=user_1&password=user_1'


curl --request POST \

--url 'http://127.0.0.1:7573/auth/doLogin?username=editor_1&password=editor_1'

### github ouath2
curl --request GET \
--url 'https://github.com/login/oauth/authorize?client_id=0a870bbe4d4153b01d43&redirect_uri=http://127.0.0.1:7573/auth/oauth2'

查询
curl --request POST \

--url http://127.0.0.1:7573/product/list \

--header 'Cookie: satoken=bcbc509d-0522-4944-832f-9fd8fde56a0e'

新增
curl --request POST \
--url http://127.0.0.1:7573/product/insert \
--header 'Cookie: satoken=bcbc509d-0522-4944-832f-9fd8fde56a0e' \
--header 'content-type: application/json' \
--data '{
"name" : "xiaomi"
}'

修改
curl --request POST \
--url http://127.0.0.1:7573/product/update \
--header 'Cookie: satoken=ba1f3a90-d379-4ba8-9180-5bd5511bdd57' \
--header 'content-type: application/json' \
--data '{
"id": "4",
"name": "meizu"
}'

删除
curl --request POST \
--url http://127.0.0.1:7573/product/delete \
--header 'Cookie: satoken=ba1f3a90-d379-4ba8-9180-5bd5511bdd57' \
--header 'content-type: application/json' \
--data '[
"4"
]'

