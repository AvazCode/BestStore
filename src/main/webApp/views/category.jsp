
<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.CategoryResDTO" %>
<%@ page import="com.example.marketplace.dto.responseDTO.CategoryWithProductsResDTO" %>
<%@ page import="com.example.marketplace.entity.Product" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO" %>
<%@ include file="header.jsp"%>
<%
    List<CategoryResDTO> categoryDTOList = (List<CategoryResDTO>) request.getAttribute("categoryList");
%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>ADD CATEGORY</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>CATEGORY ID</th>
                <th>CATEGORY NAME</th>
                <th>BUTTONS</th>
            </tr>
            </thead>
            <tbody>
            <% for (CategoryResDTO categoryDTO : categoryDTOList) {%>
            <tr>

                <td><%=categoryDTO.getId()%></td>
                <td><%=categoryDTO.getName()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=categoryDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>UPDATE</button>
                         <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=categoryDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-2"></i>DELETE</button>
                            <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c<%=categoryDTO.getId()%>" class="btn btn-primary"><i class="fa-regular fa-eye mx-sm-2"></i>VIEW  </button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=categoryDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>DELETE CATEGORY</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Are you sure you want to delete?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">CANCEL</button>
                                <a href="<%=request.getContextPath()%>/market/category/delete/<%=categoryDTO.getId()%>" class="btn btn-danger">DELETE</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for view products--%>
                <div class="modal fade bd-example-modal-c<%=categoryDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b> CATEGORY NAME : <%=categoryDTO.getName()%></b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">

                                    <% if (categoryDTO.getProductResDTOList() != null && !categoryDTO.getProductResDTOList().isEmpty()) { %>
                                        <% for (ProductResDTO productDTO : categoryDTO.getProductResDTOList()) {%>
                                <p>
                                    <%=productDTO.getId()%>
                                    <%=productDTO.getName()%>
                                    <%=productDTO.getCategoryResDTO().getName()%>
                                    <%=productDTO.getAmount()%>
                                    <%=productDTO.getMeasurementResDTO().getName()%>
                                </p>
                                <%} }%>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">BACK</button>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=categoryDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>UPDATE CATEGORY</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/category/<%=categoryDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=categoryDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleCategoryName" class="form-label">CATEGORY NAME</label>
                                        <input type="text" name="name" class="form-control" id="exampleCategoryName" value="<%=categoryDTO.getName()%>" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCEL</button>
                                        <button type="submit" class="btn btn-success">SAVE</button>
                                    </div>
                            </form>
                        </div>
                    </div>
                </div>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
<%--Modal for insert--%>
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalCategory2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalCategory2"><b>NEW CATEGORY ADD</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/category" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCategoryName2" class="form-label">CATEGORY NAME</label>
                        <input type="text" name="name" class="form-control" id="exampleCategoryName2" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">CANCEL</button>
                        <button type="submit" class="btn btn-success">SAVE</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>