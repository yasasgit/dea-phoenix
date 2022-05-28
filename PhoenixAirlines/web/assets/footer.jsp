<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        .social-container {
            margin: 20px 0;
        }
        .social-container a {
            border: 1px solid #DDDDDD;
            border-radius: 50%;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            margin: 0 5px;
            height: 40px;
            width: 40px;
        }
        footer {
            background-color: #222;
            color: #fff;
            font-size: 14px;
            bottom: 0;
            left: 0;
            right: 0;
            text-align: center;
            z-index: 999;
            padding: 25px;
        }
        footer p {
            margin: 10px 0;
        }
        footer i {
            color: #FF416C;
        }
        footer a {
            color: #3c97bf;
            text-decoration: none;
        }
    </style>
    <footer>
        <div class="inner-width">

            <ul class="menu">
                <li><a href="#">Home</a></li>
                <li><a href="#">Flight Info</a></li>
                <li><a href="#">Ticket Reservation</a></li>
                <li><a href="#">Sign Up</a></li>
                <li><a href="#">login</a></li>
            </ul>

            <div class="copyright">
                &copy;2022 || Designed by IT CROWD
            </div>
            <div class="social-container">
                <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
            </div>
        </div>
    </footer>
</html>
