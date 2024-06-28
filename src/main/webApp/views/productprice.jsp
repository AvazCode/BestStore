
<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductPriceResDTO" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO" %>
<%@ include file="header.jsp"%>
<%List<ProductResDTO> productResDTOList = (List<ProductResDTO>) request.getAttribute("productList");%>
<%List<ProductPriceResDTO> productPriceDTOList = (List<ProductPriceResDTO>) request.getAttribute("productPriceList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>ID</th>
                <th>Mahsulot</th>
                <th>Narx</th>
                <th>Sana</th>
                <th>Status</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (ProductPriceResDTO productPriceResDTO : productPriceDTOList) {%>
            <tr>
                <td><%=productPriceResDTO.getId()%></td>
                <td><%=productPriceResDTO.getProductResDTO().getName()%></td>
                <td><%=productPriceResDTO.getPrice()%></td>
                <td><%=productPriceResDTO.getDate()%></td>
                <td><%=productPriceResDTO.getStatus() ? "Faol" : "Faol emas"%></td>
                <%--                <td><%=productPriceResDTO.getProductBuyPrice().getPrice()%></td>--%>
                <%--                <td><%=productPriceResDTO.getProductSellPrice().getPrice()%></td>--%>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=productPriceResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=productPriceResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=productPriceResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Product price o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/productprice/delete/<%=productPriceResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=productPriceResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Kategoriya o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/productprice/<%=productPriceResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=productPriceResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="productSelect" class="form-label">Mahsulot</label>
                                        <select  name="productId" id="productSelect" class="form-control" required>
                                            <option value="" selected>Maxsulot tanlang</option>
                                            <% for (ProductResDTO productResDTO : productResDTOList) {%>
                                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="productPrice" class="form-label">Product price</label>
                                        <input type="text" value="<%=productPriceResDTO.getPrice()%>" name="price" class="form-control" id="productPrice" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice4" class="form-label">Choose a date and time:</label>
                                        <input type="datetime-local" value="<%=productPriceResDTO.getDate()%>" name="date" class="form-control" id="exampleBuyPrice4" required>
                                    </div>
                                    <div class="mb-3 form-check">
                                        <input type="checkbox" name="status" class="form-check-input" value="false" id="statusCheck">
                                        <label class="form-check-label" for="statusCheck">No Faol</label>
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
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi mahsulot narxi qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/productprice" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCategory2" class="form-label">Mahsulot</label>
                        <select name="productId" id="exampleCategory2" class="form-control" required>
                            <option value="" selected>Maxsulot tanlang</option>
                            <% for (ProductResDTO productResDTO : productResDTOList) {%>
                            <option value="<%=productResDTO.getId()%>"><%=productResDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="productPrice2" class="form-label">Mahsulot narxi</label>
                        <input type="text" name="price" class="form-control" id="productPrice2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleBuyPrice3" class="form-label">Choose a date and time:</label>
                        <input type="datetime-local"  name="date" class="form-control" id="exampleBuyPrice3" required>
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" name="status" class="form-check-input" id="statusCheck2">
                        <label class="form-check-label" for="statusCheck2">Faol</label>
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