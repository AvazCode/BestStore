<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ page import="com.example.marketplace.entity.StoreDoc" %>
<%@ include file="header.jsp"%>
<%List<StoreDocResDTO> storeDocList = (List<StoreDocResDTO>) request.getAttribute("storeDocList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Store_doc Id</th>
                <th>Store_doc Number</th>
                <th>Date date</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (StoreDocResDTO storeDocResDTO: storeDocList) {%>
            <tr>
                <td><%=storeDocResDTO.getId()%></td>
                <td><%=storeDocResDTO.getDocNumber()%></td>
                <td><%=storeDocResDTO.getData()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=storeDocResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=storeDocResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=storeDocResDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>Accept_doc o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/storedoc/delete/<%=storeDocResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=storeDocResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Store Document o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/storedoc/<%=storeDocResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=storeDocResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleProductName2" class="form-label">Store Document nomi</label>
                                        <input type="text" value="<%=storeDocResDTO.getDocNumber()%>" name="number" class="form-control" id="exampleProductName" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice2" class="form-label">Choose a date and time:</label>
                                        <input type="datetime-local" value="<%=storeDocResDTO.getData()%>" name="date-local" class="form-control" id="exampleBuyPrice" required>
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
                <h5 class="modal-title" id="exampleModalCategory2"><b>Yangi store document qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/storedoc" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleProductName2" class="form-label">Store Document number</label>
                        <input type="text" name="number" class="form-control" id="exampleProductName2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleBuyPrice2" class="form-label">Choose a date and time:</label>
                        <input type="datetime-local" name="date-local" class="form-control" id="exampleBuyPrice2" required>
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