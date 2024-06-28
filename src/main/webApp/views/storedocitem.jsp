<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.DocumentResDTO.*" %>
<%@ page import="com.example.marketplace.entity.DocItems" %>
<%@ include file="header.jsp"%>
<%List<StoreDocItemResDTO> storeDocItemList = (List<StoreDocItemResDTO>) request.getAttribute("storeDocItemList");%>
<%List<StoreProductResDTO> productDTOList = (List<StoreProductResDTO>) request.getAttribute("productList");%>
<%List<StoreDocResDTO> storeDocDTOList = (List<StoreDocResDTO>) request.getAttribute("storeDocList");%>

<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>StoreDocItem Id</th>
                <th>StoreDocItem document</th>
                <th>StoreDocItem product</th>
                <th>Count</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (StoreDocItemResDTO storeDocItemResDTO : storeDocItemList) {%>
            <tr>
                <td><%=storeDocItemResDTO.getId()%></td>
                <td><%=storeDocItemResDTO.getStoreDocResDTO().getDocNumber()%></td>
                <td><%=storeDocItemResDTO.getProductResDTO().getName()%></td>
                <td><%=storeDocItemResDTO.getCount()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=storeDocItemResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=storeDocItemResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=storeDocItemResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>DocItems o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/storedocitem/delete/<%=storeDocItemResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=storeDocItemResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>DocItems o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/storedocitem/<%=storeDocItemResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=storeDocItemResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleDocument" class="form-label"> DocItems documents</label>
                                        <select  name="documentId" id="exampleDocument" class="form-control" required>
                                            <option value="" selected>Store Document tanlang</option>
                                            <% for (StoreDocResDTO storeDocResDTO : storeDocDTOList) {%>
                                            <option value="<%=storeDocResDTO.getId()%>"><%=storeDocResDTO.getDocNumber()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleProduct" class="form-label"> DocItems products</label>
                                        <select  name="productId" id="exampleProduct" class="form-control" required>
                                            <option value="" selected>Product tanlang</option>
                                            <% for (StoreProductResDTO storeProductResDTO  : productDTOList) {%>
                                            <option value="<%=storeProductResDTO.getId()%>"><%=storeProductResDTO.getProductResDTO().getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCount" class="form-label">StoreDocItem Count</label>
                                        <input type="text" value="<%=storeDocItemResDTO.getCount()%>" name="count" class="form-control" id="exampleCount" required>
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
            <form action="/market/storedocitem" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleDocument2" class="form-label">DocItems document</label>
                        <select name="documentId" id="exampleDocument2" class="form-control" required>
                            <option value="" selected>Store Document tanlang</option>
                            <% for (StoreDocResDTO storeDocResDTO : storeDocDTOList) {%>
                            <option value="<%=storeDocResDTO.getId()%>"><%=storeDocResDTO.getDocNumber()%></option>
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
                        <label for="exampleCount2" class="form-label">StoreDocItem count</label>
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