<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="com.ute.ecwebapp3.beans.Category" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="category" scope="request" type="com.ute.ecwebapp3.beans.Category" />

<t:main>
    <jsp:body>
        <form action=""method="post">
            <div class="card">
                <h4 class="card-header d-flex justify-content-between">
                    <a  class="btn btn-primary  " href="${pageContext.request.contextPath}/Admin/Category/Adds" role="button">+</a>
                     Category
                </h4>
                <div class="card-body " >
                    <div class="form-group ">
                        <label for="txtCatID">#</label>
                        <input type="text" class="form-control" id="txtCatID" readonly name="CatID" value="${category.catID}">
                    </div>
                        <div class="form-group ">
                            <label for="txtCatName">Category</label>
                            <input type="text" class="form-control" id="txtCatName" autofocus name="CatName" value="${category.catName}">
                        </div>
                </div
                <div class="card-footer ">
                        <a  class="btn btn-outline-success  " href="${pageContext.request.contextPath}/Admin/Category/" role="button">
                            <i class="fa fa-backward" aria-hidden="true"></i>
                            List
                        </a>
                    <button class="btn btn-danger  " type="submit" formaction="${pageContext.request.contextPath}/Admin/Category/Delete">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                        Delete
                    </button>

                        <button class="btn btn-primary  " type="submit" formaction="${pageContext.request.contextPath}/Admin/Category/Update">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Save
                        </button>

                </div>
            </div>
        </form>
    </jsp:body>
</t:main>