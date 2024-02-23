<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | TradeFlow</title>

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
    <form action="register" method="post" class="w-[500px] mx-auto space-y-6">
        <h1 class="text-4xl rubik-glitch-regular text-center">TradeFlow</h1>
        <h1 class="text-2xl text-center font-semibold">Sign up for a free account</h1>

        <div class="flex gap-x-3">
            <div class="space-y-3 w-full">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" placeholder="Enter your first name"
                       class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                       required>
            </div>
            <div class="space-y-3 w-full">
            <label for="lastName">Last Name:</label>
            <input type="text" id="lastName" name="lastName" placeholder="Enter your last names"
                   class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                   required>
        </div>
        </div>

        <div class="space-y-3">
            <label for="dob">Date of birth:</label>
            <input type="date" id="dob" name="dob"
                   class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300">
                        <c:if test="${ageMessage != null}" >
                            <p style="color: red"><c:out value="${ageMessage}"/> </p>
                        </c:if>
        </div>
        <div class="space-y-3">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter your email"
                   class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                   required>
                        <c:if test="${emailErrors != null}">
                            <c:forEach items="${emailErrors}" var="emailError">
                                <p style="color: red"><c:out value="${emailError}" /> </p>
                            </c:forEach>
                        </c:if>
            <div class="space-y-3">
                <label for="phoneNumber">Phone Number:</label>
                <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter your phoneNumber"
                       class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                       required>

            </div>
            <div class="space-y-3">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter password"
                       class="block w-full bg-transparent outline-none p-3 rounded-lg ring-2 ring-white/70 focus:ring-[#FFC31F] transition duration-300"
                       required>
                        <c:if test="${errorMessages != null}">
                            <c:forEach var="error" items="${errorMessages}">
                                <p style="color: red"><c:out value="${error}"/> </p>
                            </c:forEach>
                        </c:if>
            </div>

            <input type="submit" value="Register"
                   class="bg-[#FFC31F] p-3.5 text-center w-full rounded-lg cursor-pointer !mt-10">
            <p class="text-center">Already have an account? <a href="login.jsp" class="text-[#FFC31F]">Login</a></p>

    </form>
</main>
</body>

</html>
