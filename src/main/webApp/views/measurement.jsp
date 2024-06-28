
<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.MeasurementResDTO" %>
<%@ include file="header.jsp"%>
<%List<MeasurementResDTO> unitTypeDTOList = (List<MeasurementResDTO>) request.getAttribute("measureList");%>
<%--<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">--%>
<%--    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>O'lchov birligi qo'shish</button>--%>
<%--</div>--%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Kategoriya qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>O'chov birligi ID</th>
                <th>O'chov birligi nomi</th>
                <%--                <th>Amallar</th>--%>
            </tr>
            </thead>
            <tbody>
            <% for (MeasurementResDTO unitTypeDTO : unitTypeDTOList) {%>
            <tr>
                <td><%=unitTypeDTO.getId()%></td>
                <td><%=unitTypeDTO.getName()%></td>
                              <td>
                                <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=unitTypeDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                             <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=unitTypeDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                        </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=unitTypeDTO.getId()%>" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title"><b>O'chov birligi o'chirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <h4>Haqiqatan ham o'chirib tashlamoqchimisiz?</h4>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Bekor qilish</button>
                                <a href="<%=request.getContextPath()%>/market/measurement/delete/<%=unitTypeDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=unitTypeDTO.getId()%>" aria-labelledby="exampleModalEditUnitType" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditUnitType"><b>O'lchov birligi o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/measurement/<%=unitTypeDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=unitTypeDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleUnitTypeName" class="form-label">O'lchov birligi nomi</label>
                                        <input type="text" name="name" class="form-control" id="exampleUnitTypeName" value="<%=unitTypeDTO.getName()%>" required>
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
<div class="modal fade bd-example-modal-c" aria-labelledby="exampleModalUnitType2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalUnitType2"><b>Yangi o'lchov qo'shish</b></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="/market/measurement" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleUnitTypeName2" class="form-label">O'lchov birlik nomi</label>
                        <input type="text" name="name" class="form-control" id="exampleUnitTypeName2" required>
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