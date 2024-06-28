<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<head>

    <title>Sign Up | CRM </title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>

</head>

<body>

<style type="text/css">
    body{
        background: #1487e5 !important;
        font-family: 'Muli', sans-serif;

    }
    h1{
        color: #fff;
        padding-bottom: 2rem;
        font-weight: bold;
    }
    a{
        color: #333;
    }
    a:hover{
        color: #0000FF;
        text-decoration: none;
    }
    .form-control:focus {

        color: #000;
        background-color: #fff;
        border:2px solid #1487e5;
        outline: 0;
        box-shadow: none;

    }

    .btn{
        background: #1487e5;
        border: #1487e5;
    }
    .btn:hover {
        background: #0000FF;
        border: #0000FF;
    }
</style>
<div class="pt-5">
    <h1 class="text-center"> Login for CRM MARKET </h1>

    <div class="container">
        <div class="row">
            <div class="col-md-5 mx-auto">
                <div class="card card-body">

                    <form id="submitForm" action="/login" method="post" data-parsley-validate="" data-parsley-errors-messages-disabled="true" novalidate="" _lpchecked="1"><input type="hidden" name="_csrf" value="7635eb83-1f95-4b32-8788-abec2724a9a4">
                        <div class="form-group required">
                            <lSabel for="username"> Email</lSabel>
                            <input type="text" class="form-control text-lowercase" id="username" required="" name="username" value="">
                        </div>
                        <div class="form-group required">
                            <lSabel for="fullname">FULL NAME</lSabel>
                            <input type="text" class="form-control text-lowercase" id="fullname" required="" name="fullname" value="">
                        </div>
                        <div class="form-group required">
                            <label class="d-flex flex-row align-items-center" for="password">Password
                                <a class="ml-auto border-link small-xl" href="/forget-password">Forget?</a></label>
                            <input type="password" class="form-control" required="" id="password" name="password" value="">
                        </div>
                        <div class="form-group mt-4 mb-4">
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="remember-me" name="remember-me" data-parsley-multiple="remember-me">
                                <label class="custom-control-label" for="remember-me">Remember me?</label>
                            </div>
                        </div>
                        <div class="form-group pt-1">
                            <button class="btn btn-primary btn-block" type="submit">Log In</button>
                        </div>
                    </form>
                    <p class="small-xl pt-3 text-center">
                        <span class="text-muted">If you have already account?</span>
                        <a href="/login">Sign in</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- partial -->

</body>

</html>