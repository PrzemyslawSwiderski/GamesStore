<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Form</title>
    <style>

        body {
            background-color: #dcffd4
        }

        b {
            color: #bd9f00
        }


        input[type=submit] {
            font-size: 120%;
            background: #656565;
            background: -webkit-gradient(linear, 0 0, 0 bottom, from(#656565), to(#444));
            background: -moz-linear-gradient(#656565, #444);
            background: linear-gradient(#656565, #444);
            border: solid 1px #535353;
            border-bottom: solid 3px #414141;
            box-shadow: inset 0 0 0 1px #939393;
            color: #fff;
            text-shadow: 0 1px 0 #2f2f2f;
        }

        input:hover[type=submit] {
            background: #4c4c4c;
            background: -webkit-gradient(linear, 0 0, 0 bottom, from(#4c4c4c), to(#565656));
            background: -moz-linear-gradient(#4c4c4c, #565656);
            background: linear-gradient(#4c4c4c, #565656);
            border: solid 1px #464646;
            border-bottom: solid 3px #414141;
            box-shadow: inset 0 0 0 1px #818181;
        }

        input:active [type=submit] {
            background: #474747;
            background: -webkit-gradient(linear, 0 0, 0 bottom, from(#474747), to(#444));
            background: -moz-linear-gradient(#474747, #444);
            background: linear-gradient(#474747, #444);
            border: solid 1px #2f2f2f;
            box-shadow: inset 0 10px 15px 0 #3e3e3e;
        }

        input[type=text] {
            padding: 5px;
            border: 2px solid #ccc;
            -webkit-border-radius: 5px;
            border-radius: 5px;
        }

        input[type=text]:focus {
            border-color: #333;
        }

        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #00ba0e;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #b4fff3;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 2px double #000;
        }
    </style>
</head>
<body onload='document.loginForm.username.focus();'>

<h1>Custom Login Form</h1>

<div id="login-box">

    <h2>Login with Username and Password</h2>

    <c:if test="${param.error != null}">
        <div class="error">
            Invalid username and password.
        </div>
    </c:if>
    <c:if test="${param.logout != null}">
        <div class="msg">
            You have been logged out.
        </div>
    </c:if>

    <form name='loginForm'
          action="./login" method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' id="username" name='username' value=''></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' id="password" name='password'/></td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="Log in"/>
                </td>
            </tr>
        </table>

        <input type="hidden"
               name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>