<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="assets/css/profile.css" rel="stylesheet">

    </head>
    <body>
        <div class="card bg-secondary shadow">
            <form action="UpdateUserServlet" method="POST">
                <div class="card-header bg-white border-0">
                    <div class="row align-items-center">
                        <div class="col-8">
                            <h3 class="mb-0">My account</h3>
                        </div>
                        <div class="col-4 text-right">
                            <button type="submit" class="btn btn-sm btn-primary">Save Changes</button>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <h6 class="heading-small text-muted mb-4">User information</h6>
                    <div class="pl-lg-4">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group focused">
                                    <label class="form-control-label">First name</label>
                                    <input type="text" id="input-first-name" class="form-control form-control-alternative" >
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group focused">
                                    <label class="form-control-label">Last name</label>
                                    <input type="text" id="input-last-name" class="form-control form-control-alternative" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="form-group">
                                    <label class="form-control-label">Email address</label>
                                    <input type="email" id="input-email" class="form-control form-control-alternative" >
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="form-group focused">
                                    <label class="form-control-label">Username</label>
                                    <input type="text" id="input-username" class="form-control form-control-alternative" >
                                </div>
                            </div>

                        </div>

                    </div>
                    <hr class="my-4">
                    <!-- Address -->
                    <h6 class="heading-small text-muted mb-4">Contact information</h6>
                    <div class="pl-lg-4">
                        <div class="row">

                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label class="form-control-label">Phone</label>
                                    <input type="number" id="input-postal-code" class="form-control form-control-alternative" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group focused">
                                    <label class="form-control-label">Address</label>
                                    <input id="input-address" class="form-control form-control-alternative" type="text">
                                </div>
                            </div>
                        </div>

                    </div>
                    <hr>
                    <h6 class="heading-small text-muted mb-4">PassPort Details</h6>
                    <div class="pl-lg-4">
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group focused">
                                    <label class="form-control-label">City</label>
                                    <input type="text" id="input-city" class="form-control form-control-alternative">
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group focused">
                                    <label class="form-control-label">Country</label>
                                    <input type="text" id="input-country" class="form-control form-control-alternative">
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group focused">
                                    <label class="form-control-label">Passport Number</label>
                                    <input id="text" class="form-control form-control-alternative" type="text">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-4">
                                <div class="form-group focused">
                                    <label class="form-control-label">Nationality</label>
                                    <input type="text" id="input-city" class="form-control form-control-alternative">
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group focused">
                                    <label class="form-control-label">Valid till</label>
                                    <input type="date" id="input-country" class="form-control form-control-alternative">
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="form-group">
                                    <label class="form-control-label">ID Number</label>
                                    <input type="text" id="input-postal-code" class="form-control form-control-alternative" >
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div> 

        <jsp:include page="assets/footer.jsp" />  
    </body>
</html>
