<%@ page import="com.tradeflow.models.User" %>
<%@ page import="com.tradeflow.impl.UserDaoImpl" %>
<%@ page import="com.tradeflow.dao.UserDao" %>

<%
    String username = (String) session.getAttribute("username");
    UserDao userDao = new UserDaoImpl();
    User user = userDao.getUserByUsername(username);

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }

%>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TradeFlow | Dashboard</title>

    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>

    <!--    Fonts-->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Rubik+Glitch&display=swap"
          rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Rubik+Glitch&display=swap" rel="stylesheet">

    <!--    Css-->
    <style>
        * {
            font-family: "Poppins", sans-serif;
        }

        .rubik-glitch-regular {
            font-family: "Rubik Glitch", system-ui;
            font-weight: 400;
            font-style: normal;
        }
    </style>
</head>
<body class="text-white h-screen w-full bg-[#242330] overflow-hidden">
<main class="flex h-full">
    <div class="w-full h-full max-w-[270px] px-8 py-4">
        <div class="h-full flex flex-col justify-between">
            <div class="container">
                <a href="dashboard.jsp">
                    <h1 class="text-3xl rubik-glitch-regular">TradeFlow</h1>
                </a>
            </div>
            <div class="space-y-10">
                <a href="wallet.jsp">Your wallet</a>
                <p>Transactions</p>
                <p>Account</p>
                <p>Settings</p>
                <p>Help</p>
            </div>
            <a href="./register.jsp" class="py-3 px-10 rounded-lg bg-white text-[#242330]">Logout</a>

        </div>

    </div>

    <section class="w-full h-full px-8 py-4 flex flex-col gap-3">
        <nav class="w-full flex justify-between">
            <h1 class="text-2xl font-semibold">Hello <%=username%>,</h1>
            <div class="flex items-center gap-4">
                <%--            <a href="./login.jsp" class="py-3 px-10 rounded-lg bg-[#FFC31F]">Login</a>--%>
                <div class="bg-gray-300 p-2 rounded-full w-10 h-10 grid place-content-center">
                    <div class="flex text-gray-800">
                        <span><%=user.getFirstName().charAt(0)%></span>
                        <span><%=user.getLastName().charAt(0)%></span>
                    </div>
                </div>
            </div>
        </nav>
        <div class="bg-[#1e1d26] h-full flex-1 rounded-3xl p-10">
            Your wallet
        </div>

    </section>

</main>
<br/>
</body>
</html>