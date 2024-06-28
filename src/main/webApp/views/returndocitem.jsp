<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.DocumentResDTO.*" %>
<%@ page import="com.example.marketplace.entity.DocItems" %>
<%@ page import="com.example.marketplace.entity.StoreProduct" %>
<%@ include file="header.jsp"%>
<%List<ReturnDocItemResDTO> returnDocItemList = (List<ReturnDocItemResDTO>) request.getAttribute("returnDocItemList");%>
<%List<StoreProductResDTO> productDTOList = (List<StoreProductResDTO>) request.getAttribute("productList");%>
<%List<ReturnDocResDTO> returnDocDTOList = (List<ReturnDocResDTO>) request.getAttribute("returnDocList");%>

<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>ReturnDocItem Id</th>
                <th>ReturnDocItem document</th>
                <th>ReturnDocItem product</th>
                <th>Count</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (ReturnDocItemResDTO returnDocItemResDTO : returnDocItemList) {%>
            <tr>
                <td><%=returnDocItemResDTO.getId()%></td>
                <td><%=returnDocItemResDTO.getReturnDocResDTO().getDocNumber()%></td>
                <td><%=returnDocItemResDTO.getStoreProductResDTO().getId()%></td>
                <td><%=returnDocItemResDTO.getCount()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=returnDocItemResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=returnDocItemResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=returnDocItemResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>RetrunDocItems o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/returndocitem/delete/<%=returnDocItemResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=returnDocItemResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>ReturnDocItems o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/returndocitem/<%=returnDocItemResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=returnDocItemResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleDocument" class="form-label"> DocItems documents</label>
                                        <select  name="documentId" id="exampleDocument" class="form-control" required>
                                            <option value="" selected>Return Document tanlang</option>
                                            <% for (ReturnDocResDTO returnDocResDTO : returnDocDTOList) {%>
                                            <option value="<%=returnDocResDTO.getId()%>"><%=returnDocResDTO.getDocNumber()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleProduct" class="form-label"> DocItems products</label>
                                        <select  name="productId" id="exampleProduct" class="form-control" required>
                                            <option value="" selected>Product tanlang</option>
                                            <% for (StoreProductResDTO storeProductResDTO : productDTOList) {%>
                                            <option value="<%=storeProductResDTO.getId()%>"><%=storeProductResDTO.getProductResDTO().getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCount" class="form-label">StoreDocItem Count</label>
                                        <input type="text" value="<%=returnDocItemResDTO.getCount()%>" name="count" class="form-control" id="exampleCount" required>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Bekor qilish</button>
                                        <button type="submit" class="btn btn-success">Saqlash</button>
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
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi document qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/returndocitem" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleDocument2" class="form-label">DocItems document</label>
                        <select name="documentId" id="exampleDocument2" class="form-control" required>
                            <option value="" selected>Return Document tanlang</option>
                            <% for (ReturnDocResDTO returnDocResDTO : returnDocDTOList) {%>
                            <option value="<%=returnDocResDTO.getId()%>"><%=returnDocResDTO.getDocNumber()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleProduct2" class="form-label">DocItems product</label>
                        <select name="productId" id="exampleProduct2" class="form-control" required>
                            <option value="" selected>Product tanlang</option>
                            <% for (StoreProductResDTO storeProductResDTO : productDTOList) {%>
                            <option value="<%=storeProductResDTO.getId()%>"><%=storeProductResDTO.getProductResDTO().getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCount2" class="form-label">ReturnDocItem count</label>
                        <input type="text" name="count" class="form-control" id="exampleCount2" required>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Bekor qilish</button>
                        <button type="submit" class="btn btn-success">Saqlash</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>