<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="com.ute.ecwebapp3.beans.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="products" scope="request" type="com.ute.ecwebapp3.beans.Product" />

<t:main>
    <jsp:body>
        <form action=""method="post">
            <div class="card">
                <h4 class="card-header d-flex justify-content-between">
                    <a  class="btn btn-primary  " href="${pageContext.request.contextPath}/Admin/Product/Adds" role="button">+</a>
                    Product
                </h4>
                <div class="card-body " >
                    <div class="form-group ">
                        <label for="txtCatID">#</label>
                        <input type="text" class="form-control" id="txtCatID" readonly name="CatID" value="${products.proID}">
                    </div>
                        <div class="form-group ">
                            <label for="txtCatName">Product</label>
                            <input type="text" class="form-control" id="txtCatName" autofocus name="CatName" value="${products.proName}">
                        </div>
                </div>
                <div class="card-footer ">
                        <a  class="btn btn-outline-success  " href="${pageContext.request.contextPath}/Admin/Product/" role="button">
                            <i class="fa fa-backward" aria-hidden="true"></i>
                            List
                        </a>
                    <button class="btn btn-danger  " type="submit" formaction="${pageContext.request.contextPath}/Admin/Product/Delete">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                        Delete
                    </button>

                        <button class="btn btn-primary  " type="submit" formaction="${pageContext.request.contextPath}/Admin/Product/Update">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Save
                        </button>

                </div>
            </div>
        </form>
    </jsp:body>
</t:main>