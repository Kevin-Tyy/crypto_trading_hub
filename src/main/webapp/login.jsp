<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | TradeFlow</title>

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


<body class="text-white h-screen w-full bg-[#242330]">
<main class="w-full h-full flex flex-col justify-center">
    <form action="login" method="post" class="w-[500px] mx-auto space-y-6">
        <h1 class="text-4xl rubik-glitch-regular text-center">TradeFlow</h1>

        <h1 class="text-2xl text-center font-semibold">Login into your account</h1>

        <div class="space-y-3">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter your email"
                   class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                   required>


        </div>
        <div class="space-y-3">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter password"
                   class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                   required>
            <% if (request.getAttribute("error") != null) { %>
            <p style="color: #fa522a; font-size: 16px"><%= request.getAttribute("error") %></p>
            <% } %>
        </div>

        <input type="submit" value="Login"
               class="bg-[#FFC31F] p-3.5 text-center w-full rounded-lg cursor-pointer !mt-10">
        <p class="text-center">Don't have an account? <a href="register.jsp" class="text-[#FFC31F]">Register</a></p>

    </form>
</main>
</body>

</html>
