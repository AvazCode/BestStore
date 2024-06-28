<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO.*" %>
<%@ page import="com.example.marketplace.dto.responseDTO.DocumentResDTO.*" %>
<%@ page import="com.example.marketplace.entity.DocItems" %>
<%@ page import="com.example.marketplace.entity.StoreProduct" %>
<%@ include file="header.jsp"%>
<%List<SellDocItemResDTO> sellDocItemList = (List<SellDocItemResDTO>) request.getAttribute("sellDocItemList");%>
<%List<StoreProductResDTO> productDTOList = (List<StoreProductResDTO>) request.getAttribute("productList");%>
<%List<SellDocResDTO> sellDocDTOList = (List<SellDocResDTO>) request.getAttribute("sellDocList");%>

<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>SellDocItem Id</th>
                <th>SellDocItem document</th>
                <th>SellDocItem product</th>
                <th>Count</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (SellDocItemResDTO sellDocItemResDTO : sellDocItemList) {%>
            <tr>
                <td><%=sellDocItemResDTO.getId()%></td>
                <td><%=sellDocItemResDTO.getSellDocResDTO().getDocNumber()%></td>
                <td><%=sellDocItemResDTO.getStoreProductResDTO().getId()%></td>
                <td><%=sellDocItemResDTO.getCount()%></td>
                <td><%=sellDocItemResDTO.getPrice()%></td>

                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=sellDocItemResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=sellDocItemResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=sellDocItemResDTO.getId()%>" tabindex="-1">
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
                                <a href="<%=request.getContextPath()%>/market/selldocitem/delete/<%=sellDocItemResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=sellDocItemResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>SellDocItems o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/selldocitem/<%=sellDocItemResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=sellDocItemResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleDocument" class="form-label"> DocItems documents</label>
                                        <select  name="documentId" id="exampleDocument" class="form-control" required>
                                            <option value="" selected>Sell Document tanlang</option>
                                            <% for (SellDocResDTO sellDocResDTO : sellDocDTOList) {%>
                                            <option value="<%=sellDocResDTO.getId()%>"><%=sellDocResDTO.getDocNumber()%></option>
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
                                        <input type="text" value="<%=sellDocItemResDTO.getCount()%>" name="count" class="form-control" id="exampleCount" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="examplePrice" class="form-label">StoreDocItem Count</label>
                                        <input type="text" value="<%=sellDocItemResDTO.getPrice()%>" name="price" class="form-control" id="examplePrice" required>
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
            <form action="/market/selldocitem" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleDocument2" class="form-label">DocItems document</label>
                        <select name="documentId" id="exampleDocument2" class="form-control" required>
                            <option value="" selected>Sell Document tanlang</option>
                            <% for (SellDocResDTO sellDocResDTO : sellDocDTOList) {%>
                            <option value="<%=sellDocResDTO.getId()%>"><%=sellDocResDTO.getDocNumber()%></option>
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
                        <label for="exampleCount2" class="form-label">SellDocItem count</label>
                        <input type="text" name="count" class="form-control" id="exampleCount2" required>
                    </div>
                    <div class="mb-3">
                        <label for="examplePrice2" class="form-label">SellDocItem price</label>
                        <input type="text" name="price" class="form-control" id="examplePrice2" required>
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