<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.DocumentResDTO.*" %>
<%@ page import="com.example.marketplace.entity.DocItems" %>
<%@ page import="com.example.marketplace.entity.StoreProduct" %>
<%@ include file="header.jsp"%>
<%List<ReturnWarwDocItemResDTO> returnWareDocItemList = (List<ReturnWarwDocItemResDTO>) request.getAttribute("returnWareDocItemList");%>
<%List<StoreProductResDTO> storeProductDTOList = (List<StoreProductResDTO>) request.getAttribute("storeProductList");%>
<%List<ProductResDTO> productDTOList = (List<ProductResDTO>) request.getAttribute("productList");%>
<%List<ReturnWarwDocResDTO> returnWareDocList = (List<ReturnWarwDocResDTO>) request.getAttribute("returnWareDocList");%>

<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Return Warehouse Id</th>
                <th>Return Warehouse document</th>
                <th>Return Warehouse product</th>
                <th>Return Warehouse store product</th>
                <th>Count</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (ReturnWarwDocItemResDTO returnWarwDocItemResDTO : returnWareDocItemList) {%>
            <tr>
                <td><%=returnWarwDocItemResDTO.getId()%></td>
                <td><%=returnWarwDocItemResDTO.getReturnWarwDocResDTO().getDocNumber()%></td>
                <td><%=returnWarwDocItemResDTO.getStoreProductResDTO().getId()%></td>
                <td><%=returnWarwDocItemResDTO.getProductResDTO().getName()%></td>
                <td><%=returnWarwDocItemResDTO.getCount()%></td>


                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=returnWarwDocItemResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=returnWarwDocItemResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=returnWarwDocItemResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>ReturnDocItems o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/warehousedocitem/delete/<%=returnWarwDocItemResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=returnWarwDocItemResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>ReturnWarwDocItems o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/warehousedocitem/<%=returnWarwDocItemResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=returnWarwDocItemResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleDocument" class="form-label"> DocItems documents</label>
                                        <select  name="documentId" id="exampleDocument" class="form-control" required>
                                            <option value="" selected>Return Document tanlang</option>
                                            <% for (ReturnWarwDocResDTO returnWarwDocResDTO : returnWareDocList) {%>
                                            <option value="<%=returnWarwDocResDTO.getId()%>"><%=returnWarwDocResDTO.getDocNumber()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleProduct" class="form-label"> DocItems products</label>
                                        <select  name="productId" id="exampleProduct" class="form-control" required>
                                            <option value="" selected>Product tanlang</option>
                                            <% for (ProductResDTO productResDTO : productDTOList) {%>
                                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleProduct" class="form-label"> DocItems products</label>
                                        <select  name="storeProductId" id="exampleStoreProduct" class="form-control" required>
                                            <option value="" selected>Store Product tanlang</option>
                                            <% for (StoreProductResDTO storeProductResDTO : storeProductDTOList) {%>
                                            <option value="<%=storeProductResDTO.getId()%>"><%=storeProductResDTO.getProductResDTO().getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCount" class="form-label">Warehouse Count</label>
                                        <input type="text" value="<%=returnWarwDocItemResDTO.getCount()%>" name="count" class="form-control" id="exampleCount" required>
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
            <form action="/market/warehousedocitem" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleDocument2" class="form-label">DocItems document</label>
                        <select name="documentId" id="exampleDocument2" class="form-control" required>
                            <option value="" selected>Return Document tanlang</option>
                            <% for (ReturnWarwDocResDTO returnWarwDocResDTO : returnWareDocList) {%>
                            <option value="<%=returnWarwDocResDTO.getId()%>"><%=returnWarwDocResDTO.getDocNumber()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleProduct2" class="form-label">DocItems product</label>
                        <select name="productId" id="exampleProduct2" class="form-control" required>
                            <option value="" selected>Product tanlang</option>
                            <% for (ProductResDTO productResDTO : productDTOList) {%>
                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleStoreProduct2" class="form-label">DocItems product</label>
                        <select name="storeProductId" id="exampleStoreProduct2" class="form-control" required>
                            <option value="" selected> Store Product tanlang</option>
                            <% for (StoreProductResDTO storeProductResDTO : storeProductDTOList) {%>
                            <option value="<%=storeProductResDTO.getId()%>"><%=storeProductResDTO.getProductResDTO().getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCount2" class="form-label">Warehouse count</label>
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