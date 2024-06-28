<%@ page import="java.util.List" %>
<%@ page import="com.example.marketplace.dto.responseDTO.*" %>
<%@ include file="header.jsp"%>
<%List<DocumentResDTO> documentDTOList = (List<DocumentResDTO>) request.getAttribute("documentList");%>
<%List<CompanyResDTO> companyDTOList = (List<CompanyResDTO>) request.getAttribute("companyList");%>
<div class="d-grid gap-2 d-md-flex justify-content-md-end mb-2">
    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target=".bd-example-modal-c" type="button"><i class="fa-solid fa-plus mx-sm-1"></i>Mahsulot qo'shish</button>
</div>
<div class="col-12 col-lg-12 col-xxl-9 d-flex">
    <div class="card flex-fill">
        <table class="table table-hover my-0">
            <thead>
            <tr>
                <th>Accept_doc Id</th>
                <th>Accept_doc Number</th>
                <th>Company Name</th>
                <th>Date date</th>
                <th>Amallar</th>
            </tr>
            </thead>
            <tbody>
            <% for (DocumentResDTO documentResDTO : documentDTOList) {%>
            <tr>
                <td><%=documentResDTO.getId()%></td>
                <td><%=documentResDTO.getDocument_number()%></td>
                <td><%=documentResDTO.getCompanyResDTO().getName()%></td>
                <td><%=documentResDTO.getDate()%></td>
                <td>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-a<%=documentResDTO.getId()%>" class="btn btn-warning"><i class="fa-solid fa-pen-to-square mx-sm-1"></i>O'zgartirish</button>
                    <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-b<%=documentResDTO.getId()%>" class="btn btn-danger"><i class="fa-solid fa-trash-can mx-sm-1"></i>O'chirish</button>
                </td>
                <%--Modal for delete--%>
                <div class="modal fade bd-example-modal-b<%=documentResDTO.getId()%>" tabindex="-1">
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
                                <a href="<%=request.getContextPath()%>/market/accept/delete/<%=documentResDTO.getId()%>" class="btn btn-danger">O'chirish</a>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal for update--%>
                <div class="modal fade bd-example-modal-a<%=documentResDTO.getId()%>" aria-labelledby="exampleModalEditCategory" tabindex="-1">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalEditCategory"><b>Kategoriya o'zgartirish</b></h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <form action="/market/accept/<%=documentResDTO.getId()%>" method="post">
                                <input type="hidden" name="id" value="<%=documentResDTO.getId()%>">
                                <div class="modal-body">
                                    <div class="mb-3">
                                        <label for="exampleProductName2" class="form-label">Mahsulot nomi</label>
                                        <input type="text" value="<%=documentResDTO.getDocument_number()%>" name="number" class="form-control" id="exampleProductName" required>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleCategory2" class="form-label">Accept_doc company</label>
                                        <select  name="companyId" id="exampleCategory" class="form-control" required>
                                            <option value="" selected>Company tanlang</option>
                                            <% for (CompanyResDTO companyResDTO : companyDTOList) {%>
                                            <option value="<%=companyResDTO.getId()%>"><%=companyResDTO.getName()%></option>
                                            <%}%>
                                        </select>
                                    </div>
                                    <div class="mb-3">
                                        <label for="exampleBuyPrice2" class="form-label">Choose a date and time:</label>
                                        <input type="datetime-local" value="<%=documentResDTO.getDate()%>" name="date-local" class="form-control" id="exampleBuyPrice" required>
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
            <form action="/market/accept" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleProductName2" class="form-label">Accept_doc number</label>
                        <input type="text" name="number" class="form-control" id="exampleProductName2" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCategory2" class="form-label">Accept_doc company</label>
                        <select name="companyId" id="exampleCategory2" class="form-control" required>
                            <option value="" selected>Company tanlang</option>
                            <% for (CompanyResDTO companyResDTO : companyDTOList) {%>
                            <option value="<%=companyResDTO.getId()%>"><%=companyResDTO.getName()%></option>
                            <%}%>
                        </select>
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