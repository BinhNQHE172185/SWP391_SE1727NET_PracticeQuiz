<%-- 
    Document   : CheckOut
    Created on : Oct 11, 2023, 9:21:46 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />
        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="FrontEnd/assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="FrontEnd/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="FrontEnd/assets/js/html5shiv.min.js"></script>
        <script src="FrontEnd/assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="FrontEnd/assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="FrontEnd/assets/css/color/color-1.css">
        <style>
            .container {
                max-width: 960px;
            }

            .lh-condensed {
                line-height: 1.25;
            }

            .btn-checkout {
                background: #28a745;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 10px 25px;
                font-size: 16px;
                cursor: pointer;
            }

            .btn-checkout:hover {
                background: #218838;
            }

            .btn-back {
                background: #dc3545;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 11px 25px;
                padding-bottom: 12px;
                margin-top: 10px;
                font-size: 16px;
                cursor: pointer;
                text-decoration: none;
            }

            .btn-back:hover {
                background: #c82333;
            }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body id="bg">
        <div class="page-content bg-white">
            <div class="page-banner ovbl-dark" style="background-image:url(FrontEnd/assets/images/banner/banner3.jpg);">
                <div class="container">
                    <div class="page-banner-entry">
                        <h1 class="text-white">Check Out</h1>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row" style="margin-top: 50px;">
                    <div class="col-md-4 order-md-2 mb-4">
                        <h4 class="d-flex justify-content-between align-items-center mb-3">
                            <span class="text-muted">Your payment</span>
                            <span class="badge badge-secondary badge-pill"></span>
                        </h4>
                        <ul class="list-group mb-3 sticky-top" style="margin-top: 49px;">
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 class="my-0">Membership</h6>
                                    <small class="text-muted">Update your account level</small>
                                </div>
                                <span class="text-muted">$20</span>
                            </li>
                            <div class="divider"></div>
                            <li class="list-group-item d-flex justify-content-between">
                                <span>Total (USD)</span>
                                <strong>$20</strong>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-8 order-md-1">
                        <h4 class="mb-3">Payment information</h4>
                        <form class="needs-validation" action="ProcessCheckout" method="post">
                            <div class="mb-3">
                                <label for="fullname">Fullname</label>
                                <div class="input-group">                                    
                                    <input type="text" class="form-control" id="fullname" placeholder="Your Name" value="${account.fullname}" name="fullname" required="">
                                    <div class="invalid-feedback" style="width: 100%;"> Your name is required. </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="email">Email</label>
                                <input type="email" class="form-control" id="email" placeholder="you@example.com" value="${account.email}" name="email" required="">
                                <div class="invalid-feedback"> Please enter a valid email address for transaction updates. </div>
                            </div>                            
                            <hr class="mb-4">
                            <h4 class="mb-3">Payment</h4>
                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="credit" name="paymentMethod" type="radio" class="custom-control-input" checked=""
                                           required="">
                                    <label class="custom-control-label" for="credit">Credit card</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="debit" name="paymentMethod" type="radio" class="custom-control-input"
                                           required="">
                                    <label class="custom-control-label" for="debit">Debit card</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="paypal" name="paymentMethod" type="radio" class="custom-control-input"
                                           required="">
                                    <label class="custom-control-label" for="paypal">PayPal</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-name">Name on card</label>
                                    <input type="text" class="form-control" id="cc-name" name="nameOnCard" placeholder="" required="">
                                    <small class="text-muted">${mess}</small>
                                    <div class="invalid-feedback"> Name on card is required </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="cc-number">Credit card number</label>
                                    <input type="text" class="form-control" id="cc-number" name="creditNumber" placeholder="" required="">
                                    <small class="text-muted">${mess}</small>
                                    <div class="invalid-feedback"> Credit card number is required </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mb-3">
                                    <label for="cc-expiration">Expiration</label>
                                    <input type="date" class="form-control" id="cc-expiration" name="expriration" placeholder="" required="">
                                    <small class="text-muted">${mess}</small>
                                    <div class="invalid-feedback"> Expiration date required </div>
                                </div>
                                <div class="col-md-3 mb-3">
                                    <label for="cc-cvv">CVV</label>
                                    <input type="text" class="form-control" id="cc-cvv" name="cvv" placeholder="" required="">
                                    <small class="text-muted">${mess}</small>
                                    <div class="invalid-feedback"> Security code required </div>
                                </div>
                            </div>
                            <hr class="mb-4">
                            <button class="btn-checkout" type="submit" style="margin-bottom: 100px;">Continue to checkout</button>
                            <a class="btn-back" href="home">Back to home page</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
    <script>
        // Get a reference to the input element.
        var inputElement = document.getElementById("cc-cvv");

        // Add an event listener to the input element.
        inputElement.addEventListener("keydown", function (event) {
            if (event.key === " " && inputElement.selectionStart === 0) {
                // Prevent the default behavior (inserting a space at the beginning).
                event.preventDefault();
            }
        });
    </script>
    <script>
        // Get a reference to the input element.
        var inputElement = document.getElementById("cc-number");

        // Add an event listener to the input element.
        inputElement.addEventListener("keydown", function (event) {
            if (event.key === " " && inputElement.selectionStart === 0) {
                // Prevent the default behavior (inserting a space at the beginning).
                event.preventDefault();
            }
        });
    </script>
    <script>
        // Get a reference to the input element.
        var inputElement = document.getElementById("cc-name");

        // Add an event listener to the input element.
        inputElement.addEventListener("keydown", function (event) {
            if (event.key === " " && inputElement.selectionStart === 0) {
                // Prevent the default behavior (inserting a space at the beginning).
                event.preventDefault();
            }
        });
    </script>
</html>
