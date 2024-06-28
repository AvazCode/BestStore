
<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.ProductResDTO" %>
<%@ page import="com.example.marketplace.dto.responseDTO.CategoryResDTO" %>
<%@ page import="com.example.marketplace.dto.responseDTO.MeasurementResDTO" %>
<%@ include file="header.jsp"%>
<%List<ProductResDTO> productDTOList = (List<ProductResDTO>) request.getAttribute("productList");%>
<%List<CategoryResDTO> categoryDTOList = (List<CategoryResDTO>) request.getAttribute("categoryList");%>
<%List<MeasurementResDTO> unitTypeDTOList = (List<MeasurementResDTO>) request.getAttribute("measurementList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Mahsulot ID</th>
                <th>Mahsulot nomi</th>
                <th>Kategoriya nomi</th>
                <th>Mahsulot miqdori</th>
                <th>O'lchov birligi</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (ProductResDTO productDTO : productDTOList) {%>
            <tr>
                <td><%=productDTO.getId()%></td>
                <td><%=productDTO.getName()%></td>
                <td><%=productDTO.getCategoryResDTO().getName()%></td>
                <td><%=productDTO.getAmount()%></td>
                <td><%=productDTO.getMeasurementResDTO().getName()%></td>
                <%--                <td><%=productDTO.getProductBuyPrice().getPrice()%></td>--%>
                <%--                <td><%=productDTO.getProductSellPrice().getPrice()%></td>--%>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=productDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=productDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=productDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Kategoriya o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/product/delete/<%=productDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=productDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Kategoriya o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/product/<%=productDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=productDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleProductName2" class="form-label">Mahsulot nomi</label>
                                        <input type="text" value="<%=productDTO.getName()%>" name="name" class="form-control" id="exampleProductName" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCategory2" class="form-label">Mahsulot kategoriyasi</label>
                                        <select  name="categoryId" id="exampleCategory" class="form-control" required>
                                            <option value="" selected>Kategoriya tanlang</option>
                                            <% for (CategoryResDTO categoryDTO : categoryDTOList) {%>
                                            <option value="<%=categoryDTO.getId()%>"><%=categoryDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleUnitType2" class="form-label">O'lchov birligi</label>
                                        <select name="unitTypeId" id="exampleUnitType" class="form-control" required>
                                            <option value="" selected>O'lchov birlik tanlang</option>
                                            <% for (MeasurementResDTO unitTypeDTO : unitTypeDTOList) {%>
                                            <option value="<%=unitTypeDTO.getId()%>"><%=unitTypeDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice2" class="form-label">Mahsulot miqdori</label>
                                        <input type="text" value="<%=productDTO.getAmount()%>" name="amount" class="form-control" id="exampleBuyPrice" required>
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
            <form action="/market/product" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleProductName2" class="form-label">Mahsulot nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleProductName2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCategory2" class="form-label">Mahsulot kategoriyasi</label>
                        <select name="categoryId" id="exampleCategory2" class="form-control" required>
                            <option value="" selected>Kategoriya tanlang</option>
                            <% for (CategoryResDTO categoryDTO : categoryDTOList) {%>
                            <option value="<%=categoryDTO.getId()%>"><%=categoryDTO.getName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleUnitType2" class="form-label">O'lchov birligi</label>
                        <select name="unitTypeId" id="exampleUnitType2" class="form-control" required>
                            <option value="" selected>O'lchov birlik tanlang</option>
                            <% for (MeasurementResDTO unitTypeDTO : unitTypeDTOList) {%>
                            <option value="<%=unitTypeDTO.getId()%>"><%=unitTypeDTO.getName()%></option>
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