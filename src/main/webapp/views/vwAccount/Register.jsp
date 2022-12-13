<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:main>
    <jsp:attribute name="css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" integrity="sha512-f0tzWhCwVFS3WeYaofoLWkTP62ObhewQ1EZn65oSYDZUg1+CyywGKkWzm8BxaJj5HGKI72PnMH9jYyIFz+GH7g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </jsp:attribute>
    <jsp:attribute name="js" >
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script>
            $('#frmRegister').on('submit',function (e){
                e.preventDefault();

                const username = $('#txtUsername').val();
                if(username.length === 0){
                    alert('Invalid username.');
                    return;
                }
                // else {
                //     const rawpwd = $('#txtPassword').val();
                //     if(rawpwd.length === 0){
                //         alert('Invalid password.');
                //         return;
                //     }
                //     else {
                //         const confirm = $('#txtConfirm').val();
                //         if(confirm.length === 0){
                //             alert('Invalid confirm.');
                //             return;
                //         }
                //         else {
                //             const name = $('#txtName').val();
                //             if(name.length === 0){
                //                 alert('Invalid name.');
                //                 return;
                //             }
                //             else{
                //                 const email = $('#txtEmail').val();
                //                 if(email.length === 0){
                //                     alert('Invalid email.');
                //                     return;
                //                 }
                //                 else{
                //                     const dob = $('#txtDOB').val();
                //                     if(dob.length === 0) {
                //                         alert('Invalid date of birth.');
                //                         return;
                //                     }
                //                 }
                //             }
                //         }
                //     }
                // }

                $.getJSON('${pageContext.request.contextPath}/Account/IsAvailable?user=' +username ,function (data) {
                    if (data === true){
                        $('#frmRegister').off('submit').submit();
                    } else {
                        alert('Username is not available');
                    }
                });
            });


            $('#txtDOB').datetimepicker({
                format: 'd/m/Y',
                timepicker: false,
                mask: true
            });

            $('#txtUsername').select();
        </script>
    </jsp:attribute>
    <jsp:body>
        <form action=""method="post" id="frmRegister">
            <div class="card">
                <h4 class="card-header d-flex justify-content-between">
                    Account Registration
                </h4>
                <div class="card-body " >
                    <h5>Account</h5>
                        <div class="form-group ">
                            <label for="txtUsername">Username</label>
                            <input type="text" class="form-control" id="txtUsername"  name="username">
                        </div>
                        <div class="form-group ">
                            <label for="txtPassword">Password</label>
                            <input type="password" class="form-control" id="txtPassword"  name="rawpwd">
                        </div>
                        <div class="form-group ">
                            <label for="txtConfirm">Confirm</label>
                            <input type="password" class="form-control" id="txtConfirm" name="confirm" >
                        </div>

                    <h5 class="mt-4">Personal Information </h5>
                    <div class="form-group ">
                        <label for="txtName">Name</label>
                        <input type="text" class="form-control" id="txtName" name="name" >
                    </div>
                    <div class="form-group ">
                        <label for="txtEmail">Email</label>
                        <input type="text" class="form-control" id="txtEmail" name="email" >
                    </div>
                    <div class="form-group ">
                        <label for="txtDOB">Date of birth</label>
                        <input type="text" class="form-control" id="txtDOB" name="dob" >
                    </div>
                </div>
                <div class="card-footer ">
                        <button class="btn btn-primary  " type="submit">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Register
                        </button>

                </div>
            </div>
        </form>
    </jsp:body>
</t:main>