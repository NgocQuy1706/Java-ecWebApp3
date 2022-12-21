<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<t:main>
    <jsp:attribute name="css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" integrity="sha512-f0tzWhCwVFS3WeYaofoLWkTP62ObhewQ1EZn65oSYDZUg1+CyywGKkWzm8BxaJj5HGKI72PnMH9jYyIFz+GH7g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </jsp:attribute>
    <jsp:attribute name="js" >
        <script
                type="text/javascript"
                src='https://cdn.tiny.cloud/1/xtrzfgr6krqkeoc2gtvlhjnbe8yz04vi1ai0xr1ivn2fhksl/tinymce/6/tinymce.min.js'
                referrerpolicy="origin">
        </script>
        <script>
            tinymce.init({
                selector: '#txtFullDes',
                height: 400,
                plugins: [
                    'advlist', 'autolink', 'link', 'image', 'lists', 'charmap', 'preview', 'anchor', 'pagebreak',
                    'searchreplace', 'wordcount', 'visualblocks', 'visualchars', 'code', 'fullscreen', 'insertdatetime',
                    'media', 'table', 'emoticons', 'template', 'help'
                ],
                toolbar: 'undo redo | styles | bold italic | alignleft aligncenter alignright alignjustify | ' +
                    'bullist numlist outdent indent | link image | print preview media fullscreen | ' +
                    'forecolor backcolor emoticons | help',
                menu: {
                    favs: { title: 'My Favorites', items: 'code visualaid | searchreplace | emoticons' }
                },
                menubar: 'favs file edit view insert format tools table help',
                content_css: 'css/content.css'

            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <form action=""method="post">
            <div class="card">
                <h4 class="card-header">
                    WYSHING HTML Editor
                </h4>
                <div class="card-body " >
                    <div class="form-group ">
                        <label for="txtFullDes">Description</label>
                        <input type="text" class="form-control" id="txtTinyDes" name="TinyDes" autofocus />
                    </div>
                </div>
                <div class="card-body " >
                        <div class="form-group ">
                            <label for="txtFullDes">Full Description</label>
                            <textarea id="txtFullDes" name="FullDes">Hello World</textarea>
                        </div>
                </div>
                <div class="card-footer text-right ">
                        <button class="btn btn-primary  " type="submit">
                            <i class="fa fa-check" aria-hidden="true"></i>
                            Save
                        </button>

                </div>
            </div>
        </form>
    </jsp:body>
</t:main>