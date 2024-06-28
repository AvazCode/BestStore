
<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>

<%@ include file="header.jsp"%>
<%List<ProductResDTO> productResDTOList = (List<ProductResDTO>) request.getAttribute("productList");%>
<%List<StoreProductResDTO> storeProductDTOList = (List<StoreProductResDTO>) request.getAttribute("storeProductList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Store product ID</th>
                <th>Product nomi</th>
                <th>Store Product amount</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (StoreProductResDTO storeProductResDTO : storeProductDTOList) {%>
            <tr>
                <td><%=storeProductResDTO.getId()%></td>
                <td><%=storeProductResDTO.getProductResDTO().getName()%></td>
                <td><%=storeProductResDTO.getAmount()%></td>
                <%--                <td><%=storeProductResDTO.getProductBuyPrice().getPrice()%></td>--%>
                <%--                <td><%=storeProductResDTO.getProductSellPrice().getPrice()%></td>--%>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=storeProductResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=storeProductResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=storeProductResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Store product o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/storeproduct/delete/<%=storeProductResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=storeProductResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Store product o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/storeproduct/<%=storeProductResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=storeProductResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleCategory2" class="form-label">Mahsulot kategoriyasi</label>
                                        <select  name="productId" id="exampleCategory" class="form-control" required>
                                            <option value="" selected>Kategoriya tanlang</option>
                                            <% for (ProductResDTO productResDTO : productResDTOList) {%>
                                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice2" class="form-label">Mahsulot miqdori</label>
                                        <input type="text" value="<%=storeProductResDTO.getAmount()%>" name="amount" class="form-control" id="exampleBuyPrice" required>
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
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi mahsulot qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/storeproduct" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCategory2" class="form-label"> Store product</label>
                        <select name="productId" id="exampleCategory2" class="form-control" required>
                            <option value="" selected> Product tanlang</option>
                            <% for (ProductResDTO productResDTO : productResDTOList) {%>
                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleBuyPrice2" class="form-label">Mahsulot miqdori</label>
                        <input type="text" name="amount" class="form-control" id="exampleBuyPrice2" required>
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