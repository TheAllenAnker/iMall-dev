<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="<@spring.url '/resources/css/login.css'/>" rel="stylesheet">
</head>
<body>


<!-- 表单 -->
<div class="main">
    <div class="title">
        <span>iMall 管理员登录</span>
    </div>

    <form action="/iMall/admin/login" class="login-form" method="POST">
        <!--输入框-->
        <div class="input-content">
            <!--autoFocus-->
            <div>
                <input type="text" autocomplete="off"
                       placeholder="用户名" name="username" required/>
            </div>


            <div style="margin-top: 10px">
                <input type="password" autocomplete="off"
                       placeholder="密码" name="password" required/>
            </div>


        </div>

        <!--登入按钮-->
        <div style="text-align: center">
            <button class="enter-btn" type="submit" lay-submit="submit" lay-filter="login_hash">登录</button>
        </div>
    </form>

</div>
</body>
<script>
</script>
</html>