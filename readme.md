创建数据库
springclouddemo
用户名：root
密码：123456

启动 nacos
nacos未设置密码，使用默认组

登录
curl --request POST \

--url 'http://localhost:8080/auth/doLogin?username=user_1&password=user_1'


curl --request POST \

--url 'http://localhost:8080/auth/doLogin?username=editor_1&password=editor_1'
查询
curl --request POST \

--url http://localhost:8080/product/list \

--header 'Cookie: satoken=bcbc509d-0522-4944-832f-9fd8fde56a0e'

新增
curl --request POST \
--url http://localhost:8080/product/insert \
--header 'Cookie: satoken=bcbc509d-0522-4944-832f-9fd8fde56a0e' \
--header 'content-type: application/json' \
--data '{
"name" : "xiaomi"
}'

修改
curl --request POST \
--url http://localhost:8080/product/update \
--header 'Cookie: satoken=ba1f3a90-d379-4ba8-9180-5bd5511bdd57' \
--header 'content-type: application/json' \
--data '{
"id": "4",
"name": "meizu"
}'

删除
curl --request POST \
--url http://localhost:8080/product/delete \
--header 'Cookie: satoken=ba1f3a90-d379-4ba8-9180-5bd5511bdd57' \
--header 'content-type: application/json' \
--data '[
"4"
]'

